package com.jenventory.jenventoryapi.transaction.dto.response;

import com.jenventory.jenventoryapi.transaction.enums.DebtLedgerType;
import com.jenventory.jenventoryapi.transaction.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DebtLedgerResponse {

    private Long id;
    private Long customerId;
    private Long transactionId;
    private DebtLedgerType type;
    private PaymentMethod paymentMethod;
    private BigDecimal amount;
    private String notes;
    private LocalDateTime createdAt;

}
