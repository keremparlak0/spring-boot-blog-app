package com.project.blogapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomDataIntegrityException.class)
    public ResponseEntity<String> handleDataIntegrityViolation(CustomDataIntegrityException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Data integrity violation occurred.");
    }
}
