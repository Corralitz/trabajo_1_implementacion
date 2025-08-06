package com.example.bullying.dao;

import com.example.bullying.models.Bully;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBullyDAO extends JpaRepository<Bully, Long> {
    Optional
}
