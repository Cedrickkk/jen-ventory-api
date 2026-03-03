package com.jenventory.jenventoryapi.exception;

import com.jenventory.jenventoryapi.dto.response.ErrorApiResponse;
import com.jenventory.jenventoryapi.dto.response.FieldErrorDetail;
import com.jenventory.jenventoryapi.mapper.ErrorApiResponseMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorApiResponse<List<FieldErrorDetail>>> handleValidationException(
            MethodArgumentNotValidException ex) {

        List<FieldErrorDetail> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(ErrorApiResponseMapper::toFieldDetail)
                .toList();

        ErrorApiResponse<List<FieldErrorDetail>> response = ErrorApiResponse.<List<FieldErrorDetail>>builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message("Request failed due to missing or invalid fields.")
                .errors(errors)
                .build();

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorApiResponse<Void>> handleBadCredentialsException(BadCredentialsException ex) {
        ErrorApiResponse<Void> response = ErrorApiResponse.<Void>builder()
                .code(HttpStatus.UNAUTHORIZED.value())
                .status(HttpStatus.UNAUTHORIZED.getReasonPhrase())
                .message("Invalid username or password.")
                .errors(null)
                .build();

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

}
