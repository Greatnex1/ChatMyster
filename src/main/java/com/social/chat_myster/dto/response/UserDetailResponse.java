package com.social.chat_myster.dto.response;

import lombok.Builder;

@Builder
public record UserDetailResponse(
        String id,
        String firstname,
        String lastname,
        String email,
        String username
) {
}
