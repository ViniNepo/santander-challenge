package com.example.santanderchallenge.application.service;

import com.example.santanderchallenge.domain.entity.Log;
import com.example.santanderchallenge.domain.repository.LogRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;

public class CepService {
    private final LogRepository logRepository;
    private final WebClient webClient;

    @Value("${mock.api.base-url}")
    private String mockApiBaseUrl;

    public CepService(LogRepository logRepository, WebClient webClient) {
        this.logRepository = logRepository;
        this.webClient = webClient;
    }

    public Log searchCep(String cep) {
        String responseAPI = webClient.get()
                .uri(mockApiBaseUrl + "/" + cep)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        Log log = new Log(null, cep, LocalDateTime.now(), responseAPI);
        logRepository.save(log);

        return log;
    }
}