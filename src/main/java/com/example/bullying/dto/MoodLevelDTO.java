package com.example.bullying.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record MoodLevelDTO(
        @NotNull(message = "La fecha es obligatoria")
        LocalDate date,

        @Min(value = 1, message = "El nivel de ánimo mínimo es 1")
        @Max(value = 10, message = "El nivel de ánimo máximo es 10")
        int moodLevel,

        @NotBlank(message = "La nota no puede estar vacía")
        String note
) {
}
