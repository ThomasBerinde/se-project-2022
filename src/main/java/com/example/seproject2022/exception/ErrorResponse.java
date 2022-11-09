package com.example.seproject2022.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private final HttpStatus httpStatus;
    private final String message;
    private final LocalDateTime timeStamp;
    private final String path;
}
