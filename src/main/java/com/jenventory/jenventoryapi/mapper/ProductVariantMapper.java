package com.jenventory.jenventoryapi.mapper;

import com.jenventory.jenventoryapi.dto.request.ProductVariantRequest;
import com.jenventory.jenventoryapi.dto.response.ProductVariantResponse;
import com.jenventory.jenventoryapi.entity.Product;
import com.jenventory.jenventoryapi.entity.ProductVariant;
import org.springframework.stereotype.Component;

@Component
public class ProductVariantMapper {

    public ProductVariant toEntity(ProductVariantRequest request, Product product) {
        return ProductVariant.builder()
                .product(product)
                .sku(request.getSku())
                .price(request.getPrice())
                .size(request.getSize())
                .flavor(request.getFlavor())
                .packaging(request.getPackaging())
                .build();
    }

    public ProductVariantResponse toResponse(ProductVariant variant) {
        return ProductVariantResponse.builder()
                .id(variant.getId())
                .productId(variant.getProduct().getId())
                .sku(variant.getSku())
                .price(variant.getPrice())
                .size(variant.getSize())
                .flavor(variant.getFlavor())
                .packaging(variant.getPackaging())
                .stockQuantity(variant.getStockQuantity())
                .active(variant.isActive())
                .createdAt(variant.getCreatedAt())
                .updatedAt(variant.getUpdatedAt())
                .build();
    }
}
