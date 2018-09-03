/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.controller;

import com.sg.flooring.dao.PersistenceException;
import com.sg.flooring.dto.Order;
import com.sg.flooring.dto.Product;
import com.sg.flooring.dto.Tax;
import com.sg.flooring.service.FlooringService;
import com.sg.flooring.UI.FlooringView;
import com.sg.flooring.service.AreaException;
import com.sg.flooring.service.DataValidationException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author blair
 */
public class Controller {

    FlooringView view;
    FlooringService service;

    public Controller(FlooringService service, FlooringView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection;
        try {
            while (keepGoing) {

                menuSelection = listMenu();

                switch (menuSelection) {
                    case 1:
                        getOrders();
                        break;
                    case 2:
                        addOrder();
                        break;
                    case 3:
                        editOrder();
                        break;
                    case 4:
                        removeOrder();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (PersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int listMenu() {
        return view.displayMenuAndGetSelection();
    }

    private void exitMessage() {
        view.displayExitMessage();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

 private void addOrder() throws PersistenceException {
        List<Tax> controlTaxList = service.getAllTax();
        List<Product> controlProdList = service.getAllProducts();
        boolean hasErrors = false;
        do {

            Order newOrder = view.createOrder(controlProdList, controlTaxList);
            try {
                service.addOrder(newOrder);
            } catch (DataValidationException | AreaException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);

    }

    private void getOrders() throws PersistenceException {
        LocalDate controlDate = view.getOrdersDate();
        List<Order> orderList = service.getOrdersByDate(controlDate);
        view.displayOrderList(orderList);
    }

    private void editOrder() throws PersistenceException {

        List<Tax> controlTax = service.getAllTax();
        List<Product> controlProduct = service.getAllProducts();
        view.displayEditOrderBanner();
        Order editOrder = getOrder();
        if (editOrder == null) {
            return;
        }
        service.editOrder(view.editOrder(editOrder, controlProduct, controlTax));
        view.displayEditSuccessBanner();

    }

    private Order getOrder() throws PersistenceException {
        LocalDate date = view.getOrdersDate();
        List<Order> orderList = service.getOrdersByDate(date);
        view.displayOrderList(orderList);
        int controlInt = view.getOrderId(orderList);
        Order order = service.getOrder(controlInt, date);

        return order;
    }

    private void removeOrder() throws PersistenceException {

        view.displayRemoveOrderBanner();
        Order removeOrder = getOrder();
        if (removeOrder == null) {
            return;
        }
        service.removeOrder(removeOrder);
        view.displayRemoveSuccessBanner();
    }
}
