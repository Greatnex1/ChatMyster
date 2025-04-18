package com.social.chat_myster.dto;
import com.social.chat_myster.validation.annoation.StrongPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.time.LocalDateTime;

import static com.social.chat_myster.validation.InputValidator.validateInput;

@Builder
public record SignUpDto(
        @NotBlank(message = "firstname is required")
        String firstname,
        @NotBlank(message = "lastname is required")
        String lastname,
        @Email(message = "email format is not valid")
        String email,
        String username,
       @NotBlank(message = "password is required")
       @StrongPassword
         String password,
        @NotBlank(message = "password is required")
        String confirmPassword,
        @NotBlank(message = "phoneNumber is required")
        String phoneNumber,
        String role
) {

    public void validateSignUpData(){
        validateInput(firstname,"firstName");
        validateInput(lastname,"lastName");
         validateInput(username,"username");
        validateInput(email,"email");
        validateInput(password,"password");
        validateInput(confirmPassword,"confirmPassword");
        validateInput(phoneNumber,"phoneNumber");
    }
}
