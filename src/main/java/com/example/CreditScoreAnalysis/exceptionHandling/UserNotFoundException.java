package com.example.CreditScoreAnalysis.exceptionHandling;


public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}