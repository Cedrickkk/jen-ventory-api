package com.jenventory.jenventoryapi.common.exception;

import com.jenventory.jenventoryapi.common.dto.response.ApiResponseUtil;
import com.jenventory.jenventoryapi.common.dto.response.BaseApiResponse;
import com.jenventory.jenventoryapi.common.dto.response.ErrorApiResponse;
import com.jenventory.jenventoryapi.common.dto.response.FieldErrorDetail;
import com.jenventory.jenventoryapi.common.mapper.ErrorApiResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final ErrorApiResponseMapper errorApiResponseMapper;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorApiResponse<List<FieldErrorDetail>>> handleValidationException(
            MethodArgumentNotValidException ex) {

        List<FieldErrorDetail> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(errorApiResponseMapper::toFieldDetail)
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
                .meta(new BaseApiResponse.Meta(Instant.now(), UUID.randomUUID().toString()))
                .errors(null)
                .build();

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<ErrorApiResponse<Void>> handleBusinessRuleException(BusinessRuleException ex) {
        ErrorApiResponse<Void> response = ApiResponseUtil.badRequest(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorApiResponse<Void>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorApiResponse<Void> response = ApiResponseUtil.notFound(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }


    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ErrorApiResponse<Void>> handleDuplicateResourceException(DuplicateResourceException ex) {
        ErrorApiResponse<Void> response = ApiResponseUtil.badRequest(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ErrorApiResponse<Void>> handleInvalidTokenException(InvalidTokenException ex) {
        ErrorApiResponse<Void> response = ApiResponseUtil.unauthorized(ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

}
