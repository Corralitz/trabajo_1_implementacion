package com.example.bullying.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bullying.models.Media;

public interface IMediaDAO extends JpaRepository<Media, Long> {}
