package com.social.chat_myster.service.implementation;

import com.social.chat_myster.data.entity.MysterUser;
import com.social.chat_myster.data.enums.Role;
import com.social.chat_myster.dto.SignUpDto;
import com.social.chat_myster.repository.MysterUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Slf4j
class MysterUserServiceTest {

    @Mock
    private MysterUserRepository mysterUserRepository;

    @Mock
    PasswordEncoder passwordEncoder;
    @InjectMocks
    private MysterUserService mysterUserService;

    MysterUser mysterUser;
    SignUpDto signUpDto;
    @BeforeEach
    void setUp() {
        signUpDto = SignUpDto.builder()
                .email("noah@email.com")
                .firstname("Nouah")
                .lastname("Akoni")
                .password("@Blessed05")
                .phoneNumber("09087654321")
                .confirmPassword("@Blessed05")
                .role("ADMIN")
                .build();
    }

    @Test
    void testThatUserCanRegisterOnMysterPlatform() {
        when(mysterUserRepository.findByEmail(signUpDto.email())).thenReturn(Optional.empty());
       when(passwordEncoder.encode(signUpDto.password())).thenReturn("password is encoded");
       assertDoesNotThrow(() -> mysterUserService.createMysterUser(signUpDto));
       assertNotNull(signUpDto);
       assertThat(signUpDto.email()).isEqualTo("noah@email.com");
    }


}