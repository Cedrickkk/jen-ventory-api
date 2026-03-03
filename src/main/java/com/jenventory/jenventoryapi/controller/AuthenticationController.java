package com.jenventory.jenventoryapi.controller;

import com.jenventory.jenventoryapi.dto.request.LoginRequest;
import com.jenventory.jenventoryapi.dto.request.RegisterRequest;
import com.jenventory.jenventoryapi.dto.response.AuthenticationResponse;
import com.jenventory.jenventoryapi.dto.response.SuccessApiResponse;
import com.jenventory.jenventoryapi.dto.response.UserResponse;
import com.jenventory.jenventoryapi.security.AuthenticationService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<SuccessApiResponse<UserResponse>> createUser(
            @Valid @RequestBody RegisterRequest request,
            HttpServletResponse response) {

        AuthenticationResponse auth = authenticationService.register(request);

        auth.getCookies().forEach(response::addCookie);

        SuccessApiResponse<UserResponse> successApiResponse = SuccessApiResponse.<UserResponse>builder()
                .code(HttpStatus.CREATED.value())
                .status(HttpStatus.CREATED.getReasonPhrase())
                .message("Registration successful.")
                .data(auth.getUser())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(successApiResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<SuccessApiResponse<UserResponse>> login(
            @Valid @RequestBody LoginRequest request,
            HttpServletResponse response) {
        AuthenticationResponse auth = authenticationService.authenticate(request);

        auth.getCookies().forEach(response::addCookie);

        SuccessApiResponse<UserResponse> successApiResponse = SuccessApiResponse.<UserResponse>builder()
                .code(HttpStatus.OK.value())
                .status(HttpStatus.OK.getReasonPhrase())
                .message("Login successful.")
                .data(auth.getUser())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(successApiResponse);
    }
}
