/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.service;

import com.sg.flooring.service.DataValidationException;
import com.sg.flooring.service.AreaException;
import com.sg.flooring.service.FlooringService;
import com.sg.flooring.dao.StubOrderDao;
import com.sg.flooring.dao.StubProductDao;
import com.sg.flooring.dao.StubTaxDao;
import com.sg.flooring.dto.Order;
import com.sg.flooring.dto.Product;
import com.sg.flooring.dto.Tax;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import org.junit.Test;
import static org.junit.Assert.*;
import com.sg.flooring.dao.FlooringOrderDao;
import com.sg.flooring.dao.FlooringProductDao;
import com.sg.flooring.dao.FlooringTaxDao;

/**
 *
 * @author blair
 */
public class ServiceTest {
    
    private FlooringService service;
    
    public ServiceTest() {
    
        FlooringOrderDao orderDao = new StubOrderDao();
        FlooringProductDao productDao = new StubProductDao();
        FlooringTaxDao taxDao = new StubTaxDao();
        
        service = new FlooringService(orderDao, productDao, taxDao);
    
    }
    
    @Test
    public void testAddOrder() throws Exception {
        Product product = new Product(1);
        Tax tax = new Tax("NY");
        tax.setTaxRate(BigDecimal.TEN);
        product.setName("test");
        product.setCostPerSquareFoot(BigDecimal.TEN);
        product.setLaborCostPerSquareFoot(BigDecimal.TEN);
        Order order = new Order(product, tax);
        order.setArea(BigDecimal.ONE);
        order.setClientName("testAdd");
        order.setOrderDate(LocalDate.parse("2018-05-16"));
        service.addOrder(order);    
    }

    /**
     * Test of getOrdersByDate method, of class FlooringService.
     */
    @Test
    public void testGetOrdersByDate() throws Exception {
        LocalDate date = LocalDate.of(2018, Month.JULY, 15);
        assertTrue(service.getOrdersByDate(date).size() > 0);
    }

    /**
     * Test of editOrder method, of class FlooringService.
     */
    @Test
    public void testEditOrder() throws Exception {
        Order order = service.getOrder(1, LocalDate.MAX);
        order = service.editOrder(order);
        assertNotNull(order);
        order = service.getOrder(40, LocalDate.MAX);
        order = service.editOrder(order);
        assertNull(order);
    }

    /**
     * Test of removeOrder method, of class FlooringService.
     */
    @Test
    public void testRemoveOrder() throws Exception {
        Order order = service.getOrder(1, LocalDate.MAX);
        order = service.removeOrder(order);
        assertNotNull(order);
        order = service.getOrder(40, LocalDate.MAX);
        order = service.removeOrder(order);
        assertNull(order);
    }


    /**
     * Test of getOrder method, of class FlooringService.
     */
    @Test
    public void testGetOrder() throws Exception {
        Order order;
        order = service.getOrder(1, LocalDate.MAX);
        assertNotNull(order);
        order = service.getOrder(40, LocalDate.MAX);
        assertNull(order);
    }
    
    @Test
    public void testNegativeAreaException() throws Exception {
        
        Order negativeArea = service.getOrder(1,LocalDate.of(2018, Month.JULY, 15));
        try {
            service.addOrder(negativeArea);
            fail("Nice one. You suck");
        } catch (AreaException e) {
            return;
        }
    }
    
    public void testDataValidationException() throws Exception {
        Order invalid = service.getOrder(2,LocalDate.of(2018, Month.JULY, 15));
        try {
            service.addOrder(invalid);
            fail("sux to suck");
        } catch(DataValidationException e) {
            return;
        }
    }
    
}
