package com.jenventory.jenventoryapi.dto.request;

import com.jenventory.jenventoryapi.annotation.ValidEnum;
import com.jenventory.jenventoryapi.enums.AdjustmentDirection;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdjustmentRequest {

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

    @NotBlank(message = "Direction is required")
    @ValidEnum(enumClass = AdjustmentDirection.class)
    private String direction;

    private String notes;
}
