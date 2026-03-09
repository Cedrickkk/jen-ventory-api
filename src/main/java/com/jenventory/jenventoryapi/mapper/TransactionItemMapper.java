package com.jenventory.jenventoryapi.mapper;

import com.jenventory.jenventoryapi.dto.request.TransactionItemRequest;
import com.jenventory.jenventoryapi.dto.response.TransactionItemResponse;
import com.jenventory.jenventoryapi.entity.Transaction;
import com.jenventory.jenventoryapi.entity.TransactionItem;
import com.jenventory.jenventoryapi.product.entity.ProductVariant;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TransactionItemMapper {

    public TransactionItem toEntity(TransactionItemRequest request, Transaction transaction, ProductVariant productVariant) {
        return TransactionItem.builder()
                .productVariant(productVariant)
                .transaction(transaction)
                .quantity(request.getQuantity())
                .unitPrice(productVariant.getPrice())
                .build();
    }

    public TransactionItemResponse toResponse(TransactionItem transactionItem) {
        return TransactionItemResponse.builder()
                .id(transactionItem.getId())
                .productVariantId(transactionItem.getProductVariant().getId())
                .productVariantName(transactionItem.getProductVariant().getProduct().getName())
                .sku(transactionItem.getProductVariant().getSku())
                .quantity(transactionItem.getQuantity())
                .unitPrice(transactionItem.getUnitPrice())
                /* ? Calculation should happen in Service  */
                .subtotal(transactionItem.getUnitPrice().multiply(BigDecimal.valueOf(transactionItem.getQuantity())))
                .build();
    }

}
