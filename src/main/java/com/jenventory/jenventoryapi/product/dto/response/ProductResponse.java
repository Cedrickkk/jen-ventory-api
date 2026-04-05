package com.jenventory.jenventoryapi.product.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {

    private Long id;
    private String name;
    private boolean active;
    private String description;
    @Builder.Default
    private Integer variantCount = 0;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
