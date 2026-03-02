package com.jenventory.jenventoryapi.security;

import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CookieService {
    public static final String COOKIE_ACCESS_TOKEN_NAME = "access_token";
    public static final String COOKIE_REFRESH_TOKEN_NAME = "refresh_token";

    @Value("${security.jwt.access-token.expiration}")
    private long accessTokenExpiration;  // milliseconds

    @Value("${security.jwt.refresh-token.expiration}")
    private long refreshTokenExpiration; // milliseconds

    private int getAccessTokenMaxAge() {
        return (int) (accessTokenExpiration / 1000);
    }

    private int getRefreshTokenMaxAge() {
        return (int) (refreshTokenExpiration / 1000);
    }

    public Cookie createAccessTokenCookie(String accessToken) {
        Cookie cookie = new Cookie(COOKIE_ACCESS_TOKEN_NAME, accessToken);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(getAccessTokenMaxAge());
        return cookie;
    }

    public Cookie createRefreshTokenCookie(String refreshToken) {
        Cookie cookie = new Cookie(COOKIE_REFRESH_TOKEN_NAME, refreshToken);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(getRefreshTokenMaxAge());
        return cookie;
    }
}
