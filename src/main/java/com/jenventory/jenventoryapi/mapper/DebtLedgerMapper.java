package com.jenventory.jenventoryapi.mapper;

import com.jenventory.jenventoryapi.customer.entity.Customer;
import com.jenventory.jenventoryapi.dto.response.DebtLedgerResponse;
import com.jenventory.jenventoryapi.entity.DebtLedger;
import com.jenventory.jenventoryapi.entity.Transaction;
import com.jenventory.jenventoryapi.enums.DebtLedgerType;
import com.jenventory.jenventoryapi.enums.PaymentMethod;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DebtLedgerMapper {

    public DebtLedger toEntity(
            Customer customer, Transaction transaction,
            DebtLedgerType debtLedgerType, PaymentMethod paymentMethod,
            String notes, BigDecimal amount) {
        return DebtLedger.builder()
                .customer(customer)
                .transaction(transaction)
                .type(debtLedgerType)
                .paymentMethod(paymentMethod)
                .notes(notes)
                .amount(amount)
                .build();
    }

    public DebtLedgerResponse toResponse(DebtLedger debtLedger) {
        return DebtLedgerResponse.builder()
                .id(debtLedger.getId())
                .customerId(debtLedger.getCustomer().getId())
                .transactionId(debtLedger.getTransaction() != null ? debtLedger.getTransaction().getId() : null)
                .type(debtLedger.getType())
                .paymentMethod(debtLedger.getPaymentMethod())
                .notes(debtLedger.getNotes())
                .amount(debtLedger.getAmount())
                .createdAt(debtLedger.getCreatedAt())
                .build();
    }

}
