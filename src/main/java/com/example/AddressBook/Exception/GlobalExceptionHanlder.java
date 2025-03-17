package com.example.AddressBook.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHanlder {
    @ExceptionHandler(AddressBookNotFoundException.class)
    public ResponseEntity<Map<String ,Object>> handleAddressNotFoundException(AddressBookNotFoundException ex){
        Map<String ,Object> error=new HashMap<>();
        error.put("message",ex.getMessage());
        error.put("status", HttpStatus.NOT_FOUND.value());
        return  new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RegistrationException.class)
    public ResponseEntity<Map<String, Object>> handleGlobalException(RegistrationException ex) {

        Map<String, Object> error = new HashMap<>();
        error.put("message", "An unexpected error occurred");
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(VerificationException.class)
    public ResponseEntity<Map<String, Object>> handleVerificationException(VerificationException ex) {


        Map<String, Object> error = new HashMap<>();
        error.put("message", ex.getMessage());

        return ResponseEntity.badRequest().body(error);
    }
}
