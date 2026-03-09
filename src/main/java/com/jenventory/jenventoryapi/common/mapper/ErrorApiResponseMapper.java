package com.jenventory.jenventoryapi.common.mapper;

import com.jenventory.jenventoryapi.common.dto.response.FieldErrorDetail;
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
