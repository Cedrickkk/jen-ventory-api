package com.jenventory.jenventoryapi.gcash.dto.response;

import com.jenventory.jenventoryapi.gcash.enums.GCashTransactionType;
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
public class GCashServiceLogResponse {

    private Long id;
    private Long customerId;
    private String customerName;
    private String representativeName;
    private String representativePhone;
    private GCashTransactionType serviceType;
    private BigDecimal amount;
    private BigDecimal fee;
    private String notes;
    private LocalDateTime createdAt;

}
