package com.example.santanderchallenge.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "logs")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cep")
    private String cep;

    @Column(name = "search_date")
    private LocalDateTime searchDate;

    @Column(name = "response_api", columnDefinition = "TEXT")
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