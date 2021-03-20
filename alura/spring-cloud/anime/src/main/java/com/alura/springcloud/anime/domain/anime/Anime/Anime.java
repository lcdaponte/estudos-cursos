package com.alura.springcloud.anime.domain.anime.Anime;

import java.time.LocalDate;

public class Anime {

    private String name;
    private String description;
    private LocalDate release_date;

    public Anime(final String name, final String description, final LocalDate release_date) {
        this.name = name;
        this.description = description;
        this.release_date = release_date;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }
}
