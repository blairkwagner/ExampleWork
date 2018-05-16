/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blair.moviedatabase.ui;

import blair.moviedatabase.dto.MovieInfo;
import java.util.List;

/**
 *
 * @author blair
 */
public class MovieDatabaseView {

    private UserIO io;

    public MovieDatabaseView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add Movie to database");
        io.print("2. List all Movies");
        io.print("3. Search a Movie by exact title");
        io.print("4. Search for movies containing");
        io.print("5. Remove a Movie");
        io.print("6. Edit a Movie");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 7);
    }

    public MovieInfo getNewMovieInfo() {
        String movieName = io.readString("Please enter Movie Name");
        String mPAARating = io.readString("Please enter the MPAA Rating of the movie");
        String releaseDate = io.readString("Please enter the Release Date of the movie");
        String directorsName = io.readString("Please enter the Director's Name");
        String studio = io.readString("Please enter the Studio it was filmed at");
        String userRating = io.readString("Please enter your rating or any comments you have about the movie");

        MovieInfo currentMovie = new MovieInfo();
        currentMovie.setMovieName(movieName);
        currentMovie.setMPAARating(mPAARating);
        currentMovie.setReleaseDate(releaseDate);
        currentMovie.setDirectorsName(directorsName);
        currentMovie.setStudio(studio);
        currentMovie.setUserRating(userRating);

        return currentMovie;
    }

    public MovieInfo updateMovieChoices(MovieInfo editMovie) {
        String mPAARating = io.readString("Edit MPAA Rating **" + editMovie.getMPAARating() + "** (or hit Enter)");
        String releaseDate = io.readString("Edit Release Date of the movie **" + editMovie.getReleaseDate() + "** (or hit Enter)");
        String directorsName = io.readString("Edit the Director's Name **" + editMovie.getDirectorsName() + "** (or hit Enter)");
        String studio = io.readString("Edit  the Studio it was filmed at **" + editMovie.getStudio() + "** (or hit Enter)");
        String userRating = io.readString("Edit your rating or any comments you have about the movie\n"
                + "**" + editMovie.getUserRating() + "** (or hit Enter)");
        if (!mPAARating.isEmpty()) {
            editMovie.setMPAARating(mPAARating);
        }
        if (!releaseDate.isEmpty()) {
            editMovie.setReleaseDate(releaseDate);
        }
        if (!directorsName.isEmpty()) {
            editMovie.setDirectorsName(directorsName);
        }
        if (!studio.isEmpty()) {
            editMovie.setStudio(studio);
        }
        if (!userRating.isEmpty()) {
            editMovie.setUserRating(userRating);
        }

        return editMovie;
    }

    public void printAllInfo(MovieInfo movie) {
        io.print("Movie ID#: " + movie.getMovieID() + "\n"
                + "Movie Title: " + movie.getMovieName() + "\n"
                + "MPAA Rating: " + movie.getMPAARating() + "\n"
                + "Release Date: " + movie.getReleaseDate() + "\n"
                + "Director's Name: " + movie.getDirectorsName() + "\n"
                + "Studio: " + movie.getStudio() + "\n"
                + "User Rating/Comments: " + movie.getUserRating() + "\n");
    }

    public void displayNewMovieBanner() {
        io.print("=== Add Movie===");
    }

    public void displayCreateSuccessBanner() {
        io.print("Movie successfully added.  Please hit enter to continue");
    }

    public void displayMovieList(List<MovieInfo> movieList) {
        for (MovieInfo currentMovie : movieList) {
            printAllInfo(currentMovie);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayAllBanner() {
        io.print("=== Display All Movies ===");
    }

    public void searchMovieBanner() {
        io.print("=== Display Movie ===");
    }

    public void searchContainingMovieBanner() {
        io.print("=== Display Movies Containing ===");
    }

    public void displayEditMovieBanner() {
        io.print("=== Edit Movie ===");
    }

    public String getMovieNameChoice() {
        return io.readString("Please enter the Movie name.");
    }

    public int getMovieIDChoice() {
        return io.readInt("Please enter the Movie ID.");
    }

    public void displayUpdateSuccess() {
        io.print("You have successfully updated the movie!");
    }

    public void displayMovie(MovieInfo movie) {
        if (movie != null) {
            printAllInfo(movie);
        } else {
            io.print("No such movie.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void removedMovieBanner() {
        io.print("=== Remove Movie ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("Movie successfully removed. Please hit enter to conitinue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMessage) {
        io.print("=== Error Message ===");
        io.print(errorMessage);
    }

}
