package com.example.bullying.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "revenge_plans")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RevengePlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "bully_id", nullable = false)
    private Bully bully;

    private Boolean isExecuted;

    private LocalDate datePlanned;

    @Enumerated(EnumType.STRING)
    private SuccessLevel successLevel;

    @OneToMany(mappedBy = "revengePlan", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Media> mediaList;

}
