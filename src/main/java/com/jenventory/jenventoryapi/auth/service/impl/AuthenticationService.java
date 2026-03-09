package com.jenventory.jenventoryapi.auth.service.impl;

import com.jenventory.jenventoryapi.auth.dto.request.LoginRequest;
import com.jenventory.jenventoryapi.auth.dto.request.RegisterRequest;
import com.jenventory.jenventoryapi.auth.dto.response.AuthenticationResponse;
import com.jenventory.jenventoryapi.auth.dto.response.UserResponse;
import com.jenventory.jenventoryapi.auth.entity.ApplicationUserDetails;
import com.jenventory.jenventoryapi.auth.entity.RefreshToken;
import com.jenventory.jenventoryapi.auth.entity.User;
import com.jenventory.jenventoryapi.auth.mapper.UserMapper;
import com.jenventory.jenventoryapi.auth.repository.UserRepository;
import com.jenventory.jenventoryapi.auth.service.RefreshTokenService;
import com.jenventory.jenventoryapi.common.exception.DuplicateResourceException;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final CookieService cookieService;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Transactional
    public AuthenticationResponse register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new DuplicateResourceException("Email already exists.");
        }

        User _user = userMapper.toEntity(request);
        _user.setPassword(passwordEncoder.encode(request.getPassword()));

        User user = userRepository.save(_user);

        return buildAuthenticationResponse(user);
    }

    @Transactional
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

    @Transactional
    public List<Cookie> logout(String token) {
        refreshTokenService.revoke(token);

        return List.of(
                cookieService.clearAccessTokenCookie(),
                cookieService.clearRefreshTokenCookie()
        );
    }

    private AuthenticationResponse buildAuthenticationResponse(User user) {
        UserDetails userDetails = new ApplicationUserDetails(user);

        String accessToken = jwtService.generateAccessToken(userDetails);
        String refreshToken = refreshTokenService.create(user).getToken();

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

    public List<Cookie> refreshToken(String refreshToken) {
        RefreshToken rotatedRefreshToken = refreshTokenService.rotate(refreshToken);
        UserDetails userDetails = new ApplicationUserDetails(rotatedRefreshToken.getUser());
        String accessToken = jwtService.generateAccessToken(userDetails);

        return List.of(
                cookieService.createAccessTokenCookie(accessToken),
                cookieService.createRefreshTokenCookie(rotatedRefreshToken.getToken())
        );
    }

}
