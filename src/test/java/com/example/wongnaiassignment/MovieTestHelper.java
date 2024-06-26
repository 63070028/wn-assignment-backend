package com.example.wongnaiassignment;

import com.example.wongnaiassignment.movie.Movie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class MovieTestHelper {
    public static List<String> toMovieNames(Collection<Movie> movies) {
        List<String> names = new ArrayList<>();

        for (Movie movie : movies) {
            names.add(movie.getName());
        }

        return names;
    }

    public static Movie findMatchedName(Collection<Movie> movies, String name) {
        for (Movie movie : movies) {
            if (Objects.equals(movie.getName(), name)) {
                return movie;
            }
        }
        throw new RuntimeException("No movie matched name: " + name);
    }
}
