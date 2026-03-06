package com.jenventory.jenventoryapi.mapper;

import com.jenventory.jenventoryapi.dto.response.StockMovementResponse;
import com.jenventory.jenventoryapi.entity.StockMovement;
import org.springframework.stereotype.Component;

@Component
public class StockMovementMapper {

    public StockMovementResponse toResponse(StockMovement stockMovement) {
        return StockMovementResponse.builder()
                .id(stockMovement.getId())
                .productVariantId(stockMovement.getVariant().getId())
                .transactionId(stockMovement.getTransaction() != null ? stockMovement.getTransaction().getId() : null)
                .reason(stockMovement.getReason())
                .quantityChange(stockMovement.getQuantityChange())
                .notes(stockMovement.getNotes())
                .createdAt(stockMovement.getCreatedAt())
                .build();
    }


}
