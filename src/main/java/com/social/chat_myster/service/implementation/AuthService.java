package com.social.chat_myster.service.implementation;

import com.social.chat_myster.data.entity.MysterUser;
import com.social.chat_myster.data.entity.RefreshToken;
import com.social.chat_myster.dto.LoginDto;
import com.social.chat_myster.dto.response.AuthenticationResponse;
import com.social.chat_myster.repository.MysterUserRepository;
import com.social.chat_myster.security.AuthenticatedUser;
import com.social.chat_myster.service.interfaces.AuthUseCase;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService implements AuthUseCase {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final MysterUserRepository userRepository;
    private final RefreshTokenService refreshTokenService;

    @Override
    public AuthenticationResponse authenticate(LoginDto request) {
        String username = request.username().toLowerCase();

        MysterUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password"));

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, request.password())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (BadCredentialsException e) {
            log.warn("Authentication failed for user: {}", username);
            throw new IllegalArgumentException("Invalid username or password");
        }

        AuthenticatedUser authenticatedUser = new AuthenticatedUser(user);
        String jwtToken = jwtService.generateToken(authenticatedUser);
//RefreshToken refreshToken = refreshTokenService.createRefreshToken(authenticatedUser.getUserId());
        log.info("Authentication was successful for user: {}", username);
        return AuthenticationResponse.pass(jwtToken, authenticatedUser.getUserId());
    }

}

