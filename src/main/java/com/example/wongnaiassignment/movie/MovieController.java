package com.example.wongnaiassignment.movie;

import com.example.wongnaiassignment.movie.external.MovieDataServiceImpl;
import com.example.wongnaiassignment.movie.external.MoviesResponse;
import com.example.wongnaiassignment.movie.search.SimpleMovieSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private SimpleMovieSearchService simpleMovieSearchService;

    @GetMapping("/search")
    public ResponseEntity<List<Movie>> getMoviesByName(@RequestParam String q){
        return ResponseEntity.ok(this.simpleMovieSearchService.search(q));
    }
}
