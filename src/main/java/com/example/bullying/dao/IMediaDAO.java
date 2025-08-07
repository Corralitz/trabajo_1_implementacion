package com.example.bullying.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bullying.models.Media;

import java.util.Optional;

public interface IMediaDAO extends JpaRepository<Media, Long> {
    Optional<Media> findById(Long id);
}
