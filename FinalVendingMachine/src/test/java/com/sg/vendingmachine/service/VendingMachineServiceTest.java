/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.service.VendingMachineService;
import com.sg.vendingmachine.service.VendingMachineInsufficientFundsException;
import com.sg.vendingmachine.service.VendingMachineOutOfStockException;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoStubImpl;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Inventory;
import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author blair
 */
public class VendingMachineServiceTest {
    
    private VendingMachineService service;
    
    public VendingMachineServiceTest() {
        VendingMachineDao dao = new VendingMachineDaoStubImpl();
        service = new VendingMachineService(dao);
    }
    
    @Test
    public void testGetAllInventory() throws Exception {
        assertEquals(2, service.getAllInventory().size());
    }

    /**
     * Test of getItem method, of class VendingMachineService.
     */
    @Test
    public void testGetItem() throws Exception {
        service.setCurrentCash(BigDecimal.TEN.add(BigDecimal.TEN));
        Inventory item = service.getItem(1);
        assertNotNull(item);
        assertEquals(service.returnChange(item), BigDecimal.TEN);
    }
    

    /**
     * Test of updateStock method, of class VendingMachineService.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateStock() throws Exception {
        service.setCurrentCash(BigDecimal.TEN);
        Inventory item = service.getItem(3);
        service.updateStock(item);
        assertEquals(14, item.getStock());
    }

    /**
     * Test of getCurrentCash method, of class VendingMachineService.
     */
    @Test
    public void testGetCurrentCash() {
        service.setCurrentCash(BigDecimal.TEN);
        assertTrue(service.getCurrentCash().compareTo(BigDecimal.TEN) == 0);
    }

    /**
     * Test of setCurrentCash method, of class VendingMachineService.
     */
    @Test
    public void testSetCurrentCash() {
        service.setCurrentCash(BigDecimal.TEN);
        assertTrue(service.getCurrentCash().compareTo(BigDecimal.TEN) == 0);
    }
    
    @Test
    public void testInsufficientFunds() throws VendingMachinePersistenceException, VendingMachineOutOfStockException {
        Inventory item;
        try {
            item = service.getItem(1);
            fail("You suck");
        } catch (VendingMachineInsufficientFundsException e) {
            return;
        }
    }
    
    public void testOutOfStock() throws VendingMachinePersistenceException, VendingMachineInsufficientFundsException {
        Inventory item;
        service.setCurrentCash(BigDecimal.TEN);
        try {
            item = service.getItem(2);
            fail("Still Suck");
        } catch (VendingMachineOutOfStockException e) {
            return;
        }
    }

}
