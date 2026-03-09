package com.jenventory.jenventoryapi.transaction.mapper;

import com.jenventory.jenventoryapi.customer.entity.Customer;
import com.jenventory.jenventoryapi.transaction.dto.response.DebtLedgerResponse;
import com.jenventory.jenventoryapi.transaction.dto.response.DebtSummaryResponse;
import com.jenventory.jenventoryapi.transaction.entity.DebtLedger;
import com.jenventory.jenventoryapi.transaction.entity.Transaction;
import com.jenventory.jenventoryapi.transaction.enums.DebtLedgerType;
import com.jenventory.jenventoryapi.transaction.enums.PaymentMethod;
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

    public DebtSummaryResponse toSummaryResponse(
            BigDecimal totalDebt, BigDecimal totalCredit,
            BigDecimal totalPaid, BigDecimal creditUsed,
            BigDecimal netDebt, BigDecimal netCredit
    ) {
        return DebtSummaryResponse.builder()
                .totalDebt(totalDebt)
                .totalCredit(totalCredit)
                .totalPaid(totalPaid)
                .creditUsed(creditUsed)
                .netDebt(netDebt)
                .netCredit(netCredit)
                .build();
    }

}
