package com.example.bullying.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import com.example.bullying.models.Role;

public record BullyDTO(
        @NotBlank(message = "Ingrese un nombre") String name,
        @NotBlank(message = "Ingrese un apodo") String nickname,
        Role highSchoolRole,
        @NotBlank(message = "Ingrese una razon") String bullyingReason,
        @Min(1)
        @Max(10)
        int levelOfAnnoyance,

        @NotBlank(message = "Ingrese un nombre de grupo")
        String cliqueName

) {}
