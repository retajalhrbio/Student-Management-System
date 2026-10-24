package com.mycompany.studentmanagementsystem;

// FXML support
import javafx.fxml.FXML;
// Loads scenes
import javafx.fxml.FXMLLoader;
// Scene container
import javafx.scene.Scene;
// Alerts
import javafx.scene.control.Alert;
// Button control
import javafx.scene.control.Button;
// Text fields
import javafx.scene.control.TextField;
// Window stage
import javafx.stage.Stage;

// File writing
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

// Controller for Add Student screen
public class AddStudentController {

    // Student ID field
    @FXML
    private TextField idField;

    // Student name field
    @FXML
    private TextField nameField;

    // Student email field
    @FXML
    private TextField emailField;

    // Student major field
    @FXML
    private TextField majorField;

    // Back button
    @FXML
    private Button backButton;

    // Add student method
    @FXML
    private void handleAddStudent() {

        // Get ID
        String id = idField.getText();

        // Get name
        String name = nameField.getText();

        // Get email
        String email = emailField.getText();

        // Get major
        String major = majorField.getText();

        // Check empty fields
        if (id.isEmpty() || name.isEmpty() || email.isEmpty() || major.isEmpty()) {

            // Show error
            showAlert("Input Error", "All fields are required");

            return;
        }

        try {

            // Create student object
            Student student = new Student(id, name, email, major);

            // Open file in append mode
            BufferedWriter writer =
                    new BufferedWriter(new FileWriter("students.txt", true));

            // Write student data
            writer.write(student.toString());

            // New line
            writer.newLine();

            // Close writer
            writer.close();

            // Success message
            showAlert("Success", "Student saved successfully");

            // Clear fields
            clearFields();

        } catch (IOException e) {

            // Show error
            showAlert("Error", "File error");
        }
    }

    // Go back to dashboard
    @FXML
    private void goBack() {

        try {

            // Load dashboard
            FXMLLoader loader =
                    new FXMLLoader(getClass().getResource("/views/Dashboard.fxml"));

            // Create scene
            Scene scene = new Scene(loader.load());

            // Get stage
            Stage stage =
                    (Stage) backButton.getScene().getWindow();

            // Set scene
            stage.setScene(scene);

            // Show stage
            stage.show();

        } catch (Exception e) {

            // Print error
            e.printStackTrace();
        }
    }

    // Clear input fields
    private void clearFields() {

        // Clear ID
        idField.clear();

        // Clear name
        nameField.clear();

        // Clear email
        emailField.clear();

        // Clear major
        majorField.clear();
    }

    // Show alert method
    private void showAlert(String title, String message) {

        // Create alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        // Set title
        alert.setTitle(title);

        // No header
        alert.setHeaderText(null);

        // Set message
        alert.setContentText(message);

        // Show alert
        alert.showAndWait();
    }
}