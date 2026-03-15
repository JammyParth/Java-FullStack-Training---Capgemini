package com.capg.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capg.springboot.dao.MovieNotFoundException;
import com.capg.springboot.entities.Movies;
import com.capg.springboot.service.MovieServiceI;

@RestController
@RequestMapping(value="movies")

public class MoviesController {

    @Autowired
    private MovieServiceI service;


    // CREATE MOVIE
    @PostMapping(path="/create")
    public ResponseEntity<Boolean> createMovie(@RequestBody Movies movie) {

        service.createMovie(movie);

        ResponseEntity<Boolean> responseEntity =
                new ResponseEntity<Boolean>(true, HttpStatus.OK);

        return responseEntity;
    }


    // GET MOVIE BY ID
    @GetMapping(path="/getdetails/{movieID}")
    public ResponseEntity<Movies> searchMovieByID(@PathVariable("movieID") int movieID) {

        Movies movie = service.searchMovieByID(movieID);

        if(movie == null) {
            throw new MovieNotFoundException("Movie not found for id = " + movieID);
        }

        return new ResponseEntity<Movies>(movie,new HttpHeaders(),HttpStatus.OK);
    }


    // GET ALL MOVIES
    @GetMapping(path="/getAll")
    public ResponseEntity<List<Movies>> findAll(){

        List<Movies> list = service.findAllMovies();

        return new ResponseEntity<List<Movies>>(list,new HttpHeaders(),HttpStatus.OK);
    }


    // UPDATE MOVIE
    @PutMapping(path="/update")
    public ResponseEntity<Movies> updateMovie(@RequestBody Movies movie){

        movie = service.updateMovie(movie);

        return new ResponseEntity<Movies>(movie,new HttpHeaders(),HttpStatus.OK);
    }


    // DELETE MOVIE
    @DeleteMapping(path="/delete/{movieID}")
    public String deleteMovie(@PathVariable("movieID") int movieID){

        service.deleteMovie(movieID);

        return "Movie Deleted";
    }

}