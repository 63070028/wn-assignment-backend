package com.example.wongnaiassignment.movie.external;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class MovieDataServiceImpl implements MovieDataService{

    private final String MOVIE_DATA_URL = "https://raw.githubusercontent.com/prust/wikipedia-movie-data/master/movies.json";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public MoviesResponse fetchAll() {
        ResponseEntity<MoviesResponse> response = restTemplate.getForEntity(MOVIE_DATA_URL, MoviesResponse.class);
        return response.getBody();
    }
}
