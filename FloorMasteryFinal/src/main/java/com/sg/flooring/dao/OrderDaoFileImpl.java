/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import com.sg.flooring.dto.Order;
import com.sg.flooring.dto.Product;
import com.sg.flooring.dto.Tax;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author blair
 */
public class OrderDaoFileImpl implements FlooringOrderDao {

    public static final String DELIMITER = "::";
    private ArrayList<Order> orders = new ArrayList<>();

    @Override
    public Order addOrder(Order order) throws PersistenceException {
        Order newOrder = order;

        loadOrders(order.getOrderDate());
        int max = 1;
        for (Order currentOrder : orders) {
            if (currentOrder.getOrderNumber() >= max) {
                max = currentOrder.getOrderNumber() + 1;
            }
        }
        order.setOrderNumber(max);
        orders.add(order);
        writeOrders(order.getOrderDate());
        return newOrder;
    }

    @Override
    public List<Order> getOrdersByDate(LocalDate date) throws PersistenceException {
        loadOrders(date);
        return orders;
    }

    @Override
    public Order editOrder(Order order) throws PersistenceException {
        Order editOrder = order;
        writeOrders(order.getOrderDate());
        return editOrder;
    }

    @Override
    public Order removeOrder(Order order) throws PersistenceException {
        Order returnOrder = null;
        loadOrders(order.getOrderDate());
        for(Order q : orders) {
            if(q.getOrderNumber() == order.getOrderNumber()) {
                orders.remove(q);
                returnOrder = q;
                break;
            }
        }
        writeOrders(order.getOrderDate());
        return returnOrder;
    }

    public void writeOrders(LocalDate date) throws PersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter("orders_" + date + ".txt"));
        } catch (IOException e) {
            throw new PersistenceException("Unable to save order data.");
        }
        List<Order> orderList = orders;
        for (Order currentOrder : orderList) {
            out.println(currentOrder.getOrderNumber() + DELIMITER + currentOrder.getClientName() + DELIMITER + currentOrder.getTax().getState() + DELIMITER + currentOrder.getTax().getTaxRate() + DELIMITER + currentOrder.getProduct().getName() + DELIMITER + currentOrder.getArea()
                    + DELIMITER + currentOrder.getProduct().getCostPerSquareFoot() + DELIMITER
                    + currentOrder.getProduct().getLaborCostPerSquareFoot() + DELIMITER + currentOrder.getMaterialCost() + DELIMITER + currentOrder.getLaborCost()
                    + DELIMITER + currentOrder.getTaxTotal() + DELIMITER + currentOrder.getTotal() + DELIMITER + currentOrder.getOrderDate());
            out.flush();
        }
        out.close();
    }

    private void loadOrders(LocalDate date) throws PersistenceException {
        Scanner scanner;
        File hey = new File("orders_" + date + ".txt");
        
        if(!hey.exists()) {
            try {
                hey.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(OrderDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        ArrayList<Order> temp = new ArrayList<>();

        try {
            scanner = new Scanner(new BufferedReader(new FileReader("orders_" + date + ".txt")));
        } catch (FileNotFoundException e) {
            throw new PersistenceException("Unable to load data into memory.", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Product currentProduct = new Product(1);
            Tax currentTax = new Tax("MN");
            Order currentOrder = new Order(currentProduct, currentTax);
            currentOrder.setOrderNumber(Integer.parseInt(currentTokens[0]));
            currentOrder.setClientName(currentTokens[1]);
            currentOrder.getTax().setState(currentTokens[2]);
            BigDecimal taxRate = new BigDecimal(currentTokens[3]);
            currentOrder.getTax().setTaxRate(taxRate);
            currentOrder.getProduct().setName(currentTokens[4]);
            BigDecimal area = new BigDecimal(currentTokens[5]);
            currentOrder.setArea(area);
            BigDecimal costPerSquareFoot = new BigDecimal(currentTokens[6]);
            currentOrder.getProduct().setCostPerSquareFoot(costPerSquareFoot);
            BigDecimal laborCostPerSquareFoot = new BigDecimal(currentTokens[7]);
            currentOrder.getProduct().setLaborCostPerSquareFoot(laborCostPerSquareFoot);
            BigDecimal materialCost = new BigDecimal(currentTokens[8]);
            currentOrder.setMaterialCost(materialCost);
            BigDecimal laborCost = new BigDecimal(currentTokens[9]);
            currentOrder.setLaborCost(laborCost);
            BigDecimal taxTotal = new BigDecimal(currentTokens[10]);
            currentOrder.setTaxTotal(taxTotal);
            BigDecimal total = new BigDecimal(currentTokens[11]);
            currentOrder.setTotal(total);
            currentOrder.setOrderDate(LocalDate.parse(currentTokens[12]));
            temp.add(currentOrder);
        }
        scanner.close();

        if (orders != temp) {
            orders = temp;
        }
    }

    @Override
    public Order getOrder(int ordNum, LocalDate date) throws PersistenceException {
        loadOrders(date);
        Order returnOrder = null;
        for(Order currentOrder : orders) {
            if(currentOrder.getOrderNumber() == ordNum) {
                returnOrder = currentOrder;
            }
        }
        return returnOrder;
    }
}
