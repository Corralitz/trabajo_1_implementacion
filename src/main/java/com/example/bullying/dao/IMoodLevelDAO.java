package com.example.bullying.dao;

import com.example.bullying.models.MoodLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMoodLevelDAO extends JpaRepository<MoodLevel, Long> {
}
