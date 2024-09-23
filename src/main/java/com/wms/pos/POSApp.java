package com.wms.pos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class POSApp extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) {
        try {
            // Load login.fxml initially
            primaryStage = stage;
            FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/com/wms/pos/Login.fxml"));
            Parent root = loginLoader.load();
            Scene scene = new Scene(root);

            // Set minimum width and height for the stage (window)
            primaryStage.setMinWidth(350);  // Minimum width
            primaryStage.setMinHeight(250); // Minimum height

            // Set the scene and show the stage
            primaryStage.setScene(scene);
            primaryStage.setTitle("Point of Sale Login");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to switch scenes
    public static void switchToPosScreen() throws Exception {
        // Load pos.xml for the main POS screen
        FXMLLoader loader = new FXMLLoader(POSApp.class.getResource("/com/wms/pos/POS.fxml"));
        Parent posRoot = loader.load();
        //POSController controller = loader.getController(); // Get controller instance


        //Parent posRoot = FXMLLoader.load(Objects.requireNonNull(POSApp.class.getResource("POS.fxml")));
        Scene posScene = new Scene(posRoot);

        // Set the new scene (POS screen)
        primaryStage.setTitle("POS System");
        primaryStage.setScene(posScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
