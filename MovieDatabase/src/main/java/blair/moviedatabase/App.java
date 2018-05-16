/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blair.moviedatabase;


import blair.moviedatabase.controller.MovieController;
import blair.moviedatabase.dao.MovieDatabaseDao;
import blair.moviedatabase.dao.MovieDatabaseDaoException;
import blair.moviedatabase.dao.MovieDatabaseDaoFileImpl;
import blair.moviedatabase.ui.MovieDatabaseView;
import blair.moviedatabase.ui.UserIO;
import blair.moviedatabase.ui.UserIOConsoleImpl;

/**
 *
 * @author blair
 */
public class App {

    public static void main(String[] args) {
        UserIO myIO = new UserIOConsoleImpl();
        MovieDatabaseView myView = new MovieDatabaseView(myIO);
        MovieDatabaseDao myDao = new MovieDatabaseDaoFileImpl();
        MovieController controller;
        controller = new MovieController(myDao, myView);
        controller.run();
    }
}
