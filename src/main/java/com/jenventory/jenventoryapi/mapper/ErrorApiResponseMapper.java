package com.jenventory.jenventoryapi.mapper;

import com.jenventory.jenventoryapi.dto.FieldErrorDetail;
import org.springframework.validation.FieldError;

public class ErrorApiResponseMapper {

    public static FieldErrorDetail toFieldDetail(FieldError fieldError) {
        return FieldErrorDetail.builder()
                .field(fieldError.getField())
                .message(fieldError.getDefaultMessage())
                .build();
    }

}
