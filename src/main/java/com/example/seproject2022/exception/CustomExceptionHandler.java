package com.example.seproject2022.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = {CustomException.class})
    public ResponseEntity<Object> handleCustomException(CustomException customException) {
        ErrorResponse apiException = new ErrorResponse(
                customException.getHttpStatus(),
                customException.getMessage(),
                LocalDateTime.now(),
                customException.getPath()
        );
        return new ResponseEntity<>(apiException, customException.getHttpStatus());
    }
}
