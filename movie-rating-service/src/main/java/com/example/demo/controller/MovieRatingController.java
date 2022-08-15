package com.example.demo.controller;

import com.example.demo.entitty.MovieRating;
import com.example.demo.entitty.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class MovieRatingController {

    @GetMapping("/{userId}")
    public UserRating getMovieRating(@PathVariable("userId") String userId){

        List<MovieRating> movieRatings = Arrays.asList(
                new MovieRating(100,5),
                new MovieRating(200,4)
        );
        UserRating userRating = new UserRating();
        userRating.setRatings(movieRatings);

        return userRating;
    }
}
