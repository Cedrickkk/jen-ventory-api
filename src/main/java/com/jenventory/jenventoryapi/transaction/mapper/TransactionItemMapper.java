package com.jenventory.jenventoryapi.transaction.mapper;

import com.jenventory.jenventoryapi.product.entity.ProductVariant;
import com.jenventory.jenventoryapi.transaction.dto.request.TransactionItemRequest;
import com.jenventory.jenventoryapi.transaction.dto.response.TransactionItemResponse;
import com.jenventory.jenventoryapi.transaction.entity.Transaction;
import com.jenventory.jenventoryapi.transaction.entity.TransactionItem;
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
                .productId(transactionItem.getProductVariant().getProduct().getId())
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
