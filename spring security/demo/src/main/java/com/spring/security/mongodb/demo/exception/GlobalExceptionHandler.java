package com.spring.security.mongodb.demo.exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice

public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)  // Nếu validate fail thì trả về 400
    @ExceptionHandler(BindException.class)
    public ResponseEntity handleBindException(BindException e) {
        String errorMessage = "Request khong hop le,username va password khong duoc bo trong 1-10";
        if (e.getBindingResult().hasErrors())
            e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", 0);
        responseBody.put("message", errorMessage);
        return ResponseEntity.status(400).body(responseBody);
    }

}
