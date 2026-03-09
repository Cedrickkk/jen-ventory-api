package com.jenventory.jenventoryapi.transaction.dto.request;

import com.jenventory.jenventoryapi.common.annotation.ValidEnum;
import com.jenventory.jenventoryapi.transaction.enums.PaymentMethod;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DebtPaymentMethodRequest {

    @NotBlank(message = "Payment method is required.")
    @ValidEnum(enumClass = PaymentMethod.class)
    private String method;

    @NotNull(message = "Payment amount is required.")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    private BigDecimal amount;

}
