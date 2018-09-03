/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dto;

import java.math.BigDecimal;

/**
 *
 * @author blair
 */
public class Product {
    
    private int id;
    private String name;
    private BigDecimal costPerSquareFoot = new BigDecimal("0.00");
    private BigDecimal laborCostPerSquareFoot = new BigDecimal("0.00");
    
    public Product(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getCostPerSquareFoot() {
        return costPerSquareFoot;
    }

    public BigDecimal getLaborCostPerSquareFoot() {
        return laborCostPerSquareFoot;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCostPerSquareFoot(BigDecimal costPerSquareFoot) {
        this.costPerSquareFoot = costPerSquareFoot;
    }

    public void setLaborCostPerSquareFoot(BigDecimal laborCostPerSquareFoot) {
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
    }

    public int getId() {
        return id;
    }
    
}
