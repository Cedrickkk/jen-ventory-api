package com.jenventory.jenventoryapi.mapper;

import com.jenventory.jenventoryapi.dto.response.FieldErrorDetail;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

@Component
public class ErrorApiResponseMapper {

    public FieldErrorDetail toFieldDetail(FieldError fieldError) {
        return FieldErrorDetail.builder()
                .field(fieldError.getField())
                .message(fieldError.getDefaultMessage())
                .build();
    }

}
