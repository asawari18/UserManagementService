package com.example.CreditScoreAnalysis.exceptionHandling;


public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }

}
