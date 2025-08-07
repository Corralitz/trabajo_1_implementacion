package com.example.bullying.services;

import com.example.bullying.dto.MoodLevelDTO;
import com.example.bullying.models.MoodLevel;

import java.util.List;
import java.util.Optional;

public interface IServiceMoodLevel {

    public List<MoodLevelDTO> getMoodLevels();
    public MoodLevel addMoodLevel(MoodLevelDTO moodLevel);
    public Optional<MoodLevel> removeMoodLevel(Long id);
    public MoodLevel getMoodLevelById(Long id);
}
