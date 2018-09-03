/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import com.sg.flooring.dto.Tax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author blair
 */
public class TaxDaoFileImpl implements FlooringTaxDao {
    
    public static final String TAX_FILE = "tax.txt";
    public static final String DELIMITER = "::";
    private ArrayList<Tax> tax = new ArrayList<>();
    
    @Override
    public List<Tax> getAllTaxInfo() throws PersistenceException {
        loadTax();
        return tax;
    }
    
    private void loadTax() throws PersistenceException {
        Scanner scanner;
        
        ArrayList<Tax> temp = new ArrayList<>();
        
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(TAX_FILE)));           
        } catch (FileNotFoundException e) {
            throw new PersistenceException("Unable product into memory.", e);
        }
        
        String currentLine;
        String[] currentTokens;
        
        
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Tax currentTax = new Tax(currentTokens[0]);
            BigDecimal taxRate = new BigDecimal(currentTokens[1]);
            currentTax.setTaxRate(taxRate);
            temp.add(currentTax);
        }
        scanner.close();
        
        if(tax != temp) {
            tax = temp;
        }
    }
    
}
