package com.jenventory.jenventoryapi.transaction.dto.request;

import com.jenventory.jenventoryapi.common.annotation.ValidEnum;
import com.jenventory.jenventoryapi.transaction.enums.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionPaymentRequest {

    @NotBlank(message = "Payment method is required")
    @ValidEnum(enumClass = PaymentMethod.class)
    private String paymentMethod;

    private BigDecimal amount;


}
