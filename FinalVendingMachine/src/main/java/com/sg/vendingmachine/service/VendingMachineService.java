/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Inventory;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author blair
 */
public class VendingMachineService {
    
    VendingMachineDao dao;
    
    public VendingMachineService(VendingMachineDao dao) {
        this.dao = dao;
    }
    
    public List<Inventory> getAllInventory() throws VendingMachinePersistenceException {
        return dao.getAllInventory();
    }
    
    public Inventory getItem(int i) throws VendingMachinePersistenceException, VendingMachineInsufficientFundsException, VendingMachineOutOfStockException {
        if(dao.getItem(i).getStock() == 0) {
            throw new VendingMachineOutOfStockException(dao.getItem(i).getName() + " is clearly out of stock. Please make another selection");
        }
        if(dao.getItem(i).getCost().compareTo(currentCash) > 0) {
            throw new VendingMachineInsufficientFundsException("You can't purchase food here, you dont have the cash. Please enter more or choose another selection");
        }
        return dao.getItem(i);               
    }
    
    public void updateStock(Inventory item) throws VendingMachinePersistenceException {
        dao.updateStock(item);
    }
    BigDecimal currentCash = new BigDecimal("0.00");
    
    public BigDecimal getCurrentCash() {
        return currentCash;
    }
    
    public void setCurrentCash(BigDecimal currentCash) {
        this.currentCash = currentCash;
    }
    
    public BigDecimal returnChange(Inventory item) {
        BigDecimal difference = new BigDecimal("0.00");
        difference = getCurrentCash().subtract(item.getCost());
        setCurrentCash(BigDecimal.ZERO);
        return difference;
        
    }
}
