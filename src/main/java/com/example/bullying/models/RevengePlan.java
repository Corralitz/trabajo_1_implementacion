package com.example.bullying.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "revenge_plans")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RevengePlan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    //@ManyToOne
    //@JoinColumn(name = "bully_id")
    //private Bully bully;

    private Boolean isExecuted;

    private LocalDate datePlanned;

    @Enumerated(EnumType.STRING)
    private SuccessLevel successLevel;
}
