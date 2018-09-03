/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Inventory;
import com.sg.vendingmachine.service.VendingMachineInsufficientFundsException;
import com.sg.vendingmachine.service.VendingMachineOutOfStockException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author blair
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao{
    
    public static final String VEND_FILE = "inventory.txt";
    public static final String DELIMITER = "::";
    private List<Inventory> inventory = new ArrayList<>();

    @Override
    public List<Inventory> getAllInventory() throws VendingMachinePersistenceException {
        loadRoster();
        return inventory;
    }

    @Override
    public Inventory getItem(int i) throws VendingMachinePersistenceException, VendingMachineOutOfStockException, VendingMachineInsufficientFundsException {
        loadRoster();
        Inventory returnItem = null;
        int counter = 1;
        for(Inventory c : inventory) {
            if(i == counter) {
                returnItem = c;
                break;
            }
            counter++;
        }
        return returnItem;
    }
    
    private void loadRoster() throws VendingMachinePersistenceException {
        Scanner scanner;
        
        ArrayList<Inventory> temp = new ArrayList<>();
        
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(VEND_FILE)));           
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException("Unable to load into memory.", e);
        }
        
        String currentLine;
        String[] currentTokens;
        int stock = 0;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Inventory currentItem = new Inventory();
            currentItem.setName(currentTokens[0]);
            BigDecimal cost = new BigDecimal(currentTokens[1]);
            currentItem.setCost(cost);
            stock = Integer.parseInt(currentTokens[2]);
            currentItem.setStock(stock);
            temp.add(currentItem);
        }
        scanner.close();
        
        if(inventory != temp) {
            inventory = temp;
        }
    }
    
    @Override
    public void updateStock(Inventory item) throws VendingMachinePersistenceException {
        
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(VEND_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException("Could not update inventory");
        }
        int newStock = item.getStock() - 1;
        item.setStock(newStock);
        List<Inventory> inventoryList = inventory;
        for (Inventory currentItem: inventoryList) {
    
            out.println(currentItem.getName() + DELIMITER + currentItem.getCost() + DELIMITER + currentItem.getStock());
            out.flush();
        }
        out.close();
    }
    
}
