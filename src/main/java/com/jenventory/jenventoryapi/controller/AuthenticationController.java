package com.jenventory.jenventoryapi.controller;

import com.jenventory.jenventoryapi.dto.request.LoginRequest;
import com.jenventory.jenventoryapi.dto.request.RegisterRequest;
import com.jenventory.jenventoryapi.dto.response.ApiResponseUtil;
import com.jenventory.jenventoryapi.dto.response.AuthenticationResponse;
import com.jenventory.jenventoryapi.dto.response.SuccessApiResponse;
import com.jenventory.jenventoryapi.dto.response.UserResponse;
import com.jenventory.jenventoryapi.security.ApplicationUserDetails;
import com.jenventory.jenventoryapi.security.AuthenticationService;
import com.jenventory.jenventoryapi.security.CookieService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<SuccessApiResponse<Map<String, UserResponse>>> createUser(
            @Valid @RequestBody RegisterRequest request,
            HttpServletResponse response) {

        AuthenticationResponse auth = authenticationService.register(request);

        auth.getCookies().forEach(response::addCookie);

        Map<String, UserResponse> user = Map.of("user", auth.getUser());

        SuccessApiResponse<Map<String, UserResponse>> successApiResponse =
                ApiResponseUtil.created(user, "Registration successful.");

        return ResponseEntity.status(HttpStatus.CREATED).body(successApiResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<SuccessApiResponse<Map<String, UserResponse>>> login(
            @Valid @RequestBody LoginRequest request,
            HttpServletResponse response) {
        AuthenticationResponse auth = authenticationService.authenticate(request);

        auth.getCookies().forEach(response::addCookie);

        Map<String, UserResponse> user = Map.of("user", auth.getUser());

        SuccessApiResponse<Map<String, UserResponse>> successApiResponse =
                ApiResponseUtil.success(user, "Login successful.");

        return ResponseEntity.status(HttpStatus.OK).body(successApiResponse);
    }

    @PostMapping("/logout")
    public ResponseEntity<SuccessApiResponse<Void>> logout(HttpServletResponse response) {
        AuthenticationResponse auth = authenticationService.logout();

        auth.getCookies().forEach(response::addCookie);

        SuccessApiResponse<Void> successApiResponse =
                ApiResponseUtil.success(null, "Logout successful.");

        return ResponseEntity.ok(successApiResponse);
    }

    /**
     * TODO: Delegate responsibility to service
     */
    @GetMapping("/me")
    public ResponseEntity<SuccessApiResponse<UserResponse>> getCurrentUser(
            @AuthenticationPrincipal ApplicationUserDetails userDetails) {

        UserResponse userResponse = UserResponse.builder()
                .id(userDetails.user.getId())
                .name(userDetails.user.getName())
                .email(userDetails.user.getEmail())
                .build();

        SuccessApiResponse<UserResponse> successApiResponse = SuccessApiResponse.<UserResponse>builder()
                .code(HttpStatus.OK.value())
                .status(HttpStatus.OK.getReasonPhrase())
                .message("Authenticated user retrieved.")
                .data(userResponse)
                .build();

        return ResponseEntity.ok(successApiResponse);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<SuccessApiResponse<Void>> refresh(
            @CookieValue(name = CookieService.COOKIE_REFRESH_TOKEN_NAME) String refreshToken,
            HttpServletResponse response) {

        AuthenticationResponse auth = authenticationService.refreshToken(refreshToken);

        // Add the new tokens (access and potentially a rotated refresh token) to the response
        auth.getCookies().forEach(response::addCookie);

        SuccessApiResponse<Void> successApiResponse =
                ApiResponseUtil.success(null, "Token refreshed successfully.");

        return ResponseEntity.ok(successApiResponse);
    }


}
