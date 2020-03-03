package com.example.nagendra.movie.Models;

public class Moviemodel {

    private String movieName;
    private int movieImage;

    public Moviemodel() {
    }

    public int getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(int movieImage) {
        this.movieImage = movieImage;
    }

    public Moviemodel(String movieName) {
        this.movieName = movieName;
    }

    public Moviemodel(String movieName, int movieImage) {
        this.movieName = movieName;
        this.movieImage = movieImage;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
