package com.jenventory.jenventoryapi.product.mapper;

import com.jenventory.jenventoryapi.product.dto.request.ProductVariantRequest;
import com.jenventory.jenventoryapi.product.dto.response.ProductVariantResponse;
import com.jenventory.jenventoryapi.product.entity.Product;
import com.jenventory.jenventoryapi.product.entity.ProductVariant;
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
                .productName(variant.getProduct().getName())
                .sku(variant.getSku())
                .price(variant.getPrice())
                .size(variant.getSize())
                .image(variant.getImage() != null ? variant.getImage().getStoredFilename() : null)
                .flavor(variant.getFlavor())
                .packaging(variant.getPackaging())
                .stockQuantity(variant.getStockQuantity())
                .active(variant.isActive())
                .createdAt(variant.getCreatedAt())
                .updatedAt(variant.getUpdatedAt())
                .build();
    }
}
