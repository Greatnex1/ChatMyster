package com.social.chat_myster.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record AuthenticationResponse(
        @JsonProperty("access_token")
        String accessToken,
         String userId

) {
    public static AuthenticationResponse pass(String jwtToken, String userId) {
        return new AuthenticationResponse(jwtToken,userId);
    }
}
