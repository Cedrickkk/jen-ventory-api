package com.jenventory.jenventoryapi.product.dto.response;

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
public class ProductVariantResponse {

    private Long id;
    private Long productId;
    private String productName;
    private String sku;
    private BigDecimal price;
    private String size;
    private String flavor;
    private String packaging;
    private Integer stockQuantity;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
