package com.university.traditionalmonolith.exception;

public class StudentNotActiveException extends RuntimeException {
    public StudentNotActiveException(String message) {
        super(message);
    }
}