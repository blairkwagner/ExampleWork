/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.UI;

import com.sg.flooring.dto.Order;
import com.sg.flooring.dto.Product;
import com.sg.flooring.dto.Tax;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author blair
 */
public class FlooringView {

    private UserIO io;
    private final BigDecimal DIVISOR = new BigDecimal("100");

    public FlooringView(UserIO io) {
        this.io = io;
    }

    public int displayMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("*** | :) (: | :) (: | ***");
        io.print("1. Display Orders");
        io.print("2. Add an Order");
        io.print("3. Edit an Order");
        io.print("4. Remove an Order");
        io.print("5. Quit");
        return io.readInt("Choose your selection:", 1, 5);
    }

    public Order createOrder(List<Product> products, List<Tax> taxes) {

        displayProductList(products);
        int q = products.size();
        int productChoice = io.readInt("Please select the Product number needed.", 1, q);
        String name = io.readString("Please enter the name for this order");
        BigDecimal area = new BigDecimal(io.readString("Please enter the square footage for your order"));
        String userState = io.readString("Please enter the state abbervations for the state where you are ordering from.");
        LocalDate date = io.readLocalDate("Please enter the date of the project in this format -> (YYYY-MM-DD)");
        Product product = null;
        Tax tax = null;
        for (Product currentProduct : products) {
            if (currentProduct.getId() == productChoice) {
                product = currentProduct;
            }
        }

        for (Tax currentTax : taxes) {
            if (currentTax.getState() == null ? userState == null : currentTax.getState().equals(userState)) {
                tax = currentTax;
            }
        }

        Order currentOrder = new Order(product, tax);

        currentOrder.setOrderDate(date);
        currentOrder.setArea(area);
        currentOrder.setClientName(name);
        currentOrder.setMaterialCost(area.multiply(currentOrder.getProduct().getCostPerSquareFoot()));
        currentOrder.setLaborCost(area.multiply(currentOrder.getProduct().getLaborCostPerSquareFoot()));
        currentOrder.setTaxTotal(currentOrder.getTax().getTaxRate().divide(DIVISOR, 2, RoundingMode.HALF_EVEN).multiply(currentOrder.getMaterialCost().add(currentOrder.getLaborCost())));
        currentOrder.setTotal(currentOrder.getLaborCost().add(currentOrder.getMaterialCost().add(currentOrder.getTaxTotal())));
        displayOrderConfirmation(currentOrder);
        String choice = io.readString("Confirm your order? (Y/N) case sensative");
        if ("Y".equals(choice)) {
            return currentOrder;
        } else {
            currentOrder = null;
            return currentOrder;
        }

    }

    public void displayProductList(List<Product> productList) {
        io.print("Available Prodcuts");
        io.print("*** | :) (: | :) (: | ***");
        for (Product currentProduct : productList) {

            io.print(currentProduct.getId() + ". " + currentProduct.getName() + ", $" + currentProduct.getLaborCostPerSquareFoot() + " per square foot of labor, $" + currentProduct.getCostPerSquareFoot() + " per square foot");
        }

    }

    public void displayExitMessage() {
        io.print("Thank you. Come again very soon.");
    }

    public void displayErrorMessage(String errMsg) {
        io.print("ERROR");
        io.print(errMsg);
    }

    public void displayUnknownCommandBanner() {
        io.print("We do not understand.. UNKOWN COMMAND");
    }

    public LocalDate getOrdersDate() {
        LocalDate date = io.readLocalDate("Please enter the date you would like to view (YYYY-MM-DD) format only!!!!!");
        return date;
    }

    public void displayOrderList(List<Order> orderList) {
        io.print("");
        for (Order currentOrder : orderList) {
            io.print("Order number: " + currentOrder.getOrderNumber() + ". Client Name: " + currentOrder.getClientName() + ". State: " + currentOrder.getTax().getState() + ". Tax Rate: " + currentOrder.getTax().getTaxRate() + ". Product: " + currentOrder.getProduct().getName() + ". Area: " + currentOrder.getArea()
                    + ". Cost per Square Foot: " + currentOrder.getProduct().getCostPerSquareFoot() + ". Labor Cost per Square Foot: "
                    + currentOrder.getProduct().getLaborCostPerSquareFoot() + ". Material Cost: " + currentOrder.getMaterialCost() + ". Labor Cost: " + currentOrder.getLaborCost()
                    + ". Tax Value: " + currentOrder.getTaxTotal() + ". Total: " + currentOrder.getTotal() + ". Project Date: " + currentOrder.getOrderDate());
        }
        io.print("");
        io.readString("Please press enter to continue");
    }

    public void displayOrderConfirmation(Order order) {
        io.print("");
        io.print("Client Name: " + order.getClientName() + ". State: " + order.getTax().getState() + ". Product: " + order.getProduct().getName() + ". Area: " + order.getArea()
                + ". Order Date: " + order.getOrderDate());
    }

    public int getOrderId(List<Order> orderList) {
        int returnInt = 0;
        boolean keepGoing = true;
        if (orderList.size() > 0) {
            do {
                int orderSelection = io.readInt("Enter the order number for your choice ");
                for (Order currentOrder : orderList) {
                    if (orderSelection == currentOrder.getOrderNumber()) {
                        returnInt = orderSelection;
                        keepGoing = false;
                    }
                }
                if (keepGoing) {
                    io.print("The order number entered is not valid per our records.");
                }
            } while (keepGoing);

        } else {
            io.print("There are no orders with the date you provided");
        }

        return returnInt;
    }

    public void displayEditOrderBanner() {
        io.print("Edit an Order");
    }

    public void displayEditSuccessBanner() {
        io.readString("Order edited, please press enter to continue");
    }

    public Order editOrder(Order order, List<Product> productList, List<Tax> taxList) {
        boolean keepGoing = true;
        if (order != null) {
            displayProductList(productList);
            int editProduct = io.readInt("The current product on this order is: " + order.getProduct().getName() + ". Select a different product or press 0 to keep the original", 0, productList.size());
            for (Product currentProduct : productList) {
                if (editProduct == currentProduct.getId()) {
                    order.setProduct(currentProduct);
                }
            }
            do {
                String state = io.readString("Current state is: " + order.getTax().getState() + ". Enter a new state or press enter to keep it");
                if ("".equals(state)) {
                    break;
                }
                for (Tax currentTax : taxList) {
                    if (currentTax.getState().equals(state)) {
                        order.getTax().setState(state);
                        keepGoing = false;
                    }
                }

                io.print("Please enter a valid state abberviation.");

            } while (keepGoing);
            String name = io.readString("Current client name is: " + order.getClientName() + ". Enter a new client name or press enter to keep it.");
            if (!"".equals(name)) {
                order.setClientName(name);
            }
            LocalDate date = io.readLocalDate("Current order date is: " + order.getOrderDate() + ".  Enter a new date or enter '0000-01-01' to keep the previous");
            if (date != LocalDate.parse("0000-01-01")) {
                order.setOrderDate(date);
            }
            BigDecimal area = io.readBigDecimal("Current area is: " + order.getArea() + ". Enter a new area or re-enter it to keep it");
            if (area != null) {
                order.setArea(area);
            }

        } else {
            io.print("Please try again with a valid order.");
        }
        return order;

    }

    public void displayRemoveOrderBanner() {
        io.print("Remove an Order");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("Order successfully removed. Please press enter to continue");
    }

}
