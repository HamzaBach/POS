package com.wms.pos.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class NumericKeyboardController {
    private POSController parentController;

    // Set the parent controller reference
    public void setParentController(POSController parentController) {
        this.parentController = parentController;
    }

    // Handle number button click events
    @FXML
    public void handleNumberClick(ActionEvent event) {
        // Get the number from the clicked button
        Button clickedButton = (Button) event.getSource();
        String number = clickedButton.getText();

        // Use the parent controller to update the itemPriceField
        if (parentController != null) {
            parentController.updateItemPrice(number);
        }
    }
    // Handle backspace functionality
    @FXML
    private void handleBackspace() {
        if (parentController != null) {
            String currentPrice = parentController.getItemPrice();
            if (!currentPrice.isEmpty()) {
                parentController.setItemPrice(currentPrice.substring(0, currentPrice.length() - 1));
            }
        }
    }

    // Handle decimal point input
    @FXML
    private void handleDecimalInput() {
        if (parentController != null && !parentController.getItemPrice().contains(".")) {
            parentController.updateItemPrice(".");
        }
    }
}
