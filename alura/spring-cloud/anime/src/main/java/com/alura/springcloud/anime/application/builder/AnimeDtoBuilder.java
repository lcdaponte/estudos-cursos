package com.alura.springcloud.anime.application.builder;

import com.alura.springcloud.anime.application.dto.AnimeDTO;

import java.time.LocalDate;

public class AnimeDtoBuilder {

    private String name;
    private String description;
    private LocalDate release_date;

    public AnimeDtoBuilder(){

    }

    public AnimeDtoBuilder withName(final String name){
        this.name = name;
        return this;
    }

    public AnimeDtoBuilder withDescription(final String description){
        this.description = description;
        return this;
    }

    public AnimeDtoBuilder withReleaseDate(final LocalDate release_date){
        this.release_date = release_date;
        return this;
    }


    public AnimeDTO convertAnimeIntoAnimeDto(){
        return new AnimeDTO(this.name, this.description, this.release_date);
    }
}
