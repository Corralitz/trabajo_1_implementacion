package com.example.bullying.dao;

import com.example.bullying.models.Bully;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface IBullyDAO extends JpaRepository<Bully, Long> {
    Optional<Bully> findBullyByName(String name);
}
