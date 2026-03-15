package com.capg.springboot.dao;

import java.util.List;

import com.capg.springboot.entities.Movies;

public interface MovieDAOI {
	
	Movies createMovie(Movies movie);
	
	Movies searchMovieByID(int movieID);
	
	Movies updateMovie(Movies movie);
	
	List<Movies> findAllMovies(); 
	
	void deleteMovie(int movieID);
	
	Movies addMovie(Movies movie);
	

}

