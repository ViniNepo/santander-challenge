package com.example.santanderchallenge.adapter.persistence;

import com.example.santanderchallenge.domain.entity.Log;
import com.example.santanderchallenge.domain.repository.LogRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class LogRepositoryImpl implements LogRepository {
    private final SpringDataLogRepository repository;

    public LogRepositoryImpl(SpringDataLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Log log) {
        repository.save(log);
    }

    @Override
    public Optional<Log> findById(Long id) {
        return repository.findById(id);
    }
}