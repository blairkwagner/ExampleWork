/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Inventory;
import com.sg.vendingmachine.ui.VendingMachineView;
import com.sg.vendingmachine.service.VendingMachineInsufficientFundsException;
import com.sg.vendingmachine.service.VendingMachineOutOfStockException;
import com.sg.vendingmachine.service.VendingMachineService;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author blair
 */
public class VendingMachineController {

    VendingMachineView view;
    private VendingMachineService service;

    public VendingMachineController(VendingMachineService service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                listMenu();
                menuSelection = getFirstSelection();

                switch (menuSelection) {
                    case 1:
                        getUserCash();
                        run2();

                        break;
                    case 2:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (VendingMachinePersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitMessage();
    }

    private void listMenu() throws VendingMachinePersistenceException {
        List<Inventory> menu = service.getAllInventory();
        view.displayInventoryList(menu);
    }

    private int getFirstSelection() {
        return view.displayInitialOptions();
    }

    private BigDecimal getUserCash() {
        view.displayCash(service.getCurrentCash());
        service.setCurrentCash(service.getCurrentCash().add(view.getCash()));
        BigDecimal userCash = service.getCurrentCash();
        return userCash;
    }

    private int getSecondSelection() throws VendingMachinePersistenceException {
        List<Inventory> thisInventory = service.getAllInventory();
        return view.getSecondOption(thisInventory);
    }

    private void run2() throws VendingMachinePersistenceException {
        Inventory userChoice = null;
        boolean keepGoing2 = false;
        do {
            listMenu();
            try {
                userChoice = getItem();
                keepGoing2 = false;
            } catch (VendingMachineInsufficientFundsException e) {
                view.displayErrorMessage(e.getMessage());
                keepGoing2 = true;
            }

        } while (keepGoing2);
        BigDecimal difference = service.returnChange(userChoice);
        view.dispenseChange(difference);
        service.updateStock(userChoice);

    }

    private Inventory getItem() throws VendingMachinePersistenceException, VendingMachineInsufficientFundsException {
        Inventory selection = null;
        boolean keepGoing3 = true;
        do {
            int secondMenu = getSecondSelection();
            if (secondMenu == 0) {
                getUserCash();
            } else {
                try {
                    selection = service.getItem(secondMenu);
                    keepGoing3 = false;
                } catch (VendingMachineOutOfStockException e) {
                    view.displayErrorMessage(e.getMessage());
                }
            }
        } while (keepGoing3);
        return selection;
    }

}
