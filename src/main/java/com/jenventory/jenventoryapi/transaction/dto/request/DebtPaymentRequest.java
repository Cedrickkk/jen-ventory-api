package com.jenventory.jenventoryapi.transaction.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DebtPaymentRequest {

    @NotEmpty(message = "Debt payment request must have at least one payment method.")
    private List<DebtPaymentMethodRequest> payments;

    private String notes;

}
