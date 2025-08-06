package com.example.bullying.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

enum Role {
    JOCK,
    GOSSIP,
    NERD_HATER,
    TEACHER_PET,
    OTHER
}

@Entity()
@Table(name="bullies")
@Data
@NoArgsConstructor

public class Bully {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    private String name;
    private String nickname;
    private Role highSchoolRole;
    // private Clique clique
    private String bullyingReason;
    private int levelOfAnnoyance;
}