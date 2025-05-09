package com.social.chat_myster.events;

import com.social.chat_myster.service.implementation.ActiveUserService;

import java.util.List;

public record ActiveUsersUpdatedEvent
        (List<ActiveUserService.UserPresence> activeUsers) {
}