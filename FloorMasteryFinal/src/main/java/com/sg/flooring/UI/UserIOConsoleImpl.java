/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.UI;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author blair
 */
public class UserIOConsoleImpl implements UserIO {

    private Scanner input = new Scanner(System.in);

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public String readString(String prompt) {
        print(prompt);
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
                System.out.printf("The value '%s' is not a number.\n", value);
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
                System.out.printf("The value must be between %d and %d.\n", min, max);
            }
        } while (!valid);

        return result;
    }

    @Override
    public BigDecimal readBigDecimal(String prompt) {
        boolean valid = false;
        BigDecimal result = new BigDecimal("0.00");
        do {
            String value = null;
            try {
                value = readString(prompt);
                result = new BigDecimal(value);
                valid = true;
            } catch (NumberFormatException ex) {
                System.out.printf("The value '%s' is not a number.\n", value);
            }
        } while (!valid);
        result.setScale(2, RoundingMode.HALF_UP);
        return result;
    }

    @Override
    public BigDecimal readBigDecimal(String prompt, BigDecimal min, BigDecimal max) {

        boolean valid = false;
        BigDecimal result = new BigDecimal("0.00");
        int small = 0;
        int large = 0;

        do {
            result = readBigDecimal(prompt);
            small = result.compareTo(min);
            large = result.compareTo(max);
            if (small >= 0 && large <= 0) {
                valid = true;
            } else {
                System.out.printf("The value must be between " + min + " and " + max);
                print("");
            }
        } while (!valid);

        return result;
    }

    @Override
    public LocalDate readLocalDate(String prompt) {
        boolean keepGoing = true;
        LocalDate date = null;
        do {
            String input = readString(prompt);
            try {
                date = LocalDate.parse(input);
                keepGoing = false;
                
            } catch (DateTimeParseException e) {
                System.out.printf("%s is not readable. Please do this correctly..", input);
            }
        } while (keepGoing);
        return date;
    }

}
