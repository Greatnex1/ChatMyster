package com.social.chat_myster.service.interfaces;

import com.social.chat_myster.dto.LoginDto;
import com.social.chat_myster.dto.response.AuthenticationResponse;

public interface AuthUseCase {
    AuthenticationResponse authenticate(LoginDto loginDto);
}
