package com.jenventory.jenventoryapi.product.mapper;

import com.jenventory.jenventoryapi.transaction.entity.Transaction;
import com.jenventory.jenventoryapi.product.dto.response.StockMovementResponse;
import com.jenventory.jenventoryapi.product.entity.ProductVariant;
import com.jenventory.jenventoryapi.product.entity.StockMovement;
import com.jenventory.jenventoryapi.product.enums.StockMovementReason;
import org.springframework.stereotype.Component;

@Component
public class StockMovementMapper {

    public StockMovement toEntity(
            ProductVariant productVariant, Transaction transaction,
            StockMovementReason reason, Integer quantityChange, String notes) {
        return StockMovement.builder()
                .variant(productVariant)
                .transaction(transaction)
                .reason(reason)
                .quantityChange(quantityChange)
                .notes(notes)
                .build();
    }

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
