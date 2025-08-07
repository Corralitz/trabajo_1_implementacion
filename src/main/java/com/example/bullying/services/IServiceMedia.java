package com.example.bullying.services;

import com.example.bullying.dto.MediaDTO;
import com.example.bullying.models.Media;

import java.util.List;
import java.util.Optional;

public interface IServiceMedia {
    public List<MediaDTO> getMoodLevels();
    public Media addMoodLevel(MediaDTO dto);
    public Optional<Media> removeMoodLevel(Long id);
    public Optional<Media> getMoodLevelById(Long id);
}
