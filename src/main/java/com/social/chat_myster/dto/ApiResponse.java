package com.social.chat_myster.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Builder
public record ApiResponse<T>(
        String message,
        int statusCode,
        T data,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXXXX'['VV']'")
        boolean isSuccessful,
        ZonedDateTime timeStamp

) {

    public ApiResponse<T> created(T object, String message) {
        return ApiResponse.<T>builder()
                .data(object)
                .message(message)
                .statusCode(HttpStatus.CREATED.value())
                .isSuccessful(true)
                .timeStamp(ZonedDateTime.now())
                .build();
    }
}
