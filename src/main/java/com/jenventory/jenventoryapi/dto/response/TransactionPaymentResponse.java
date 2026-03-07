package com.jenventory.jenventoryapi.dto.response;

import com.jenventory.jenventoryapi.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionPaymentResponse {

    private Long id;
    private PaymentMethod method;
    private BigDecimal amount;

}
