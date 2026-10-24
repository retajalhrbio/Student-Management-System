/*

Ritaj Ayman 446000464
Nada abdulaziz 44611781
Revan Qaseem 446017117
Hind Rihan 446000486
Lama Alshareef 446000996

*/

package com.mycompany.studentmanagementsystem;

// JavaFX Application base class
import javafx.application.Application;
// Loads FXML files
import javafx.fxml.FXMLLoader;
// Scene container
import javafx.scene.Scene;
// Main window
import javafx.stage.Stage;

public class MainApp extends Application {

    // Entry point for JavaFX application
    @Override
    public void start(Stage stage) throws Exception {

        // Load Login.fxml file
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("/views/Login.fxml"));

        // Create scene from FXML
        Scene scene = new Scene(loader.load());

        // Set scene on stage
        stage.setScene(scene);

        // Set window title
        stage.setTitle("Student Management System");

        stage.setResizable(false);
        stage.setWidth(600);
        stage.setHeight(400);
        
        // Show window
        stage.show();
    }

    // Main method to launch application
    public static void main(String[] args) {

        // Start JavaFX application
        launch(args);
    }
}

        