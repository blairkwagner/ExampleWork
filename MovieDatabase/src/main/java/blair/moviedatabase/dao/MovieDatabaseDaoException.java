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
public class MovieDatabaseDaoException extends Exception {

    public MovieDatabaseDaoException(String message) {
        super(message);
    }

    public MovieDatabaseDaoException(String message, Throwable cause) {
        super(message, cause);
    }

}
