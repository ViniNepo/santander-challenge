package com.example.santanderchallenge.adapter.persistence;

import com.example.santanderchallenge.domain.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataLogRepository extends JpaRepository<Log, Long> {}