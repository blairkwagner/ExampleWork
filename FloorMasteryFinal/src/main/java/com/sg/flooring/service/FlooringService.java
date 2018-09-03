/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.service;

import com.sg.flooring.dao.PersistenceException;
import com.sg.flooring.dto.Order;
import com.sg.flooring.dto.Product;
import com.sg.flooring.dto.Tax;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import com.sg.flooring.dao.FlooringOrderDao;
import com.sg.flooring.dao.FlooringProductDao;
import com.sg.flooring.dao.FlooringTaxDao;

/**
 *
 * @author blair
 */
public class FlooringService {
    
    FlooringOrderDao orderDao;
    FlooringProductDao productDao;
    FlooringTaxDao taxDao;
    
    public FlooringService(FlooringOrderDao orderDao, FlooringProductDao productDao, FlooringTaxDao taxDao) {
        this.orderDao = orderDao;
        this.productDao = productDao;
        this.taxDao = taxDao;
    }
    
    public Order addOrder(Order order) throws PersistenceException, DataValidationException, AreaException {
        validateOrderData(order);
        return orderDao.addOrder(order);
    }
    
    public List<Order> getOrdersByDate(LocalDate date) throws PersistenceException {
        return orderDao.getOrdersByDate(date);
    }
    
    public Order editOrder(Order order) throws PersistenceException {
        return orderDao.editOrder(order);
    }
    
    public Order removeOrder(Order order) throws PersistenceException {
        return orderDao.removeOrder(order);
    }
    
    public List<Product> getAllProducts() throws PersistenceException {
        return productDao.getAllProducts();
    }
    
    public List<Tax> getAllTax() throws PersistenceException {
        return taxDao.getAllTaxInfo();
    }
    
    public Order getOrder(int ordNum, LocalDate date) throws PersistenceException {
        return orderDao.getOrder(ordNum, date);
    }
    
    private void validateOrderData(Order order) throws DataValidationException, AreaException {
        
         if (order.getClientName() == null
            || order.getClientName().trim().length() == 0
            || order.getTax().getState() == null
            || order.getTax().getState().trim().length() == 0
            || order.getOrderDate() == null
            || order.getOrderDate().toString().trim().length() == 0
            || order.getArea() == null
            || order.getArea().toString().trim().length() == 0
            || order.getProduct() == null
            || order.getProduct().toString().trim().length() == 0) {
             
            throw new DataValidationException("ERROR: All fields [First Name, Last Name, Cohort] are required.");
         } else if (order.getArea().compareTo(BigDecimal.ZERO) < 1) {
             throw new AreaException("ERROR: Area must be larger than zero.");
         }
    }
}
