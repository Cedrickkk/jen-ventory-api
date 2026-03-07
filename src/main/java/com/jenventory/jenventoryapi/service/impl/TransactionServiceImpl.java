package com.jenventory.jenventoryapi.service.impl;

import com.jenventory.jenventoryapi.dto.request.TransactionRequest;
import com.jenventory.jenventoryapi.dto.response.TransactionResponse;
import com.jenventory.jenventoryapi.dto.response.TransactionSummaryResponse;
import com.jenventory.jenventoryapi.entity.Customer;
import com.jenventory.jenventoryapi.exception.ResourceNotFoundException;
import com.jenventory.jenventoryapi.repository.CustomerRepository;
import com.jenventory.jenventoryapi.repository.DebtLedgerRepository;
import com.jenventory.jenventoryapi.repository.ProductVariantRepository;
import com.jenventory.jenventoryapi.repository.TransactionRepository;
import com.jenventory.jenventoryapi.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final DebtLedgerRepository debtLedgerRepository;
    private final CustomerRepository customerRepository;
    private final ProductVariantRepository productVariantRepository;

    @Override
    @Transactional
    public TransactionResponse create(TransactionRequest request) {
        Customer customer = null;

        if (request.getCustomerId() != null) {
            customer = customerRepository.findByIdAndActiveTrue(request.getCustomerId())
                    .orElseThrow(() -> new ResourceNotFoundException("Active customer not found with id: " + request.getCustomerId()));
        }


        return null;
    }

    @Override
    public Page<TransactionSummaryResponse> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<TransactionResponse> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Page<TransactionSummaryResponse> getCustomerTransactions(Long customerId, Pageable pageable) {
        return null;
    }
}
