package com.example.bullying.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cliques")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String description;

    @OneToMany(mappedBy = "clique", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Bully> bullies;
}
