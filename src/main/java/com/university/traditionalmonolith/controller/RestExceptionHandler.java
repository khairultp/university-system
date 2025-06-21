package com.university.traditionalmonolith.controller;

import com.university.traditionalmonolith.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * This removes boilerplate try-catch blocks from controllers and provides
 * consistent, meaningful HTTP responses for different business errors.
 */
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFound(StudentNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(StudentNotActiveException.class)
    public ResponseEntity<String> handleStudentNotActive(StudentNotActiveException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }

    @ExceptionHandler(OutstandingPaymentsException.class)
    public ResponseEntity<String> handleOutstandingPayments(OutstandingPaymentsException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }
}