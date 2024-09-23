package com.wms.pos.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;

public class POSController {

    @FXML
    public TabPane tabPane;
    @FXML
    public StackPane contentStackPane;
    @FXML
    public VBox tab1Content;
    @FXML
    private TextField itemNameField;

    @FXML
    private TextField itemPriceField;

    @FXML
    private ListView<String> itemListView;

    @FXML
    private Label totalLabel;

    private double totalAmount = 0.0;
    // Reference to NumericKeyboard controller
    private static NumericKeyboardController numericKeyboardController;

    @FXML
    public void initialize() {
        try {
            // Load NumericKeyboard.fxml and get its controller
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/wms/pos/NumericKeyboard.fxml"));
            Parent numericKeyboardRoot = loader.load();

            // Get the controller for the NumericKeyboard
            numericKeyboardController = loader.getController();

            // Set the reference of the parent controller in the child
            numericKeyboardController.setParentController(this);

            // Add the loaded NumericKeyboard to the UI
            tab1Content.getChildren().add(numericKeyboardRoot);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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



    // You can expose any method that the child needs, e.g., modifying the itemPriceField
    public void updateItemPrice(String number) {
        itemPriceField.setText(itemPriceField.getText() + number);
    }

    public String getItemPrice(){
        return itemPriceField.getText();
    }
    public void setItemPrice(String itemPrice){
        this.itemPriceField.setText(itemPrice);
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
