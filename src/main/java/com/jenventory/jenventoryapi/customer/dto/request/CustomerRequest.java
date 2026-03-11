package com.jenventory.jenventoryapi.customer.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequest {

    @NotBlank(message = "Customer name is required.")
    @Size(max = 100, message = "Customer name must not exceed 100 characters.")
    private String name;

    @NotBlank(message = "Customer phone number is required.")
    @Pattern(regexp = "^09\\d{9}$", message = "Must be a valid PH mobile number")
    private String phone;

    @NotBlank(message = "Customer address is required.")
    private String address;

    private boolean active;

}
