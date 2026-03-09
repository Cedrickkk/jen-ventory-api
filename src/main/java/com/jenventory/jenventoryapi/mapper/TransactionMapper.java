package com.jenventory.jenventoryapi.mapper;


import com.jenventory.jenventoryapi.customer.entity.Customer;
import com.jenventory.jenventoryapi.dto.request.TransactionRequest;
import com.jenventory.jenventoryapi.dto.response.TransactionResponse;
import com.jenventory.jenventoryapi.dto.response.TransactionSummaryResponse;
import com.jenventory.jenventoryapi.entity.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class TransactionMapper {

    private final TransactionItemMapper transactionItemMapper;
    private final TransactionPaymentMapper transactionPaymentMapper;


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
                .id(transaction.getId())
                .customerId(transaction.getCustomer() != null ? transaction.getCustomer().getId() : null)
                .customerName(transaction.getCustomer() != null ? transaction.getCustomer().getName() : null)
                .representative(transaction.getRepresentative())
                .notes(transaction.getNotes())
                .items(transaction.getItems().stream()
                        .map(transactionItemMapper::toResponse)
                        .toList())
                .payments(transaction.getPayments().stream()
                        .map(transactionPaymentMapper::toResponse)
                        .toList())
                .totalAmount(transaction.getTotalAmount())
                .createdAt(transaction.getCreatedAt())
                .build();
    }

    public TransactionSummaryResponse toSummaryResponse(Transaction transaction) {
        return TransactionSummaryResponse.builder()
                .id(transaction.getId())
                .customerId(transaction.getCustomer() != null ? transaction.getCustomer().getId() : null)
                .customerName(transaction.getCustomer() != null ? transaction.getCustomer().getName() : null)
                .representative(transaction.getRepresentative())
                .totalAmount(transaction.getTotalAmount())
                .createdAt(transaction.getCreatedAt())
                .build();
    }

}
