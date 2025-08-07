package com.example.bullying.controllers;

import com.example.bullying.dto.MoodLevelDTO;
import com.example.bullying.models.MoodLevel;
import com.example.bullying.services.IServiceMoodLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mood-levels")
public class MoodLevelController {

    @Autowired
    private IServiceMoodLevel moodLevelService;

    @GetMapping("/")
    public ResponseEntity<List<MoodLevelDTO>> getAllMoodLevels() {
        List<MoodLevelDTO> moodLevels = moodLevelService.getMoodLevels();
        return ResponseEntity.ok(moodLevels);
    }

    @PostMapping("/")
    public ResponseEntity<MoodLevel> addMoodLevel(@RequestBody MoodLevelDTO moodLevelDTO) {
        MoodLevel created = moodLevelService.addMoodLevel(moodLevelDTO);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMoodLevel(@PathVariable Long id) {
        return moodLevelService.removeMoodLevel(id)
                .map(deleted -> ResponseEntity.ok().build())
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/mood-level/{id}")
    public ResponseEntity<MoodLevel> getMoodLevelById(@PathVariable Long id) {
        MoodLevel moodLevel = moodLevelService.getMoodLevelById(id);
        return moodLevel != null ? ResponseEntity.ok(moodLevel) : ResponseEntity.notFound().build();
    }
}
