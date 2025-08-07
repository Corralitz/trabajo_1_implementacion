package com.example.bullying.models;

import com.example.bullying.dto.RevengePlanDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "bully", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @JsonIgnore
    private List<RevengePlan> revengePlan;

    @ManyToOne()
    @JoinColumn(name = "clique_id", nullable = true)
    private Clique clique;

}