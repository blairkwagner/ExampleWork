/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import com.sg.flooring.dto.Order;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author blair
 */
public interface FlooringOrderDao {
    Order addOrder(Order order) throws PersistenceException;
    
    List<Order> getOrdersByDate(LocalDate date) throws PersistenceException;
    
    Order editOrder(Order order) throws PersistenceException;
    
    Order removeOrder(Order order) throws PersistenceException;

    Order getOrder(int ordNum, LocalDate date) throws PersistenceException;            
    
}
