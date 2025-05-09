package com.social.chat_myster.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record RefreshTokenResponse(

        @JsonProperty("access_token")
           String accessToken,
        @JsonProperty("refresh_token")
            String refreshToken,
        @JsonProperty("token_type")
            String tokenType
) {
}
