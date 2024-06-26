package com.example.wongnaiassignment.search;

import com.example.wongnaiassignment.MovieTestHelper;
import com.example.wongnaiassignment.movie.Movie;
import com.example.wongnaiassignment.movie.search.SimpleMovieSearchService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleMovieSearchServiceIntegrationTest {

    @Autowired
    private SimpleMovieSearchService searchService;

    @Test
    public void testFindSingleKeywordContainInTitle() {
        List<Movie> result = this.searchService.search("Glorious");
        assertGloriousMovieKeyword(result);
    }

    private void assertGloriousMovieKeyword(List<Movie> result) {
        Assert.assertThat(result.size(), Matchers.equalTo(9));
        Assert.assertThat(MovieTestHelper.toMovieNames(result),
                Matchers.hasItems("The Glorious Lady",
                        "The Glorious Fool",
                        "One Glorious Day",
                        "One Glorious Night",
                        "One Glorious Scrap",
                        "Glorious Betsy",
                        "The Glorious Trail",
                        "His Glorious Night",
                        "Borat! Cultural Learnings of America for Make Benefit Glorious Nation of Kazakhstan"));

        List<String> actors = MovieTestHelper.findMatchedName(result, "His Glorious Night").getActors();
        Assert.assertThat(actors.size(), Matchers.equalTo(2));
        Assert.assertThat(actors, Matchers.hasItems("John Gilbert", "Catherine Dale Owen"));
    }

    @Test
    public void testPartialWordMustNotMatch() {
        List<Movie> result = searchService.search("Glorio");

        Assert.assertThat(result.size(), Matchers.equalTo(0));
    }

    @Test
    public void testFullMovieNameMustNotMatch() {
        List<Movie> result = searchService.search("The Glorious Lady");

        Assert.assertThat(result.size(), Matchers.equalTo(0));
    }

    @Test
    public void testMultiWordMustNotMatch() {
        List<Movie> result = searchService.search("Glorio Lady");

        Assert.assertThat(result.size(), Matchers.equalTo(0));
    }

    @Test
    public void testFindSingleKeywordContainInTitleWithCaseInsensitive() {
        List<Movie> result = searchService.search("glorious");

        assertGloriousMovieKeyword(result);
    }
}
