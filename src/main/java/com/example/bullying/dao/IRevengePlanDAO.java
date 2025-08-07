package com.example.bullying.dao;

import com.example.bullying.models.RevengePlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IRevengePlanDAO extends JpaRepository<RevengePlan, Long> {
    Optional<RevengePlan> findRevengePlanById(Long id);
}
