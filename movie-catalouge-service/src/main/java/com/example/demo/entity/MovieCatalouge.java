package com.example.demo.entity;

import java.util.List;

public class MovieCatalouge {

    private String movie;
    private int rating;
    private String desc;

    public MovieCatalouge(){}

    public MovieCatalouge(String movie, int rating, String desc) {
        this.movie = movie;
        this.rating = rating;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
