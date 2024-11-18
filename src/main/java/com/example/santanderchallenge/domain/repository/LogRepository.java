package com.example.santanderchallenge.domain.repository;

import com.example.santanderchallenge.domain.entity.Log;

import java.util.Optional;

public interface LogRepository {
    void save(Log log);
    Optional<Log> findById(Long id);
}