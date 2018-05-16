/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blair.moviedatabase.dao;

import blair.moviedatabase.dto.MovieInfo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author blair
        String[] currentTokens;

        if(movies.isEmpty() ) {
 */
public class MovieDatabaseDaoFileImpl implements MovieDatabaseDao {

  
    private final List<MovieInfo> movies = new ArrayList<>();
    public static final String MOVIE_INFO = "movie.txt";
    public static final String DELIMITER = "::";
    private int movieID;
    
    @Override
    public MovieInfo addMovie(MovieInfo movie) throws MovieDatabaseDaoException {
        loadRoster();
        int tempIndex = movies.size()-1;
        movieID = movies.get(tempIndex).getMovieID() + 1;
        movie.setMovieID(movieID);
        movies.add(movie);
        writeRoster();
        return movie;
    }

    @Override
    public List<MovieInfo> getAllMovies() throws MovieDatabaseDaoException {
        loadRoster();
        return  movies;  
    }

    @Override
    public MovieInfo getMovie(String movieName) throws MovieDatabaseDaoException {
        int i = 0;
         loadRoster();
         for (MovieInfo movie : movies) {
            if (movie.getMovieName().contains(movieName)) {
                   i=movies.indexOf(movie);
             } 
        } 

        return movies.get(i);
    }
        //method overload so that it can find movie by ID
        @Override
        public MovieInfo getMovie(int movieID) throws MovieDatabaseDaoException {
         int i = 0;
         loadRoster();
         for (MovieInfo movie : movies) {
            if (movie.getMovieID() ==movieID) {
                   i=movies.indexOf(movie);
             } 
        } 
        return movies.get(i);
    }
        
    @Override
    public List<MovieInfo> searchForMovies(String movieName) throws MovieDatabaseDaoException {
        List<MovieInfo> tempMovies = new ArrayList<>();
        int i = 0;
             for (MovieInfo movie : movies) {
                if (movie.getMovieName().toLowerCase().contains(movieName.toLowerCase())) {
                       i=movies.indexOf(movie);
                       tempMovies.add(movies.get(i));
                 } 
              }
        return tempMovies;
    }
    
    @Override
    public MovieInfo removeMovie(int movieID) throws MovieDatabaseDaoException {
        int i = 0;
        for (MovieInfo movie : movies) {
            if(movie.getMovieID() == movieID) {
                i=movies.indexOf(movie);
            }
        }
        MovieInfo returnMovie =movies.remove(i);
        writeRoster();
        return returnMovie;
    }
    
    public void updateMovie(MovieInfo oldMovie , MovieInfo newMovie) throws MovieDatabaseDaoException{
        int i = movies.indexOf(oldMovie);
        removeMovie(oldMovie.getMovieID());
        movies.add(i , newMovie);
        writeRoster();
    }
    
    public void loadRoster() throws MovieDatabaseDaoException {
        Scanner scanner;
        try {
            scanner = new Scanner(
                            new BufferedReader(
                                new FileReader(MOVIE_INFO)));
        } catch (FileNotFoundException e) {
            throw new MovieDatabaseDaoException(
                "-_- Could not load roster data into memory.", e);
        }
        String currentLine;
        String[] currentTokens;
        if (movies.isEmpty()) {
            while(scanner.hasNextLine()){
                currentLine = scanner.nextLine();
                currentTokens = currentLine.split(DELIMITER);
                MovieInfo currentMovie = new MovieInfo(Integer.parseInt(currentTokens[0]));
                currentMovie.setMovieName(currentTokens[1]);
                currentMovie.setMPAARating(currentTokens[2]);
                currentMovie.setReleaseDate(currentTokens[3]);
                currentMovie.setDirectorsName(currentTokens[4]);
                currentMovie.setStudio(currentTokens[5]);
                currentMovie.setUserRating(currentTokens[6]);

                movies.add(currentMovie);
        }
        }
        scanner.close();
    }
    
    public void writeRoster() throws MovieDatabaseDaoException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(MOVIE_INFO));
        } catch (IOException e) {
            throw new MovieDatabaseDaoException(
	                "Could not save student data.", e);
        }

        List<MovieInfo> movieList = this.getAllMovies();
        for (MovieInfo currentMovie : movieList) {
            out.println(currentMovie.getMovieID() + DELIMITER
                                  + currentMovie.getMovieName() + DELIMITER
	                + currentMovie.getMPAARating() + DELIMITER 
	                + currentMovie.getReleaseDate() + DELIMITER
                                  + currentMovie.getDirectorsName() + DELIMITER
                                  + currentMovie.getStudio() + DELIMITER
	                + currentMovie.getUserRating());
            
            out.flush();
        }
        
        out.close();
    }

    @Override
    public MovieInfo getMovieTitle(MovieInfo movie) throws MovieDatabaseDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}