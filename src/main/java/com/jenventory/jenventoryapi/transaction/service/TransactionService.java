package com.jenventory.jenventoryapi.transaction.service;

import com.jenventory.jenventoryapi.customer.dto.response.CustomerTransactionResponse;
import com.jenventory.jenventoryapi.transaction.dto.request.TransactionRequest;
import com.jenventory.jenventoryapi.transaction.dto.response.TransactionResponse;
import com.jenventory.jenventoryapi.transaction.dto.response.TransactionSummaryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransactionService {

    TransactionResponse create(TransactionRequest request);

    Page<TransactionSummaryResponse> getAll(Pageable pageable);

    TransactionResponse findById(Long id);

    Page<CustomerTransactionResponse> getCustomerTransactions(Long customerId, Pageable pageable);

}
