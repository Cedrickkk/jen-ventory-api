package com.jenventory.jenventoryapi.mapper;


import com.jenventory.jenventoryapi.dto.request.TransactionRequest;
import com.jenventory.jenventoryapi.dto.response.TransactionResponse;
import com.jenventory.jenventoryapi.entity.Customer;
import com.jenventory.jenventoryapi.entity.Transaction;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TransactionMapper {

    public Transaction toEntity(TransactionRequest request, Customer customer, BigDecimal totalAmount) {
        return Transaction.builder()
                .customer(customer)
                .totalAmount(totalAmount)
                .representative(request.getRepresentative())
                .notes(request.getNotes())
                .build();
    }

    public TransactionResponse toResponse(Transaction transaction) {
        return TransactionResponse.builder()
                .customerId(transaction.getCustomer().getId())
                .customerName(transaction.getCustomer().getName())
                .representative(transaction.getRepresentative())
                .notes(transaction.getNotes())
                .totalAmount(transaction.getTotalAmount())
                .createdAt(transaction.getCreatedAt())
                .build();
    }

}
