package com.jenventory.jenventoryapi.transaction.service.impl;

import com.jenventory.jenventoryapi.common.exception.BusinessRuleException;
import com.jenventory.jenventoryapi.common.exception.ResourceNotFoundException;
import com.jenventory.jenventoryapi.customer.entity.Customer;
import com.jenventory.jenventoryapi.customer.repository.CustomerRepository;
import com.jenventory.jenventoryapi.transaction.dto.request.DebtPaymentMethodRequest;
import com.jenventory.jenventoryapi.transaction.dto.request.DebtPaymentRequest;
import com.jenventory.jenventoryapi.transaction.dto.response.DebtLedgerResponse;
import com.jenventory.jenventoryapi.transaction.dto.response.DebtSummaryResponse;
import com.jenventory.jenventoryapi.transaction.entity.DebtLedger;
import com.jenventory.jenventoryapi.transaction.enums.DebtLedgerType;
import com.jenventory.jenventoryapi.transaction.enums.PaymentMethod;
import com.jenventory.jenventoryapi.transaction.mapper.DebtLedgerMapper;
import com.jenventory.jenventoryapi.transaction.repository.DebtLedgerRepository;
import com.jenventory.jenventoryapi.transaction.service.DebtService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class DebtServiceImpl implements DebtService {

    private final CustomerRepository customerRepository;
    private final DebtLedgerRepository debtLedgerRepository;
    private final DebtLedgerMapper debtLedgerMapper;

    @Override
    @Transactional
    public DebtSummaryResponse recordDebtPayment(Long customerId, DebtPaymentRequest request) {
        Customer customer = customerRepository.findByIdAndActiveTrue(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Active customer not found with id: " + customerId));

        BigDecimal totalDebts = debtLedgerRepository.sumAmountByCustomerIdAndType(customerId, DebtLedgerType.DEBT);
        BigDecimal totalPayments = debtLedgerRepository.sumAmountByCustomerIdAndType(customerId, DebtLedgerType.PAYMENT);
        BigDecimal totalCredits = debtLedgerRepository.sumAmountByCustomerIdAndType(customerId, DebtLedgerType.CREDIT);
        BigDecimal totalCreditsUsed = debtLedgerRepository.sumAmountByCustomerIdAndType(customerId, DebtLedgerType.CREDIT_USED);

        BigDecimal netDebt = totalDebts.subtract(totalPayments).subtract(totalCreditsUsed);

        if (netDebt.compareTo(BigDecimal.ZERO) <= 0) {
            throw new BusinessRuleException("Customer has no outstanding debt.");
        }

        BigDecimal totalPaymentAmount = request.getPayments().stream()
                .map(DebtPaymentMethodRequest::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (totalPaymentAmount.compareTo(netDebt) > 0) {
            throw new BusinessRuleException("Payment amount exceeds outstanding debt of " + netDebt);
        }

        request.getPayments().forEach(payment -> {
            /*
             * TODO: Account for multiple "CREDIT_USED" payments in the same request.
             */
            if (payment.getMethod().equals("CREDIT_USED")) {
                BigDecimal creditBalance = totalCredits.subtract(totalCreditsUsed);
                if (creditBalance.compareTo(payment.getAmount()) < 0) {
                    throw new BusinessRuleException("Insufficient credit balance. Available credit: " + creditBalance);
                }
                debtLedgerRepository.save(DebtLedger.builder()
                        .customer(customer)
                        .transaction(null)
                        .type(DebtLedgerType.CREDIT_USED)
                        .amount(payment.getAmount())
                        .paymentMethod(null)
                        .notes(request.getNotes())
                        .build());
                return;
            }

            debtLedgerRepository.save(DebtLedger.builder()
                    .customer(customer)
                    .transaction(null)
                    .type(DebtLedgerType.PAYMENT)
                    .amount(payment.getAmount())
                    .paymentMethod(PaymentMethod.valueOf(payment.getMethod()))
                    .notes(request.getNotes())
                    .build());
        });

        BigDecimal updatedTotalPayments = debtLedgerRepository.sumAmountByCustomerIdAndType(customerId, DebtLedgerType.PAYMENT);
        BigDecimal updatedTotalCreditsUsed = debtLedgerRepository.sumAmountByCustomerIdAndType(customerId, DebtLedgerType.CREDIT_USED);
        BigDecimal updatedNetDebt = totalDebts.subtract(updatedTotalPayments).subtract(updatedTotalCreditsUsed);
        BigDecimal updatedNetCredit = totalCredits.subtract(updatedTotalCreditsUsed);

        return debtLedgerMapper.toSummaryResponse(totalDebts, totalCredits, updatedTotalPayments, updatedTotalCreditsUsed, updatedNetDebt, updatedNetCredit);
    }

    @Override
    @Transactional(readOnly = true)
    public DebtSummaryResponse getDebtSummary(Long customerId) {
        BigDecimal totalDebts = debtLedgerRepository.sumAmountByCustomerIdAndType(customerId, DebtLedgerType.DEBT);
        BigDecimal totalPayments = debtLedgerRepository.sumAmountByCustomerIdAndType(customerId, DebtLedgerType.PAYMENT);
        BigDecimal totalCredits = debtLedgerRepository.sumAmountByCustomerIdAndType(customerId, DebtLedgerType.CREDIT);
        BigDecimal totalCreditsUsed = debtLedgerRepository.sumAmountByCustomerIdAndType(customerId, DebtLedgerType.CREDIT_USED);

        BigDecimal netDebt = totalDebts.subtract(totalPayments).subtract(totalCreditsUsed);
        BigDecimal netCredit = totalCredits.subtract(totalCreditsUsed);

        return debtLedgerMapper.toSummaryResponse(totalDebts, totalCredits, totalPayments, totalCreditsUsed, netDebt, netCredit);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DebtLedgerResponse> getDebtHistory(Long customerId, DebtLedgerType type, Pageable pageable) {
        if (type == null) {
            return debtLedgerRepository.findAllByCustomerId(customerId, pageable)
                    .map(debtLedgerMapper::toResponse);
        }

        return debtLedgerRepository.findAllByCustomerIdAndType(customerId, type, pageable)
                .map(debtLedgerMapper::toResponse);
    }

}
