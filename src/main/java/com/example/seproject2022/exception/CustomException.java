package com.example.seproject2022.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final String path;

    public CustomException(String message, HttpStatus httpStatus, String path) {
        super(message);
        this.httpStatus = httpStatus;
        this.path = path;
    }
}