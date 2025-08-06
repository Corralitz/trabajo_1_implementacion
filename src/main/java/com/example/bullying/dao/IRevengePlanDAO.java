package com.example.bullying.dao;

import com.example.bullying.models.RevengePlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRevengePlanDAO extends JpaRepository<RevengePlan, Long> {
    List<RevengePlan> findRevengePlanById(Long id);
}
