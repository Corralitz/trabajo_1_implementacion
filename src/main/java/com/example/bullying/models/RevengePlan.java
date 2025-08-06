package com.example.bullying.models;

import java.time.LocalDate;

enum SuccessLevel {
    EPIC_FAIL,
    MILDLY_FUNNY,
    FUNNY_ICONIC
}

public class RevengePlan {
    private Long id;
    private String title;
    private String description;
    // private Bully
    private Boolean isExecuted;
    private LocalDate datePlanned;
}
