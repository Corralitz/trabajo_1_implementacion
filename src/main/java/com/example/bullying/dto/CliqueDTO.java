package com.example.bullying.dto;

import jakarta.validation.constraints.NotBlank;

public record CliqueDTO(
        @NotBlank(message = "El nombre de la clique es obligatorio")
        String name,

        @NotBlank(message = "La descripción es obligatoria")
        String description
) {
}
