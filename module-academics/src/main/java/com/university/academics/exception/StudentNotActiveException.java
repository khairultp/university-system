package com.university.academics.exception;

public class StudentNotActiveException extends RuntimeException {
    public StudentNotActiveException(String message) {
        super(message);
    }
}