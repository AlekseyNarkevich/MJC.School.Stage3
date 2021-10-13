package com.epam.esm.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler
    public ResponseEntity<ExceptionEntity> handle(MethodArgumentNotValidException ex) {

        ExceptionEntity exceptionEntity = new ExceptionEntity();
        exceptionEntity.setErrorMessage(String.format("%s %s", LocalDateTime.now(), ex.getMessage()));
        exceptionEntity.setErrorCode(400);

        return ResponseEntity.badRequest().body(exceptionEntity);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionEntity> handle(NullPointerException ex) {
        return null;
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionEntity> handle(RuntimeException ex) {
        return null;
    }

}
