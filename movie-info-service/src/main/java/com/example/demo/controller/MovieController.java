package com.example.demo.controller;

import com.example.demo.model.Movie;
import com.example.demo.model.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movie-info")
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;

    @GetMapping("/{movieId}")
    public Movie getMovies(@PathVariable("movieId") int movieId){

        MovieSummary movieSummary = restTemplate.getForObject(
          "https://api.themoviedb.org/3/movie/"+movieId+"?api_key="+apiKey,
                MovieSummary.class);

        return new Movie(movieId,movieSummary.getTitle(),movieSummary.getOverview());

    }


}
