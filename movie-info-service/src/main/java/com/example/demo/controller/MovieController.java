package com.example.demo.controller;

import com.example.demo.model.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-info")
public class MovieController {

    @GetMapping("/{movieId}")
    public Movie getMovies(@PathVariable("movieId") int movieId){

        return new Movie(movieId,"Test Name");

    }


}
