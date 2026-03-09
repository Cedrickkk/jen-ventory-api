package com.jenventory.jenventoryapi.transaction.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionRequest {

    private Long customerId;
    private String representative;
    private String notes;
    private boolean allowDebt = false;
    private boolean storeChangeAsCredit = false;

    @NotEmpty(message = "Transaction must have at least one item")
    private List<TransactionItemRequest> items;

    @NotNull(message = "Payments list is required")
    private List<TransactionPaymentRequest> payments;

}
