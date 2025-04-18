package com.social.chat_myster.service.interfaces;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtUseCase {
    String extractUsername(String token);

    String generateToken(UserDetails userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);

}
