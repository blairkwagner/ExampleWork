/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Inventory;
import com.sg.vendingmachine.service.VendingMachineInsufficientFundsException;
import com.sg.vendingmachine.service.VendingMachineOutOfStockException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author blair
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao{
    
    private Inventory InvItem;
    private Inventory emptyItem;
    private Inventory item;
    private List<Inventory> inventoryList = new ArrayList<>();
    
    public VendingMachineDaoStubImpl() {
        InvItem = new Inventory();
        InvItem.setName("POP");
        InvItem.setCost(BigDecimal.TEN);
        InvItem.setStock(15);
        emptyItem = new Inventory();
        emptyItem.setName("Oreo");
        emptyItem.setCost(BigDecimal.ONE);
        emptyItem.setStock(0);
        item = new Inventory();
        item.setName("Animal Crackers");
        item.setCost(BigDecimal.ONE);
        item.setStock(15);
        
        inventoryList.add(InvItem);
        inventoryList.add(emptyItem);
    }

    @Override
    public List<Inventory> getAllInventory() throws VendingMachinePersistenceException {
        return inventoryList;
    }

    @Override
    public Inventory getItem(int i) throws VendingMachinePersistenceException, VendingMachineOutOfStockException, VendingMachineInsufficientFundsException {
        if(i == 1) {
            return InvItem;
        } else if(i == 2) {
            return emptyItem;
        } else if (i == 3) {
            return item;
        } else {
            return null;
        }
    }

    @Override
    public void updateStock(Inventory product) throws VendingMachinePersistenceException {
        product.setStock(product.getStock() - 1);
    }
    
}
