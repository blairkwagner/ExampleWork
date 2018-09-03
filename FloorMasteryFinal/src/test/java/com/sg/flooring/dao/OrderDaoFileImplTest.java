/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import com.sg.flooring.dao.OrderDaoFileImpl;
import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;
import com.sg.flooring.dao.FlooringOrderDao;

/**
 *
 * @author blair
 */
public class OrderDaoFileImplTest {
    
    FlooringOrderDao dao = new OrderDaoFileImpl();


    /**
     * Test of getOrdersByDate method, of class OrderDaoFileImpl.
     */
    @Test
    public void testGetOrdersByDate() throws Exception {
        LocalDate testDate = LocalDate.parse("2018-01-01");
        assertTrue(dao.getOrdersByDate(testDate).size() > 0);        
    }

    /**
     * Test of getOrder method, of class OrderDaoFileImpl.
     */
    @Test
    public void testGetOrder() throws Exception {
        LocalDate testDate = LocalDate.parse("2018-01-01");
        assertTrue(dao.getOrder(1, testDate) != null);
    }
    
}
