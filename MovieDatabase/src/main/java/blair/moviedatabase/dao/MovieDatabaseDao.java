/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blair.moviedatabase.dao;

import blair.moviedatabase.dto.MovieInfo;
import java.util.List;

/**
 *
 * @author blair
 */
public interface MovieDatabaseDao {

    MovieInfo addMovie(MovieInfo movie)
            throws MovieDatabaseDaoException;

    List<MovieInfo> getAllMovies()
            throws MovieDatabaseDaoException;

    MovieInfo getMovie(String movieName) throws MovieDatabaseDaoException;

    MovieInfo getMovie(int movieID) throws MovieDatabaseDaoException;

    MovieInfo removeMovie(int movieID) throws MovieDatabaseDaoException;

    MovieInfo getMovieTitle(MovieInfo movie)
            throws MovieDatabaseDaoException;

    List<MovieInfo> searchForMovies(String movieName) throws MovieDatabaseDaoException;

    void updateMovie(MovieInfo oldMovie, MovieInfo newMovie) throws MovieDatabaseDaoException;

}
