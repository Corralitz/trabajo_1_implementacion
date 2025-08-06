package com.example.bullying.models;

import jakarta.persistence.*;

public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    // private RevengePlan revengePlan;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column(unique = true)
    private String url;
    private String caption;
}
