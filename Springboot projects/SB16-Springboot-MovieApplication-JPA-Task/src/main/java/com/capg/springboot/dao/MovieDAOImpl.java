package com.capg.springboot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capg.springboot.entities.Movies;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MovieDAOImpl implements MovieDAOI {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Movies createMovie(Movies movie) {
        entityManager.persist(movie);
        return movie;
    }

    @Override
    public Movies searchMovieByID(int movieID) {
        return entityManager.find(Movies.class , movieID);
    }

    @Override
    public Movies updateMovie(Movies movie) {

        Movies mov = searchMovieByID(movie.getMovieID());

        if(mov != null) {
            mov.setMovieName(movie.getMovieName());
            mov.setMovieDescription(movie.getMovieDescription());
            mov = entityManager.merge(mov);
        }

        return mov;
    }

    @Override
    public List<Movies> findAllMovies(){
        Query q = entityManager.createQuery("select movie from Movies movie");
        return q.getResultList();
    }

    @Override
    public void deleteMovie(int movieID) {
        Movies mov = entityManager.find(Movies.class , movieID);
        entityManager.remove(mov);
    }

    @Override
    public Movies addMovie(Movies movie) {
        entityManager.persist(movie);
        return movie;
    }
}