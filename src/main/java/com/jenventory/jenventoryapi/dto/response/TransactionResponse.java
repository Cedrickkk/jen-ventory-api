package com.jenventory.jenventoryapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponse {

    private Long id;
    private Long customerId;
    private String customerName;
    private String representative;
    private String notes;
    private BigDecimal totalAmount;
    private List<TransactionItemResponse> items;
    private List<TransactionPaymentResponse> payments;
    private LocalDateTime createdAt;

}
