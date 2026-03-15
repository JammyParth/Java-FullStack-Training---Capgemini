package com.capg.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.springboot.dao.MovieDAOI;
import com.capg.springboot.entities.Movies;

@Service
public class MovieServiceImpl implements MovieServiceI{
	
	@Autowired
	private MovieDAOI dao;
	
	public Movies createMovie(Movies movie) {
		return dao.createMovie(movie);
	}
	
	public Movies searchMovieByID(int movieID) {
		return dao.searchMovieByID(movieID);
	}
	
	public Movies updateMovie(Movies movie) {
		return dao.updateMovie(movie);
	}
	
	public List<Movies> findAllMovies(){
		return dao.findAllMovies();
	}
	
	public void deleteMovie(int movieID) {
		dao.deleteMovie(movieID);
	}
	
	public Movies addMovie(Movies movie) {
		return dao.addMovie(movie);
	}

	
	
}
