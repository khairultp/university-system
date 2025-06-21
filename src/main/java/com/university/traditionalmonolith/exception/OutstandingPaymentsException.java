package com.university.traditionalmonolith.exception;

public class OutstandingPaymentsException extends RuntimeException {
    public OutstandingPaymentsException(String message) {
        super(message);
    }
}