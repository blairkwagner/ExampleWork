/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Inventory;
import com.sg.vendingmachine.service.VendingMachineInsufficientFundsException;
import com.sg.vendingmachine.service.VendingMachineOutOfStockException;
import java.util.List;

/**
 *
 * @author blair
 */
public interface VendingMachineDao {
    
    List<Inventory> getAllInventory() throws VendingMachinePersistenceException;
    
    Inventory getItem(int i) throws VendingMachinePersistenceException, VendingMachineOutOfStockException, VendingMachineInsufficientFundsException;
    
    void updateStock(Inventory item) throws VendingMachinePersistenceException;
}
