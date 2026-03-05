package com.jenventory.jenventoryapi.mapper;

import com.jenventory.jenventoryapi.dto.request.ProductRequest;
import com.jenventory.jenventoryapi.dto.response.ProductResponse;
import com.jenventory.jenventoryapi.entity.Product;
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
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }

}
