package com.social.chat_myster.validation;

import com.social.chat_myster.validation.annoation.StrongPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;
import java.util.regex.Pattern;

public class StrongPasswordValidator implements ConstraintValidator<StrongPassword, String > {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(
            "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!*()]).{8,}$");
    private final Set<String> COMMON_PASSWORDS = Set.of("Password1!", "Qwerty123");


    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) return false;
        if (COMMON_PASSWORDS.contains(value)) return false;
        return PASSWORD_PATTERN.matcher(value).matches();
    }
}
