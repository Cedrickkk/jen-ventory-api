package com.jenventory.jenventoryapi.dto.response;

import jakarta.servlet.http.Cookie;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationResponse {
    private UserResponse user;
    private List<Cookie> cookies;
}
