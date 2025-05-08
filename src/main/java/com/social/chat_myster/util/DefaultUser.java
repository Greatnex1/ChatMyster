package com.social.chat_myster.util;

import com.social.chat_myster.dto.SignUpDto;
import com.social.chat_myster.service.implementation.AuthService;
import com.social.chat_myster.service.implementation.MysterUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DefaultUser implements CommandLineRunner {
    private final MysterUserService mysterUserService;


    @Override
    public void run(String... args) throws Exception {

        mysterUserService.createMysterUser(createDefaultUser());


    }

    private SignUpDto createDefaultUser() {
        SignUpDto userRequest = SignUpDto.builder()
                .firstname("Oliver")
                .lastname("Brown")
                .email("oliverbrown@gmail.com")
                .username("Olive")
                .password("@BlessedLad05")
                .phoneNumber("09045678910")
                .confirmPassword("@BlessedLad05")
                .role("USER")
                .build();
        log.info("Login details for default user, Username: {} Password: {}", userRequest.username(), userRequest.password());
        return userRequest;
    }
}