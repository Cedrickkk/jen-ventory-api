package com.jenventory.jenventoryapi.transaction.dto.response;

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
public class TransactionPaymentResponse {

    private Long id;
    private PaymentMethod method;
    private BigDecimal amount;
    private LocalDateTime createdAt;

}
