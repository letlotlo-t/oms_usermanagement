package com.fnb.oms_usermanagement.security;

import com.fnb.oms_usermanagement.entity.User;

public interface JwtService {

    String generateToken(User user);

    boolean validateToken(String token, String email);

    String extractEmailFromToken(String token);
}