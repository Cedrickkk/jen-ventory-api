package com.jenventory.jenventoryapi.common.dto.response;

import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.UUID;

public final class ApiResponseUtil {

    private ApiResponseUtil() {
    }

    public static <T> SuccessApiResponse<T> success(T data, String message) {
        return SuccessApiResponse.<T>builder()
                .code(HttpStatus.OK.value())
                .status(HttpStatus.OK.getReasonPhrase())
                .message(message)
                .meta(new BaseApiResponse.Meta(Instant.now(), UUID.randomUUID().toString()))
                .data(data)
                .build();
    }

    public static <T> SuccessApiResponse<T> created(T data, String message) {
        return SuccessApiResponse.<T>builder()
                .code(HttpStatus.CREATED.value())
                .status(HttpStatus.CREATED.getReasonPhrase())
                .message(message)
                .meta(new BaseApiResponse.Meta(Instant.now(), UUID.randomUUID().toString()))
                .data(data)
                .build();
    }

    public static <T> SuccessApiResponse<T> noContent(String message) {
        return SuccessApiResponse.<T>builder()
                .code(HttpStatus.NO_CONTENT.value())
                .status(HttpStatus.NO_CONTENT.getReasonPhrase())
                .message(message)
                .meta(new BaseApiResponse.Meta(Instant.now(), UUID.randomUUID().toString()))
                .data(null)
                .build();
    }

    public static <T> ErrorApiResponse<T> badRequest(String message) {
        return ErrorApiResponse.<T>builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(message)
                .meta(new BaseApiResponse.Meta(Instant.now(), UUID.randomUUID().toString()))
                .build();
    }

    public static <T> ErrorApiResponse<T> unauthorized(String message) {
        return ErrorApiResponse.<T>builder()
                .code(HttpStatus.UNAUTHORIZED.value())
                .status(HttpStatus.UNAUTHORIZED.getReasonPhrase())
                .message(message)
                .meta(new BaseApiResponse.Meta(Instant.now(), UUID.randomUUID().toString()))
                .build();
    }

    public static <T> ErrorApiResponse<T> notFound(String message) {
        return ErrorApiResponse.<T>builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(message)
                .meta(new BaseApiResponse.Meta(Instant.now(), UUID.randomUUID().toString()))
                .build();
    }

    public static <T> ErrorApiResponse<T> internalServerError(String message) {
        return ErrorApiResponse.<T>builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .message(message)
                .meta(new BaseApiResponse.Meta(Instant.now(), UUID.randomUUID().toString()))
                .build();
    }
}
