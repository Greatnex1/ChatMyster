package com.social.chat_myster.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public record RefreshTokenRequest(
        @NotBlank(message = "refresh token is required")
        String refreshToken
) {
}
