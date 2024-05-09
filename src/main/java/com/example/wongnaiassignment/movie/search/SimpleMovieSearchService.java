package com.example.wongnaiassignment.movie.search;

import com.example.wongnaiassignment.movie.Movie;
import com.example.wongnaiassignment.movie.MovieSearchService;
import com.example.wongnaiassignment.movie.external.MovieDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;


@Component
public class SimpleMovieSearchService implements MovieSearchService{

    @Autowired
    private MovieDataServiceImpl movieDataService;
    @Override
    public List<Movie> search(String query) {
        return  movieDataService.fetchAll().stream()
                .filter(m -> !m.getTitle().equals(query) && m.getTitle().toLowerCase().matches(".*\\b"+query.toLowerCase()+"\\b.*"))
                .map(m -> new Movie(m)).toList();
    }
}


