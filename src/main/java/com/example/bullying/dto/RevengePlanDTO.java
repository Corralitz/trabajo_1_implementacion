package com.example.bullying.dto;

import com.example.bullying.models.SuccessLevel;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.UUID;

public record RevengePlanDTO(
        @NotBlank(message = "El título es obligatorio")
        String title,

        @NotBlank(message = "La descripción es obligatoria")
        String description,

        //@NotNull(message = "Debes asociar un bully")
        //Long bullyId,

        @NotNull(message = "Debes indicar si se ejecutó o no")
        Boolean isExecuted,

        @NotNull(message = "La fecha planificada es obligatoria")
        LocalDate datePlanned,

        @NotNull(message = "El nivel de éxito es obligatorio")
        SuccessLevel successLevel
) {
}
