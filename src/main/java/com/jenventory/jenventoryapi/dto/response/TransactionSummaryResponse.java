package com.jenventory.jenventoryapi.dto.response;

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
public class TransactionSummaryResponse {

    private Long id;
    private Long customerId;
    private String customerName;
    private String representative;
    private BigDecimal totalAmount;
    private LocalDateTime createdAt;

}
