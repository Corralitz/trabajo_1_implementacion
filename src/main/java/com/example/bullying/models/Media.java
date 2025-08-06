package com.example.bullying.models;

enum Type {
    PHOTO_DRAWING,
    MEME,
    VIDEO
}

public class Media {
    private Long id;
    // private RevengePlan revengePlan;
    private Type type;
    private String url;
    private String caption;
}
