package com.jenventory.jenventoryapi.common.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FieldErrorDetail {
    private String field;
    private String message;
}
