package com.example.santanderchallenge.adapter.controller;

import com.example.santanderchallenge.application.service.CepService;
import com.example.santanderchallenge.domain.entity.Log;
import com.example.santanderchallenge.domain.errors.CepNotFoundException;
import com.example.santanderchallenge.domain.errors.ExternalServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cep")
public class CepController {
    private final CepService cepService;

    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<?> searchCep(@PathVariable String cep) {
        try {
            Log log = cepService.searchCep(cep);
            return ResponseEntity.ok(log);
        } catch (CepNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (ExternalServiceException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error on mock service: " + e.getMessage());
        }
    }
}
