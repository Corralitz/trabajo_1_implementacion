package com.example.bullying.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import com.example.bullying.models.Role;

public record BullyDTO(
        @NotBlank(message = "Ingrese un nombre") String name,
        @NotBlank(message = "Ingrese un apodo") String nickname,
        @NotBlank(message = "Ingrese un rol") Role highSchoolRole,
        @NotBlank(message = "Ingrese una razon") String bullyingReason,
        @NotBlank(message = "Ingrese un nivel de molestia")
        @Min(1)
        @Max(10)
        int levelOfAnnoyance
) {}
