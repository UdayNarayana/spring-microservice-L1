package com.example.demo.entitty;

import java.util.List;

public class UserRating {

    private List<MovieRating> ratings;

    public UserRating(){}

    public UserRating(List<MovieRating> ratings) {
        this.ratings = ratings;
    }

    public List<MovieRating> getRatings() {
        return ratings;
    }

    public void setRatings(List<MovieRating> ratings) {
        this.ratings = ratings;
    }
}

