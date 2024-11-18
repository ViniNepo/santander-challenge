package com.example.santanderchallenge.domain.errors;

public class ExternalServiceException extends DomainException {
    public ExternalServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
