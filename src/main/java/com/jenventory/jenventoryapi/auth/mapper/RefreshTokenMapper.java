package com.jenventory.jenventoryapi.auth.mapper;

import com.jenventory.jenventoryapi.auth.entity.RefreshToken;
import com.jenventory.jenventoryapi.auth.entity.User;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class RefreshTokenMapper {

    public RefreshToken toEntity(String token, User user, Long expirationMs) {
        return RefreshToken.builder()
                .token(token)
                .user(user)
                .expiresAt(Instant.now().plusMillis(expirationMs))
                .build();
    }

}
