package com.jenventory.jenventoryapi.service;

import com.jenventory.jenventoryapi.dto.request.TransactionRequest;
import com.jenventory.jenventoryapi.dto.response.TransactionResponse;
import com.jenventory.jenventoryapi.dto.response.TransactionSummaryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TransactionService {

    TransactionResponse create(TransactionRequest request);

    Page<TransactionSummaryResponse> getAll(Pageable pageable);

    Optional<TransactionResponse> findById(Long id);

    Page<TransactionSummaryResponse> getCustomerTransactions(Long customerId, Pageable pageable);


}
