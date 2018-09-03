/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import com.sg.flooring.dto.Product;
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
public class ProductDaoFileImpl implements FlooringProductDao {
    
    public static final String PRODUCTS_FILE = "product.txt";
    public static final String DELIMITER = "::";
    private ArrayList<Product> products = new ArrayList<>();

    @Override
    public List<Product> getAllProducts() throws PersistenceException {
        loadProducts();
        return products;
    }
    
    private void loadProducts() throws PersistenceException {
        Scanner scanner;
        
        ArrayList<Product> temp = new ArrayList<>();
        
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(PRODUCTS_FILE)));           
        } catch (FileNotFoundException e) {
            throw new PersistenceException("Unable to load product into memory.", e);
        }
        
        String currentLine;
        String[] currentTokens;
        
        
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Product currentProduct = new Product(Integer.parseInt(currentTokens[0]));
            currentProduct.setName(currentTokens[1]);
            BigDecimal cost = new BigDecimal(currentTokens[2]);
            currentProduct.setCostPerSquareFoot(cost);
            BigDecimal laborCost = new BigDecimal(currentTokens[3]);
            currentProduct.setLaborCostPerSquareFoot(laborCost);
            temp.add(currentProduct);
        }
        scanner.close();
        
        if(products != temp) {
            products = temp;
        }
    }
    
}
