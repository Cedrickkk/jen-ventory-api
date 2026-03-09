package com.jenventory.jenventoryapi.product.mapper;

import com.jenventory.jenventoryapi.product.dto.request.ProductRequest;
import com.jenventory.jenventoryapi.product.dto.response.ProductResponse;
import com.jenventory.jenventoryapi.product.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequest request) {
        return Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
    }

    public ProductResponse toResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .active(product.isActive())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }

}
