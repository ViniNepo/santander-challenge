package com.example.santanderchallenge.domain.errors;

public class CepNotFoundException extends DomainException {
    public CepNotFoundException(String cep) {
        super("CEP not found: " + cep);
    }
}
