package com.jenventory.jenventoryapi.auth.service;


import com.jenventory.jenventoryapi.auth.entity.RefreshToken;
import com.jenventory.jenventoryapi.auth.entity.User;

public interface RefreshTokenService {

    RefreshToken create(User user);

    RefreshToken validate(String token);

    RefreshToken rotate(String oldToken);

    void revoke(String token);

}
