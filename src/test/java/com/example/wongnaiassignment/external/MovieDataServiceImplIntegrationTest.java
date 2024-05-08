package com.example.wongnaiassignment.external;

import com.example.wongnaiassignment.movie.external.MovieData;
import com.example.wongnaiassignment.movie.external.MovieDataServiceImpl;
import com.example.wongnaiassignment.movie.external.MoviesResponse;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.Arrays;
import java.util.Optional;



@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
public class MovieDataServiceImplIntegrationTest {
    @Autowired
    private MovieDataServiceImpl movieDataService;

    @Test
    public void testFetchAll() {
        MoviesResponse result = movieDataService.fetchAll();
        MatcherAssert.assertThat(result.size(), Matchers.equalTo(36273));
    }

    @Test
    public void testMappingDataCorrectly() {
        MoviesResponse result = movieDataService.fetchAll();
        Optional<MovieData> afterDark = result.stream()
                .filter(m -> m.getTitle().equals("One Night in Rome")).findFirst();

        MatcherAssert.assertThat(afterDark.isPresent(), Matchers.equalTo(true));
        MatcherAssert.assertThat(afterDark.get().getYear(), Matchers.equalTo(1924));
        MatcherAssert.assertThat(afterDark.get().getGenres(), Matchers.equalTo(Arrays.asList("Romance", "Drama", "Silent")));
        MatcherAssert.assertThat(afterDark.get().getCast(), Matchers.equalTo(Arrays.asList("Laurette Taylor", "Tom Moore")));
    }
}
