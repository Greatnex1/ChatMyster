package com.social.chat_myster.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

public record UserDisconnectedEvent(
        String username) {
}
