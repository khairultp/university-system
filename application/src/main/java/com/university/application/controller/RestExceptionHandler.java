package com.university.application.controller;

import com.university.academics.exception.StudentNotActiveException;
import com.university.finance.exception.OutstandingPaymentsException;
import com.university.studentaffairs.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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