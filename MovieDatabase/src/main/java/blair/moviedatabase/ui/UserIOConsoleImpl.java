/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blair.moviedatabase.ui;

import java.util.Scanner;

/**
 *
 * @author blair
 */
public class UserIOConsoleImpl implements UserIO {

 private Scanner input = new Scanner(System.in);
    
    @Override
    public void print(String prompt) {
        System.out.println(prompt);
    }
    
    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return input.nextLine();
    }

    @Override
    public int readInt(String prompt) {
        boolean valid = false;
        int result = 0;
        do {
            String value = null;
            try {
                value = readString(prompt);
                result = Integer.parseInt(value);
                valid = true;
            } catch (NumberFormatException ex) {
                System.out.printf("The value '%s' you entered is not a number\n", value);
            }
        } while (!valid);
        return result;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        boolean valid = false;
        int result = 0;
        do {
            result = readInt(prompt);
            if (result >= min && result <= max) {
                valid = true;
            } else {
                System.out.printf("Value must be between %d and %d. \n", min, max);
            }
        } while (!valid);
        return result;
    }
    
    @Override
    public double readDouble(String prompt) {
        boolean valid = false;
        double result = 0.0;
        do {
            String value = null;
            try {
                value = readString(prompt);
                result = Double.parseDouble(value);
                valid = true;
            } catch (NumberFormatException ex) {
                System.out.printf("The value '%s' you entered is not a number\n", value);
            }
        } while (!valid);
        return result;
    }
        
    @Override
    public double readDouble(String prompt, double min, double max) {
        boolean valid = false;
        double result = 0.0;
        do {
            result = readDouble(prompt);
            if (result >= min && result <= max) {
                valid = true;
            } else {
                System.out.printf("Value must be between '%s' and '%s'. \n", min, max);
            }
        } while (!valid);
        return result;
    }   
}