package com.jenventory.jenventoryapi.service;


import com.jenventory.jenventoryapi.entity.RefreshToken;
import com.jenventory.jenventoryapi.entity.User;

public interface RefreshTokenService {

    RefreshToken create(User user);

    RefreshToken validate(String token);

    RefreshToken rotate(String oldToken);

    void revoke(String token);

}
