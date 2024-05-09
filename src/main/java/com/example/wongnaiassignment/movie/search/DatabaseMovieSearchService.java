package com.example.wongnaiassignment.movie.search;

import com.example.wongnaiassignment.movie.Movie;
import com.example.wongnaiassignment.movie.MovieRepository;
import com.example.wongnaiassignment.movie.MovieSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
public class DatabaseMovieSearchService implements MovieSearchService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> search(String query) {
        //TODO: Step 3 => Please make all test in DatabaseMovieSearchServiceIntegrationTest run pass.
        // This database search method must use only MovieRepository.findByNameContains(String), you also have to implement
        // MovieDataSynchronizer.forceSync() to load all movie data, using MovieDataService, into MovieRepository.
        // Do not change @Component annotation on this class

        return movieRepository.findByNameContains(query.toLowerCase());
    }
}
