package com.jenventory.jenventoryapi.transaction.mapper;

import com.jenventory.jenventoryapi.transaction.dto.request.TransactionPaymentRequest;
import com.jenventory.jenventoryapi.transaction.dto.response.TransactionPaymentResponse;
import com.jenventory.jenventoryapi.transaction.entity.Transaction;
import com.jenventory.jenventoryapi.transaction.entity.TransactionPayment;
import com.jenventory.jenventoryapi.transaction.enums.PaymentMethod;
import org.springframework.stereotype.Component;

@Component
public class TransactionPaymentMapper {

    public TransactionPayment toEntity(TransactionPaymentRequest request, Transaction transaction) {
        return TransactionPayment.builder()
                .transaction(transaction)
                .method(PaymentMethod.valueOf(request.getPaymentMethod()))
                .amount(request.getAmount())
                .build();
    }

    public TransactionPaymentResponse toResponse(TransactionPayment transactionPayment) {
        return TransactionPaymentResponse.builder()
                .id(transactionPayment.getId())
                .method(transactionPayment.getMethod())
                .amount(transactionPayment.getAmount())
                .createdAt(transactionPayment.getCreatedAt())
                .build();
    }

}
