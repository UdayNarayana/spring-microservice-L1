package com.example.demo.entity;

import java.util.List;

public class MovieCatalouge {

    private String movie;
    private int rating;

    public MovieCatalouge(){}

    public MovieCatalouge(String movie, int rating) {
        this.movie = movie;
        this.rating = rating;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
