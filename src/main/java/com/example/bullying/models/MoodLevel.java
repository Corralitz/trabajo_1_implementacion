package com.example.bullying.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "mood_levels")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MoodLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private int moodLevel;

    private String note;
}
