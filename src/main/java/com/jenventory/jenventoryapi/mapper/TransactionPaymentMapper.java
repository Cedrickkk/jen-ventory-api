package com.jenventory.jenventoryapi.mapper;

import com.jenventory.jenventoryapi.dto.request.TransactionPaymentRequest;
import com.jenventory.jenventoryapi.dto.response.TransactionPaymentResponse;
import com.jenventory.jenventoryapi.entity.Transaction;
import com.jenventory.jenventoryapi.entity.TransactionPayment;
import com.jenventory.jenventoryapi.enums.PaymentMethod;
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
                .build();
    }

}
