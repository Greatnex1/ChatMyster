package com.social.chat_myster.config;

import com.social.chat_myster.service.implementation.ActiveUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class WebInterceptorConfig {
    @Bean
    @Lazy
    public PresenceChannelInterceptor presenceChannelInterceptor(ActiveUserService activeUserService) {
        return new PresenceChannelInterceptor(activeUserService);
    }
}
