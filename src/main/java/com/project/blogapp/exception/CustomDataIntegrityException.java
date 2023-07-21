package com.project.blogapp.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

public class CustomDataIntegrityException extends RuntimeException{
    public CustomDataIntegrityException(String message, Throwable cause) {
        super(message, cause);
    }
}
