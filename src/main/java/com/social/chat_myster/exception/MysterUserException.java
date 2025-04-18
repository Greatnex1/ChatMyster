package com.social.chat_myster.exception;
import org.springframework.http.HttpStatus;

public class MysterUserException extends Exception {

    private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    public MysterUserException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public MysterUserException(String message) {
        super(message);
    }

}
