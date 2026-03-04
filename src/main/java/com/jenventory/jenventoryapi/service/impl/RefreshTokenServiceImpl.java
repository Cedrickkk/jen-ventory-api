package com.jenventory.jenventoryapi.service.impl;

import com.jenventory.jenventoryapi.entity.RefreshToken;
import com.jenventory.jenventoryapi.entity.User;
import com.jenventory.jenventoryapi.exception.InvalidTokenException;
import com.jenventory.jenventoryapi.mapper.RefreshTokenMapper;
import com.jenventory.jenventoryapi.repository.RefreshTokenRepository;
import com.jenventory.jenventoryapi.security.ApplicationUserDetails;
import com.jenventory.jenventoryapi.security.JwtService;
import com.jenventory.jenventoryapi.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final RefreshTokenMapper refreshTokenMapper;
    private final JwtService jwtService;

    @Override
    @Transactional
    public RefreshToken create(User user) {
        String refreshToken = jwtService.generateRefreshToken(new ApplicationUserDetails(user));
        RefreshToken token = refreshTokenMapper.toEntity(
                refreshToken,
                user,
                jwtService.getJwtRefreshTokenExpirationTimeMs()
        );
        return refreshTokenRepository.save(token);
    }

    @Override
    @Transactional
    public RefreshToken validate(String token) {
        RefreshToken refreshToken = refreshTokenRepository.findByToken(token)
                .orElseThrow(() -> new InvalidTokenException("No refresh token found."));

        if (refreshToken.getExpiresAt().isBefore(Instant.now())) {
            refreshTokenRepository.deleteByToken(token);
            throw new InvalidTokenException("Refresh token has expired");
        }

        return refreshToken;
    }

    @Override
    @Transactional
    public RefreshToken rotate(String oldToken) {
        RefreshToken refreshToken = this.validate(oldToken);
        refreshTokenRepository.deleteByToken(oldToken);
        return this.create(refreshToken.getUser());
    }

    @Override
    @Transactional
    public void revoke(String token) {
        refreshTokenRepository.deleteByToken(token);
    }

}
