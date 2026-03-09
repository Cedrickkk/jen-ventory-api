package com.jenventory.jenventoryapi.service;

import com.jenventory.jenventoryapi.dto.request.TransactionRequest;
import com.jenventory.jenventoryapi.dto.response.TransactionResponse;
import com.jenventory.jenventoryapi.dto.response.TransactionSummaryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransactionService {

    TransactionResponse create(TransactionRequest request);

    Page<TransactionSummaryResponse> getAll(Pageable pageable);

    TransactionResponse findById(Long id);

    Page<TransactionSummaryResponse> getCustomerTransactions(Long customerId, Pageable pageable);

}
