package com.example.demo.entity;

import java.util.List;

public class MovieRating {
    private int movieId;
    private int rating;
    private List<MovieRating> ratingList;

    public MovieRating(){}

    public MovieRating(int movieId, int rating, List<MovieRating> ratingList) {
        this.movieId = movieId;
        this.rating = rating;
        this.ratingList = ratingList;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<MovieRating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<MovieRating> ratingList) {
        this.ratingList = ratingList;
    }
}
