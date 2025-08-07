package com.example.bullying.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity()
@Table(name="bullies")
@Data
@NoArgsConstructor

public class Bully {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nickname;

    @Enumerated(EnumType.STRING)
    private Role highSchoolRole;
    // private Clique clique
    private String bullyingReason;
    private int levelOfAnnoyance;
}