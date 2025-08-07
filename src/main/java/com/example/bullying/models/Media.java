package com.example.bullying.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "media")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    // private RevengePlan revengePlan;
    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Ingrese un tipo de recurso")
    private Type type;
    @Column(unique = true)
    @NotBlank(message = "Ingrese una URL")
    private String url;
    private String caption;
}
