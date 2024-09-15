package com.wms.pos.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class POSController {

    @FXML
    private TextField itemNameField;

    @FXML
    private TextField itemPriceField;

    @FXML
    private ListView<String> itemListView;

    @FXML
    private Label totalLabel;

    private double totalAmount = 0.0;

    @FXML
    private void handleAddItem() {
        String name = itemNameField.getText();
        String priceText = itemPriceField.getText();

        try {
            double price = Double.parseDouble(priceText);
            if (name.isEmpty() || price <= 0) {
                showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter a valid item name and price.");
                return;
            }

            // Add item to the list
            String itemText = String.format("%s: $%.2f", name, price);
            itemListView.getItems().add(itemText);

            // Update total amount
            totalAmount += price;
            totalLabel.setText(String.format("Total: $%.2f", totalAmount));

            // Clear input fields
            itemNameField.clear();
            itemPriceField.clear();
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter a valid price.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
