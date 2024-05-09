package com.example.wongnaiassignment.movie;

import com.example.wongnaiassignment.movie.search.InvertedIndexMovieSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private InvertedIndexMovieSearchService invertedIndexMovieSearchService;


    @GetMapping("/search")
    public ResponseEntity<List<Movie>> getMoviesByName(@RequestParam String q){
        return ResponseEntity.ok(this.invertedIndexMovieSearchService.search(q));
    }
}
