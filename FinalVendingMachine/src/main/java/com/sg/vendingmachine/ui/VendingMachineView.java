/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Inventory;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author blair
 */
public class VendingMachineView {

    private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public void dispenseChange(BigDecimal difference) {
        Change change = new Change();
        BigDecimal initial = difference;
        BigDecimal dollar = new BigDecimal("1");
        BigDecimal quarter = new BigDecimal(".25");
        BigDecimal dime = new BigDecimal(".1");
        BigDecimal nickel = new BigDecimal(".05");
        BigDecimal penny = new BigDecimal(".01");
        int changeDollars = 0;
        int changeQuarters = 0;
        int changeDimes = 0;
        int changeNickels = 0;
        int changePennys = 0;

        while (difference.compareTo(dollar) >= 0) {
            changeDollars++;
            difference = difference.subtract(dollar);
        }
        change.setDollars(changeDollars);
        while (difference.compareTo(quarter) >= 0) {
            changeQuarters++;
            difference = difference.subtract(quarter);
        }
        change.setQuarters(changeQuarters);
        while (difference.compareTo(dime) >= 0) {
            changeDimes++;
            difference = difference.subtract(dime);
        }
        change.setDimes(changeDimes);
        while (difference.compareTo(nickel) >= 0) {
            changeNickels++;
            difference = difference.subtract(nickel);
        }
        change.setNickels(changeNickels);
        while (difference.compareTo(penny) >= 0) {
            changePennys++;
            difference = difference.subtract(penny);
        }
        change.setPennys(changePennys);
        io.print("Here is your change: $" + initial + ". Now dispensing "
                + change.getDollars() + " dollars, " + change.getQuarters() + " quarters, " +
                change.getDimes() + " dimes, " + change.getNickels() + " nickels, " + change.getPennys() + " pennys.");
    }
    
    public void displayInventoryList(List<Inventory> inventoryList) {
        io.print("Vending Options");
        io.print(":) :0 :D :) ");
        int i = 1;
        for(Inventory currentItem : inventoryList) {
            if(currentItem.getStock() > 0) {
                io.print(i + ". " + currentItem.getName() + " $" + currentItem.getCost() + ". " + currentItem.getStock() + " left in stock");           
            }
            i++;
        }
                    
    }
    
    public int displayInitialOptions() {
        return io.readInt("Press 1 to add cash or press 2 to exit", 1, 2);
    }
    
    public int getSecondOption(List<Inventory> inventoryList) {
        return io.readInt("Choose the number or press 0 to add more cash", 0, inventoryList.size());
    }
    public BigDecimal getCash() {
        BigDecimal cash = io.readBigDecimal("Please add cash.  Maximum amount is $10.", BigDecimal.ZERO, BigDecimal.TEN);
        return cash;
    }
    
    public int getMenuChoice() {
        int choice = 0;
        choice = io.readInt("Press 1 to insert money or press 2 to exit", 1, 2);
        return choice;
    }
    
    public int getItemSelection(int max) {
        int choice = io.readInt("Choose the number for the item you would like to dispense", 1, max);
        return choice;
    }
    
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command");
    }
    
    public void displayExitMessage() {
        io.print("Thanks you");
    }
    
    public void displayCash(BigDecimal currentCash) {
        io.print("There is currently $" + currentCash + " in the machine.");
    }
    
    public void displayErrorMessage(String errMsg) {
        io.print("ERROR");
        io.print(errMsg);
    }
            
}
