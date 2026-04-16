package com.jenventory.jenventoryapi.customer.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse {

    private Long id;
    private String name;
    private String phone;
    private String address;
    private String image;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
