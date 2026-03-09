package com.jenventory.jenventoryapi.product.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductVariantRequest {

    @NotBlank(message = "Product Variant SKU is required")
    private String sku;

    @NotNull
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    private BigDecimal price;

    private String size;
    private String flavor;
    private String packaging;
}
