package com.example.wongnaiassignment.movie.sync;

import com.example.wongnaiassignment.movie.Movie;
import com.example.wongnaiassignment.movie.MovieRepository;
import com.example.wongnaiassignment.movie.external.MovieData;
import com.example.wongnaiassignment.movie.external.MovieDataServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class MovieDataSynchronizer {
    @Autowired
    private MovieDataServiceImpl movieDataService;

    @Autowired
    private MovieRepository movieRepository;


   @Transactional
    public void forceSync() {
        //TODO: implement this to sync movie into repository
        for(MovieData m: movieDataService.fetchAll()){
            movieRepository.save(new Movie(m));
        }


       for(Movie m: movieRepository.findAll()) {
           for (String term: m.getName().toLowerCase().split("\\s+")) {
               if(!InvertedIndexMap.getTermIds().containsKey(term)){
                   Set<Long> ids = new HashSet<>();
                   ids.add(m.getId());
                   InvertedIndexMap.getTermIds().put(term, ids);
               }else{
                   InvertedIndexMap.getTermIds().get(term).add(m.getId());
               }
           }
       }


    }
}
