package com.jenventory.jenventoryapi.dto.response;

import com.jenventory.jenventoryapi.enums.StockMovementReason;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockMovementResponse {

    private Long id;
    private Long productVariantId;
    private Long transactionId;
    private StockMovementReason reason;
    private Integer quantityChange;
    private String notes;
    private LocalDateTime createdAt;

}
