package com.example.bullying.dto;

import com.example.bullying.models.RevengePlan;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import com.example.bullying.models.Type;

public record MediaDTO(
        @NotBlank(message = "Ingrese el tipo de recurso")
        Type type,
        String caption,
        @URL()
        String url,

        @NotBlank(message = "Se debe asignar a un plan de venganza")
        Long revengePlanId
) {}
