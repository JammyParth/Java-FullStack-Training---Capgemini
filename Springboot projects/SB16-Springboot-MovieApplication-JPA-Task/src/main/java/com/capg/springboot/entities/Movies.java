package com.capg.springboot.entities;

import jakarta.persistence.*;

@Entity
@Table(name="movies")
public class Movies {

    @Id
    @Column(name="movieid")
    private int movieID;

    @Column(name="movie_name")
    private String movieName;

    @Column(name="movie_description")
    private String movieDescription;

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    @Override
    public String toString() {
        return "Movie [movieID=" + movieID +
               ", movieName=" + movieName +
               ", movieDescription=" + movieDescription + "]";
    }
}