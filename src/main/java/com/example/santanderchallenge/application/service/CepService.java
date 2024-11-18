package com.example.santanderchallenge.application.service;

import com.example.santanderchallenge.domain.entity.Log;
import com.example.santanderchallenge.domain.errors.CepNotFoundException;
import com.example.santanderchallenge.domain.errors.ExternalServiceException;
import com.example.santanderchallenge.domain.repository.LogRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
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
        if (cep == null || cep.isEmpty()) {
            throw new IllegalArgumentException("CEP cannot be null or empty");
        }

        String responseAPI;
        try {
            responseAPI = webClient.get()
                    .uri(mockApiBaseUrl + "/" + cep)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        } catch (WebClientResponseException.NotFound e) {
            throw new CepNotFoundException(cep);
        } catch (WebClientException e) {
            throw new ExternalServiceException("Error getting mock CEP", e);
        }

        Log log = new Log(null, cep, LocalDateTime.now(), responseAPI);
        logRepository.save(log);

        return log;
    }


}