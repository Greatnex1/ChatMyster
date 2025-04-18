package com.social.chat_myster.dto;

import com.social.chat_myster.validation.annoation.StrongPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginDto(
          @NotBlank
          String username,
        @NotBlank(message = "password is required")
        @StrongPassword
        String password
) {
}
