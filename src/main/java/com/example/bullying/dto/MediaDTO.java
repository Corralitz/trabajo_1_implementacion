package com.example.bullying.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import com.example.bullying.models.Type;

public record MediaDTO(
        @NotBlank(message = "Ingrese el tipo de recurso")
        Type type,
        String caption,
        @URL()
        String url
) {}
