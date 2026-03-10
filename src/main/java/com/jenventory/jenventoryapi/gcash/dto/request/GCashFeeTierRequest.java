package com.jenventory.jenventoryapi.gcash.dto.request;

import jakarta.validation.constraints.DecimalMin;
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
public class GCashFeeTierRequest {
    @NotNull
    @DecimalMin(message = "Minimum fee tier amount is required.", value = "0.01")
    private BigDecimal minAmount;

    @NotNull(message = "Maximum fee tier amount is required.")
    @DecimalMin(value = "0.01", message = "Maximum fee tier amount must be greater than zero.")
    private BigDecimal maxAmount;

    @NotNull(message = "Service fee is required.")
    private BigDecimal fee;
}