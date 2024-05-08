package com.example.wongnaiassignment.movie;

import com.example.wongnaiassignment.movie.external.MovieData;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> actors = new ArrayList<>();

    public Movie(MovieData movieData){
        this.name = movieData.getTitle();
        this.actors = movieData.getCast();
    }

    /**
     * Required by JPA.
     */
    protected Movie() {
    }

    public Movie(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getActors() {
        return actors;
    }

}
