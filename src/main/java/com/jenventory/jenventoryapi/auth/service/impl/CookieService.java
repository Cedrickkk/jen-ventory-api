package com.jenventory.jenventoryapi.auth.service.impl;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

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

    public Cookie clearAccessTokenCookie() {
        Cookie cookie = new Cookie(COOKIE_ACCESS_TOKEN_NAME, null);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        return cookie;
    }

    public Cookie clearRefreshTokenCookie() {
        Cookie cookie = new Cookie(COOKIE_REFRESH_TOKEN_NAME, null);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        return cookie;
    }

    public Optional<String> extractCookieValue(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            return Optional.empty();
        }

        return Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals(cookieName))
                .map(Cookie::getValue)
                .findFirst();
    }

}
