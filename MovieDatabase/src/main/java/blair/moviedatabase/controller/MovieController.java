/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blair.moviedatabase.controller;

import blair.moviedatabase.dao.MovieDatabaseDao;
import blair.moviedatabase.dao.MovieDatabaseDaoException;
import blair.moviedatabase.dao.MovieDatabaseDaoFileImpl;
import blair.moviedatabase.dto.MovieInfo;
import blair.moviedatabase.ui.MovieDatabaseView;
import blair.moviedatabase.ui.UserIO;
import blair.moviedatabase.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author blair
 */
public class MovieController {

    private MovieDatabaseView view;
    private MovieDatabaseDao dao;

    public MovieController(MovieDatabaseDao dao, MovieDatabaseView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        createMovie();
                        break;
                    case 2:
                        listMovies();
                        break;
                    case 3:
                        searchForMovie();
                        break;
                    case 4:
                        searchForMoviesContaining();
                        break;
                    case 5:
                        removeMovie();
                        break;
                    case 6:
                        editMovie();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (MovieDatabaseDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createMovie() throws MovieDatabaseDaoException {
        view.displayNewMovieBanner();
        MovieInfo newMovie = view.getNewMovieInfo();
        dao.addMovie(newMovie);
        view.displayCreateSuccessBanner();
    }

    private void listMovies() throws MovieDatabaseDaoException {
        view.displayAllBanner();
        List<MovieInfo> movieList = dao.getAllMovies();
        view.displayMovieList(movieList);
    }

    private void searchForMovie() throws MovieDatabaseDaoException {
        view.searchMovieBanner();
        String movieName = view.getMovieNameChoice();
        MovieInfo movie = dao.getMovie(movieName);
        view.displayMovie(movie);
    }

    private void searchForMoviesContaining() throws MovieDatabaseDaoException {
        view.searchContainingMovieBanner();
        String movieName = view.getMovieNameChoice();
        List<MovieInfo> movieSearch = dao.searchForMovies(movieName);
        view.displayMovieList(movieSearch);
    }

    private void removeMovie() throws MovieDatabaseDaoException {
        view.removedMovieBanner();
        int movieID = view.getMovieIDChoice();
        dao.removeMovie(movieID);
        view.displayRemoveSuccessBanner();
    }

    private void editMovie() throws MovieDatabaseDaoException {
        view.displayEditMovieBanner();
        int movieID = view.getMovieIDChoice();
        MovieInfo editMovie = dao.getMovie(movieID);
        MovieInfo updatedMovie = view.updateMovieChoices(editMovie);
        dao.updateMovie(editMovie, updatedMovie);
        view.displayUpdateSuccess();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
