package com.jenventory.jenventoryapi.transaction.service.impl;

import com.jenventory.jenventoryapi.common.exception.BusinessRuleException;
import com.jenventory.jenventoryapi.common.exception.ResourceNotFoundException;
import com.jenventory.jenventoryapi.customer.dto.response.CustomerTransactionResponse;
import com.jenventory.jenventoryapi.customer.entity.Customer;
import com.jenventory.jenventoryapi.customer.mapper.CustomerMapper;
import com.jenventory.jenventoryapi.customer.repository.CustomerRepository;
import com.jenventory.jenventoryapi.product.entity.ProductVariant;
import com.jenventory.jenventoryapi.product.enums.StockMovementReason;
import com.jenventory.jenventoryapi.product.mapper.StockMovementMapper;
import com.jenventory.jenventoryapi.product.repository.ProductVariantRepository;
import com.jenventory.jenventoryapi.product.repository.StockMovementRepository;
import com.jenventory.jenventoryapi.transaction.dto.request.TransactionItemRequest;
import com.jenventory.jenventoryapi.transaction.dto.request.TransactionPaymentRequest;
import com.jenventory.jenventoryapi.transaction.dto.request.TransactionRequest;
import com.jenventory.jenventoryapi.transaction.dto.response.TransactionResponse;
import com.jenventory.jenventoryapi.transaction.dto.response.TransactionSummaryResponse;
import com.jenventory.jenventoryapi.transaction.entity.Transaction;
import com.jenventory.jenventoryapi.transaction.entity.TransactionItem;
import com.jenventory.jenventoryapi.transaction.entity.TransactionPayment;
import com.jenventory.jenventoryapi.transaction.enums.DebtLedgerType;
import com.jenventory.jenventoryapi.transaction.enums.PaymentMethod;
import com.jenventory.jenventoryapi.transaction.mapper.DebtLedgerMapper;
import com.jenventory.jenventoryapi.transaction.mapper.TransactionItemMapper;
import com.jenventory.jenventoryapi.transaction.mapper.TransactionMapper;
import com.jenventory.jenventoryapi.transaction.mapper.TransactionPaymentMapper;
import com.jenventory.jenventoryapi.transaction.repository.DebtLedgerRepository;
import com.jenventory.jenventoryapi.transaction.repository.TransactionItemRepository;
import com.jenventory.jenventoryapi.transaction.repository.TransactionPaymentRepository;
import com.jenventory.jenventoryapi.transaction.repository.TransactionRepository;
import com.jenventory.jenventoryapi.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final DebtLedgerRepository debtLedgerRepository;
    private final CustomerRepository customerRepository;
    private final ProductVariantRepository productVariantRepository;
    private final TransactionMapper transactionMapper;
    private final TransactionItemMapper transactionItemMapper;
    private final TransactionItemRepository transactionItemRepository;
    private final StockMovementRepository stockMovementRepository;
    private final TransactionPaymentRepository transactionPaymentRepository;
    private final TransactionPaymentMapper transactionPaymentMapper;
    private final DebtLedgerMapper debtLedgerMapper;
    private final StockMovementMapper stockMovementMapper;
    private final CustomerMapper customerMapper;

    @Override
    @Transactional
    public TransactionResponse create(TransactionRequest request) {
        Customer customer;

        /*
         * Resolve customer
         */
        if (request.getCustomerId() != null) {
            customer = customerRepository.findByIdAndActiveTrue(request.getCustomerId())
                    .orElseThrow(() -> new ResourceNotFoundException("Active customer not found with id: " + request.getCustomerId()));
        } else {
            customer = null; // Walk-in customer
        }

        /*
         * Validate CREDIT_USED payment
         */
        request.getPayments().forEach(payment -> {
            if (PaymentMethod.valueOf(payment.getPaymentMethod()) == PaymentMethod.CREDIT_USED) {
                if (customer == null) {
                    throw new BusinessRuleException("Walk-in customer cannot use credit.");
                }

                BigDecimal creditBalance = debtLedgerRepository.sumAmountByCustomerIdAndType(customer.getId(), DebtLedgerType.CREDIT)
                        .subtract(debtLedgerRepository.sumAmountByCustomerIdAndType(customer.getId(), DebtLedgerType.CREDIT_USED));

                if (creditBalance.compareTo(payment.getAmount()) < 0) {
                    throw new BusinessRuleException("Insufficient credit balance. Available credit: " + creditBalance);
                }
            }
        });

        Map<Long, ProductVariant> productVariantMap = new HashMap<>();

        /*
         * Validate product variants and stock availability
         */
        request.getItems().forEach(item -> {
            ProductVariant productVariant = productVariantRepository.findByIdAndActiveTrue(item.getProductVariantId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product variant not found with id: " + item.getProductVariantId()));

            if (productVariant.getStockQuantity() < item.getQuantity()) {
                throw new BusinessRuleException("Insufficient stock for sku: " + productVariant.getSku());
            }

            productVariantMap.put(item.getProductVariantId(), productVariant);
        });

        BigDecimal totalAmount = BigDecimal.ZERO;

        for (TransactionItemRequest itemRequest : request.getItems()) {
            ProductVariant productVariant = productVariantMap.get(itemRequest.getProductVariantId());
            totalAmount = totalAmount.add(productVariant.getPrice().multiply(BigDecimal.valueOf(itemRequest.getQuantity())));
        }

        BigDecimal totalPaidAmount = request.getPayments().stream()
                .map(TransactionPaymentRequest::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal difference = totalAmount.subtract(totalPaidAmount);

        if (difference.compareTo(BigDecimal.ZERO) > 0) {
            if (!request.isAllowDebt()) {
                throw new BusinessRuleException("Underpayment. Enable allow debt to put remainder on debt.");
            }
            if (customer == null) {
                throw new BusinessRuleException("Cannot create debt for walk-in customer.");
            }
        }

        Transaction transaction = transactionRepository.save(transactionMapper.toEntity(request, customer, totalAmount));

        request.getItems().forEach(item -> {
            ProductVariant productVariant = productVariantMap.get(item.getProductVariantId());

            transactionItemRepository.save(transactionItemMapper.toEntity(item, transaction, productVariant));

            productVariant.deductStock(item.getQuantity());
            productVariantRepository.save(productVariant);

            stockMovementRepository.save(stockMovementMapper.toEntity(
                    productVariant,
                    transaction,
                    StockMovementReason.SOLD,
                    -item.getQuantity(),
                    null)
            );
        });

        request.getPayments().forEach(payment -> {
            if (PaymentMethod.valueOf(payment.getPaymentMethod()) == PaymentMethod.CREDIT_USED) {
                this.saveDebtEntry(customer, transaction, DebtLedgerType.CREDIT_USED, payment.getAmount());
            }
            transactionPaymentRepository.save(transactionPaymentMapper.toEntity(payment, transaction));
        });

        /*
         * DEBT: underpayment
         */
        if (difference.compareTo(BigDecimal.ZERO) > 0 && request.isAllowDebt()) {
            this.saveDebtEntry(customer, transaction, DebtLedgerType.DEBT, difference.abs());
        }

        /*
         * CREDIT: overpayment
         */
        if (difference.compareTo(BigDecimal.ZERO) < 0 && request.isStoreChangeAsCredit()) {
            this.saveDebtEntry(customer, transaction, DebtLedgerType.CREDIT, difference.abs());
        }

        List<TransactionItem> savedItems = transactionItemRepository.findAllByTransactionId(transaction.getId());
        List<TransactionPayment> savedPayments = transactionPaymentRepository.findAllByTransactionId(transaction.getId());

        return TransactionResponse.builder()
                .id(transaction.getId())
                .customerId(customer != null ? customer.getId() : null)
                .customerName(customer != null ? customer.getName() : null)
                .representative(transaction.getRepresentative())
                .notes(transaction.getNotes())
                .totalAmount(totalAmount)
                .items(savedItems.stream().map(transactionItemMapper::toResponse).toList())
                .payments(savedPayments.stream().map(transactionPaymentMapper::toResponse).toList())
                .createdAt(transaction.getCreatedAt())
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TransactionSummaryResponse> getAll(Pageable pageable) {
        return transactionRepository.findAllWithCustomer(pageable)
                .map(transactionMapper::toSummaryResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public TransactionResponse findById(Long id) {
        Transaction transaction = transactionRepository.findByIdWithItemsAndPayments(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found with id: " + id));

        return transactionMapper.toResponse(transaction);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CustomerTransactionResponse> getCustomerTransactions(Long customerId, Pageable pageable) {
        Customer customer = customerRepository.findByIdAndActiveTrue(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Active customer not found with id: " + customerId));

        return transactionRepository.findAllByCustomerIdWithPayments(customerId, pageable)
                .map(transaction -> customerMapper.toTransactionResponse(
                        transaction,
                        transaction.getPayments().stream()
                                .map(TransactionPayment::getAmount)
                                .reduce(BigDecimal.ZERO, BigDecimal::add),
                        debtLedgerRepository.sumAmountByTransactionIdAndType(transaction.getId(), DebtLedgerType.DEBT),
                        debtLedgerRepository.sumAmountByTransactionIdAndType(transaction.getId(), DebtLedgerType.CREDIT)));
    }

    private void saveDebtEntry(Customer customer, Transaction transaction, DebtLedgerType type, BigDecimal amount) {
        debtLedgerRepository.save(debtLedgerMapper.toEntity(
                customer,
                transaction,
                type,
                null,
                null,
                amount)
        );
    }

}
