package com.example.bullying.dao;

import com.example.bullying.models.Clique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICliqueDAO extends JpaRepository<Clique, Long> {
    Optional<Clique> findCliqueByName(String name);
}
