package com.jenventory.jenventoryapi.gcash.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GCashFeeTierResponse {

    private Long id;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private BigDecimal fee;

}
