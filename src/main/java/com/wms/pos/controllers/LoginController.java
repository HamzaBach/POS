package com.wms.pos.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController {

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtPassword;

    @FXML
    private CheckBox chkbxSaveCredentials;

    @FXML
    private Button btnLogin;

    @FXML
    private Alert alrtError;

    @FXML
    private Alert alrtInfo;

    @FXML
    private Label lbl1;

    @FXML
    private void initialize() {
        // Initialization logic if needed
    }

    @FXML
    private void login(MouseEvent event) {
        String userName = txtUserName.getText();
        String tfsUserId = txtPassword.getText();
        boolean saveCredentials = chkbxSaveCredentials.isSelected();

        // Example validation
        if (userName.isEmpty() || tfsUserId.isEmpty()) {
            alrtError.setContentText("Username and TFS User Id cannot be empty.");
            alrtError.showAndWait();
        } else {
            // Perform login logic here
            // Example: Simulate successful login
            if (saveCredentials) {
                alrtInfo.setContentText("Credentials saved for user: " + userName);
                alrtInfo.showAndWait();
            } else {
                alrtInfo.setContentText("Login successful for user: " + userName);
                alrtInfo.showAndWait();
            }
        }
    }
}
