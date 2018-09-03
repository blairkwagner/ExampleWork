/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import com.sg.flooring.dto.Tax;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author blair
 */
public class StubTaxDao implements FlooringTaxDao{
    
    private Tax tax;
    private List<Tax> taxes = new ArrayList<>();
    private BigDecimal taxRate = new BigDecimal("11");
    
    public StubTaxDao() {
        tax = new Tax("CO");
        tax.setTaxRate(taxRate);
        taxes.add(tax);
    }

    @Override
    public List<Tax> getAllTaxInfo() throws PersistenceException {
        return taxes;
    }
}
