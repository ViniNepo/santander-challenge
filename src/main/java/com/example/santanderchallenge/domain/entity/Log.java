package com.example.santanderchallenge.domain.entity;

import java.time.LocalDateTime;

public class Log {
    private Long id;
    private String cep;
    private LocalDateTime searchDate;
    private String responseAPI;

    public Log() {}

    public Log(Long id, String cep, LocalDateTime searchDate, String responseAPI) {
        this.id = id;
        this.cep = cep;
        this.searchDate = searchDate;
        this.responseAPI = responseAPI;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
    public LocalDateTime getSearchDate() { return searchDate; }
    public void setSearchDate(LocalDateTime searchDate) { this.searchDate = searchDate; }
    public String getResponseAPI() { return responseAPI; }
    public void setResponseAPI(String responseAPI) { this.responseAPI = responseAPI; }
}