package com.social.chat_myster.validation;

import io.micrometer.common.util.StringUtils;

import static com.social.chat_myster.constants.ErrorMessages.EMPTY_INPUT_ERROR;
import static com.social.chat_myster.constants.ErrorMessages.UNDEFINED;

public class InputValidator {
    public static void validateInput(String name, String field) {
        if (StringUtils.isEmpty(name) || org.apache.commons.lang3.StringUtils.isBlank(name)
                || StringUtils.isEmpty(name.trim()) || name.equals(UNDEFINED)) {
            throw new IllegalArgumentException(String.format(EMPTY_INPUT_ERROR, field));

        }
    }
}
