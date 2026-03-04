package com.jenventory.jenventoryapi.controller;

import com.jenventory.jenventoryapi.dto.request.LoginRequest;
import com.jenventory.jenventoryapi.dto.request.RegisterRequest;
import com.jenventory.jenventoryapi.dto.response.ApiResponseUtil;
import com.jenventory.jenventoryapi.dto.response.AuthenticationResponse;
import com.jenventory.jenventoryapi.dto.response.SuccessApiResponse;
import com.jenventory.jenventoryapi.dto.response.UserResponse;
import com.jenventory.jenventoryapi.exception.InvalidTokenException;
import com.jenventory.jenventoryapi.security.ApplicationUserDetails;
import com.jenventory.jenventoryapi.security.AuthenticationService;
import com.jenventory.jenventoryapi.security.CookieService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final CookieService cookieService;

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
    public ResponseEntity<SuccessApiResponse<Void>> logout(HttpServletRequest request, HttpServletResponse response) {
        String refreshToken = cookieService.extractCookieValue(request, CookieService.COOKIE_REFRESH_TOKEN_NAME)
                .orElseThrow(() -> new InvalidTokenException("Refresh token is missing."));

        List<Cookie> clearedCookies = authenticationService.logout(refreshToken);

        clearedCookies.forEach(response::addCookie);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/me")
    public ResponseEntity<SuccessApiResponse<UserResponse>> getCurrentUser(
            @AuthenticationPrincipal ApplicationUserDetails userDetails) {

        UserResponse userResponse = UserResponse.builder()
                .id(userDetails.getUser().getId())
                .name(userDetails.getUser().getName())
                .email(userDetails.getUser().getEmail())
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

        List<Cookie> cookies = authenticationService.refreshToken(refreshToken);

        cookies.forEach(response::addCookie);

        SuccessApiResponse<Void> successApiResponse =
                ApiResponseUtil.success(null, "Tokens refreshed successfully.");

        return ResponseEntity.ok(successApiResponse);
    }


}
