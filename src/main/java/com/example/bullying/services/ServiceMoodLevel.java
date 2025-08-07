package com.example.bullying.services;

import com.example.bullying.exceptions.NameException;
import com.example.bullying.dao.IMoodLevelDAO;
import com.example.bullying.dto.MoodLevelDTO;
import com.example.bullying.models.MoodLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceMoodLevel implements IServiceMoodLevel {

    @Autowired
    private IMoodLevelDAO moodLevelDao;

    @Override
    public List<MoodLevelDTO> getMoodLevels() {
        return moodLevelDao.findAll().stream().map(
                moodLevel -> {
                    return new MoodLevelDTO(
                            moodLevel.getDate(),
                            moodLevel.getMoodLevel(),
                            moodLevel.getNote()
                    );
                }
        ).toList();
    }

    @Override
    public MoodLevel addMoodLevel(MoodLevelDTO dto) {
        MoodLevel moodLevel = new MoodLevel();
        moodLevel.setDate(dto.date());
        moodLevel.setMoodLevel(dto.moodLevel());
        moodLevel.setNote(dto.note());

        // Check if a mood level for the same date already exists
        MoodLevel busqueda =  moodLevelDao.findById(moodLevel.getId()).orElse(null);
        if (busqueda != null) {
            throw new NameException("Mood Level already exists");
        }

        return moodLevelDao.save(moodLevel);
    }


    @Override
    public Optional<MoodLevel> removeMoodLevel(Long id) {
        Optional<MoodLevel> moodLevel = moodLevelDao.findById(id);
        moodLevel.ifPresent(moodLevelDao::delete);
        return moodLevel;
    }

    @Override
    public MoodLevel getMoodLevelById(Long id) {
        return moodLevelDao.findById(id)
                .orElseThrow(() -> new NameException("Mood Level not found"));

    }
}
