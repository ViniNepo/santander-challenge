package com.example.santanderchallenge.adapter.controller;

import com.example.santanderchallenge.application.service.CepService;
import com.example.santanderchallenge.domain.entity.Log;
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
    public ResponseEntity<Log> searchCep(@PathVariable String cep) {
        Log log = cepService.searchCep(cep);
        return ResponseEntity.ok(log);
    }
}
