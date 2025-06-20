package com.university.finance.exception;

public class OutstandingPaymentsException extends RuntimeException {
    public OutstandingPaymentsException(String message) {
        super(message);
    }
}