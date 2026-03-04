package com.jenventory.jenventoryapi.security;

import com.jenventory.jenventoryapi.dto.request.LoginRequest;
import com.jenventory.jenventoryapi.dto.request.RegisterRequest;
import com.jenventory.jenventoryapi.dto.response.AuthenticationResponse;
import com.jenventory.jenventoryapi.dto.response.UserResponse;
import com.jenventory.jenventoryapi.entity.User;
import com.jenventory.jenventoryapi.exception.DuplicateResourceException;
import com.jenventory.jenventoryapi.exception.InvalidTokenException;
import com.jenventory.jenventoryapi.mapper.UserMapper;
import com.jenventory.jenventoryapi.repository.UserRepository;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final CookieService cookieService;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public AuthenticationResponse register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new DuplicateResourceException("Email already exists.");
        }

        User user = userRepository.save(User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build());


        return buildAuthenticationResponse(user);
    }

    public AuthenticationResponse authenticate(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found."));

        return buildAuthenticationResponse(user);
    }

    public AuthenticationResponse logout() {
        List<Cookie> cookies = List.of(
                cookieService.clearAccessTokenCookie(),
                cookieService.clearRefreshTokenCookie()
        );

        return AuthenticationResponse.builder()
                .cookies(cookies)
                .build();
    }


    private AuthenticationResponse buildAuthenticationResponse(User user) {
        UserDetails userDetails = new ApplicationUserDetails(user);

        String accessToken = jwtService.generateAccessToken(userDetails);
        String refreshToken = jwtService.generateRefreshToken(userDetails);

        List<Cookie> cookies = List.of(
                cookieService.createAccessTokenCookie(accessToken),
                cookieService.createRefreshTokenCookie(refreshToken)
        );

        UserResponse userResponse = userMapper.toResponse(user);

        return AuthenticationResponse.builder()
                .user(userResponse)
                .cookies(cookies)
                .build();
    }

    public AuthenticationResponse refreshToken(String refreshToken) {
        // Extract email from the refresh token
        String userEmail = jwtService.extractUsername(refreshToken);

        if (userEmail != null) {
            User user = userRepository.findByEmail(userEmail)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            UserDetails userDetails = new ApplicationUserDetails(user);

            // Validate the token against user details
            if (jwtService.isTokenValid(refreshToken, userDetails)) {
                return buildAuthenticationResponse(user);
            }
        }

        // Refresh token is invalid or expired
        throw new InvalidTokenException("Invalid refresh token");
    }

}
