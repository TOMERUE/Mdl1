package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "password";

   

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Login App");

        // Create UI components
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login");
        Label statusLabel = new Label();

        // Event handler for login button
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)) {
                // Successful login
                statusLabel.setText("Login successful! Redirecting to new page...");
                // You can add code here to open a new window or switch scenes
            } else {
                // Failed login
                statusLabel.setText("Username or password is incorrect.");
            }
        });

        // Create layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton, statusLabel);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    

    public static void main(String[] args) {
        launch();
    }

}