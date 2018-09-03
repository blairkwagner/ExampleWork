/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Inventory;
import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author blair
 */
public class VendingMachineDaoFileImplTest {
    
    VendingMachineDao dao = new VendingMachineDaoFileImpl();   
   
    @Test
    public void testGetAllInventory() throws Exception {
        assertTrue(dao.getAllInventory().size() > 0);
    }

    /**
     * Test of getItem method, of class VendingMachineDaoFileImpl.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetItem() throws Exception {
        
        Inventory testItem = new Inventory();
        BigDecimal temp = new BigDecimal("1.25");
        testItem.setName("Snickers");
        testItem.setCost(temp);
        testItem.setStock(dao.getItem(1).getStock());
        assertEquals(testItem, dao.getItem(1));
    }
    
}
