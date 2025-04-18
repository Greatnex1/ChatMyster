package com.social.chat_myster.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.social.chat_myster.data.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record MysterUserDto(
         String id,
        String firstname,
        String lastname,
        String email,
        String phoneNumber,
        String username,
        String role,
         LocalDateTime dateCreated
) {
}
