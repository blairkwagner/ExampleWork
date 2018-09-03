/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import com.sg.flooring.dto.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author blair
 */
public class StubProductDao implements FlooringProductDao{
    
    private Product product;
    private List<Product> products = new ArrayList<>();
    private BigDecimal cost = new BigDecimal("4");
    
    public StubProductDao() {
        product = new Product(4);
        product.setName("Tile");
        product.setCostPerSquareFoot(cost);
        product.setLaborCostPerSquareFoot(cost);
        products.add(product);
    }
    

    @Override
    public List<Product> getAllProducts() throws PersistenceException {
        return products;
    }
    
}
