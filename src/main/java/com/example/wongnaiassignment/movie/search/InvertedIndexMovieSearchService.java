package com.example.wongnaiassignment.movie.search;

import com.example.wongnaiassignment.movie.Movie;
import com.example.wongnaiassignment.movie.MovieRepository;
import com.example.wongnaiassignment.movie.MovieSearchService;
import com.example.wongnaiassignment.movie.sync.InvertedIndexMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InvertedIndexMovieSearchService implements MovieSearchService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> search(String query) {
        //TODO: Step 4 => Please implement in-memory inverted index to search movie by keyword.
        // You must find a way to build inverted index before you do an actual search.
        // Inverted index would looks like this:
        // -------------------------------
        // |  Term      | Movie Ids      |
        // -------------------------------
        // |  Star      |  5, 8, 1       |
        // |  War       |  5, 2          |
        // |  Trek      |  1, 8          |
        // -------------------------------
        // When you search with keyword "Star", you will know immediately, by looking at Term column, and see that
        // there are 3 movie ids contains this word -- 1,5,8. Then, you can use these ids to find full movie object from repository.
        // Another case is when you find with keyword "Star War", there are 2 terms, Star and War, then you lookup
        // from inverted index for Star and for War so that you get movie ids 1,5,8 for Star and 2,5 for War. The result that
        // you have to return can be union or intersection of those 2 sets of ids.
        // By the way, in this assignment, you must use intersection so that it left for just movie id 5.


        Set<Long> intersectSet = null;

       for(String term :query.toLowerCase().split("\\s+")){
           if(InvertedIndexMap.getTermIds().containsKey(term)){
               if(intersectSet == null){
                   intersectSet = new HashSet<>(InvertedIndexMap.getTermIds().get(term));
               }else{
                   intersectSet.retainAll(InvertedIndexMap.getTermIds().get(term));
               }
           }
       }



        return  intersectSet != null ? (List<Movie>) movieRepository.findAllById(intersectSet): new ArrayList<>();
    }
}
