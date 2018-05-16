/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blair.moviedatabase.dto;

/**
 *
 * @author blair
 */
public class MovieInfo {

    private int movieID;
    private String movieName;
    private String mPAARating;
    private String releaseDate;
    private String directorsName;
    private String studio;
    private String userRating;

    public MovieInfo() {
    }

    public MovieInfo(int movieID) {
        this.movieID = movieID;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getMPAARating() {
        return mPAARating;
    }

    public void setMPAARating(String mPAARating) {
        this.mPAARating = mPAARating;
    }

    public String getDirectorsName() {
        return directorsName;
    }

    public void setDirectorsName(String directorsName) {
        this.directorsName = directorsName;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

}
