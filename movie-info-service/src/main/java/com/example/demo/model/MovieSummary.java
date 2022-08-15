package com.example.demo.model;

public class MovieSummary {
    private int id;
    private String title;
    private String overview;

    public MovieSummary(){}

    public MovieSummary(int id, String title, String overview) {
        this.id = id;
        this.title = title;
        this.overview = overview;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
