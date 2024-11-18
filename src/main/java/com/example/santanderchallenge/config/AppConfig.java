package com.example.santanderchallenge.config;

import com.example.santanderchallenge.adapter.persistence.LogRepositoryImpl;
import com.example.santanderchallenge.application.service.CepService;
import com.example.santanderchallenge.domain.repository.LogRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    @Bean
    public LogRepository logRepository(LogRepositoryImpl impl) {
        return impl;
    }

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder.build();
    }

    @Bean
    public CepService cepService(LogRepository logRepository, WebClient webClient) {
        return new CepService(logRepository, webClient);
    }
}