/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import com.sg.flooring.dto.Order;
import com.sg.flooring.dto.Product;
import com.sg.flooring.dto.Tax;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author blair
 */
public class StubOrderDao implements FlooringOrderDao {

    private Order testOrder;
    private Order testOrder2;
    private Product testProduct;
    private Tax testTax;
    private BigDecimal cost = new BigDecimal("5");
    private BigDecimal negativeArea = new BigDecimal("-1");
    private LocalDate testDate = LocalDate.of(2018, Month.JULY, 15);
    private List<Order> testOrderList = new ArrayList<>();

    public StubOrderDao() {
        testProduct = new Product(1);
        testProduct.setName("Tile");
        testProduct.setCostPerSquareFoot(cost);
        testProduct.setLaborCostPerSquareFoot(cost);
        testTax = new Tax("MN");
        testTax.setTaxRate(cost);
        testOrder = new Order(testProduct, testTax);
        testOrder.setArea(negativeArea);
        testOrder.setClientName("Test Client");
        testOrder.setOrderDate(testDate);
        testOrder.setOrderNumber(1);
        testOrder2 = new Order(testProduct, testTax);
        testOrder2.setOrderNumber(2);
        testOrder2.setArea(cost);
        testOrder2.setOrderDate(testDate);
        testOrderList.add(testOrder);
        testOrderList.add(testOrder2);
    }

    @Override
    public Order addOrder(Order order) throws PersistenceException {
        testOrderList.add(order);
        return order;
    }

    @Override
    public List<Order> getOrdersByDate(LocalDate date) throws PersistenceException {
        if ("2018-07-15".equals(date.toString())) {
            return testOrderList;
        } else {
            return null;
        }
    }

    @Override
    public Order editOrder(Order order) throws PersistenceException {
        testOrderList.add(order);
        return order;
    }

    @Override
    public Order removeOrder(Order order) throws PersistenceException {
        testOrderList.remove(order);
        return order;
    }

    @Override
    public Order getOrder(int ordNum, LocalDate date) throws PersistenceException {
        if(ordNum == 1) {
            return testOrder;
        } else if (ordNum == 2) {
            return testOrder2;
        } else {
            return null;
        }
    }

}
