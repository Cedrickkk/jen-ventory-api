package com.jenventory.jenventoryapi.transaction.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DebtSummaryResponse {

    private BigDecimal totalDebt;
    private BigDecimal totalCredit;
    private BigDecimal totalPaid;
    private BigDecimal creditUsed;
    /* How much customer owes to the store */
    private BigDecimal netDebt;
    /* How much store owes to the customer */
    private BigDecimal netCredit;
    
}
