package com.jenventory.jenventoryapi.gcash.dto.request;

import com.jenventory.jenventoryapi.common.annotation.ValidEnum;
import com.jenventory.jenventoryapi.gcash.enums.GCashTransactionType;
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
public class GCashServiceLogRequest {

    @NotBlank(message = "Service type is required")
    @ValidEnum(enumClass = GCashTransactionType.class, message = "Invalid service type")
    private String serviceType;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Amount must be greater than zero")
    private BigDecimal amount;

    @NotBlank(message = "Representative phone number is required")
    private String representativePhone;

    private Long customerId;
    private String representativeName;
    private String notes;

}
