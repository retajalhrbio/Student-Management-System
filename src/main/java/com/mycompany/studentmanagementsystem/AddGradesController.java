package com.mycompany.studentmanagementsystem;

// FXML support
import javafx.fxml.FXML;
// FXMLLoader
import javafx.fxml.FXMLLoader;
// Scene
import javafx.scene.Scene;
// Alerts
import javafx.scene.control.Alert;
// Button
import javafx.scene.control.Button;
// Text fields
import javafx.scene.control.TextField;
// Stage
import javafx.stage.Stage;

// File writing
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

// Controller for Add Grades screen
public class AddGradesController {

    // Student ID field
    @FXML
    private TextField studentIdField;

    // Grade field
    @FXML
    private TextField gradeField;

    // Back button
    @FXML
    private Button backButton;

    // Save grade method
    @FXML
    private void saveGrade() {

        // Get student ID
        String id = studentIdField.getText();

        // Get grade text
        String gradeText = gradeField.getText();

        // Check empty fields
        if (id.isEmpty() || gradeText.isEmpty()) {

            // Error message
            showAlert("Error", "All fields required");

            return;
        }

        try {

            // Convert grade to integer
            int grade = Integer.parseInt(gradeText);

            // Check range
            if (grade < 0 || grade > 100) {

                // Error message
                showAlert("Error", "Grade must be 0-100");

                return;
            }

            // Open file
            BufferedWriter writer =
                    new BufferedWriter(new FileWriter("grades.txt", true));

            // Write data
            writer.write(id + "," + grade);

            // New line
            writer.newLine();

            // Close file
            writer.close();

            // Success message
            showAlert("Success", "Grade saved");

            // Clear fields
            studentIdField.clear();
            gradeField.clear();

        } catch (NumberFormatException e) {

            // Invalid number
            showAlert("Error", "Enter valid number");

        } catch (IOException e) {

            // File error
            showAlert("Error", "File error");
        }
    }

    // Go back
    @FXML
    private void goBack() {

        try {

            // Load dashboard
            FXMLLoader loader =
                    new FXMLLoader(getClass().getResource("/views/Dashboard.fxml"));

            // Scene
            Scene scene = new Scene(loader.load());

            // Stage
            Stage stage =
                    (Stage) backButton.getScene().getWindow();

            // Set scene
            stage.setScene(scene);

            // Show stage
            stage.show();

        } catch (Exception e) {

            // Error
            e.printStackTrace();
        }
    }

    // Show alert
    private void showAlert(String title, String message) {

        // Create alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        // Title
        alert.setTitle(title);

        // No header
        alert.setHeaderText(null);

        // Message
        alert.setContentText(message);

        // Show
        alert.showAndWait();
    }
}