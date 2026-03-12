package com.jenventory.jenventoryapi.customer.dto.response;

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
public class CustomerTransactionResponse {

    private Long id;
    private String representative;
    private BigDecimal totalAmount;
    private BigDecimal amountPaid;
    /* How much went to debt */
    private BigDecimal debtAmount;
    /* How much stored as credit */
    private BigDecimal creditAmount;
    private Integer itemCount;
    private LocalDateTime createdAt;

}
