package com.mycompany.studentmanagementsystem;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import java.io.FileWriter;
import javafx.scene.control.Alert;

/*
 * DashboardController
 * Controls navigation between all system screens
 * Handles clearing stored data (students & grades)
 */
public class DashboardController {

    // Button reference from FXML (used for getting current window stage)
    @FXML
    private Button addStudentButton;

    /*
     * Opens Add Student screen
     * Loads AddStudent.fxml and switches scene
     */
    @FXML
    private void openAddStudent() {
        try {
            FXMLLoader loader =
                    new FXMLLoader(getClass().getResource("/views/AddStudent.fxml"));

            Scene scene = new Scene(loader.load());

            Stage stage =
                    (Stage) addStudentButton.getScene().getWindow();

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Opens Add Grades screen
     * Loads AddGrades.fxml and switches scene
     */
    @FXML
    private void openAddGrades() {
        try {
            FXMLLoader loader =
                    new FXMLLoader(getClass().getResource("/views/AddGrades.fxml"));

            Scene scene = new Scene(loader.load());

            Stage stage =
                    (Stage) addStudentButton.getScene().getWindow();

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Opens View Students screen
     * Displays all students and their grades
     */
    @FXML
    private void openViewStudents() {
        try {
            FXMLLoader loader =
                    new FXMLLoader(getClass().getResource("/views/ViewStudents.fxml"));

            Scene scene = new Scene(loader.load());

            Stage stage =
                    (Stage) addStudentButton.getScene().getWindow();

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Logs out user and returns to Login screen
     */
    @FXML
    private void logout() {
        try {
            FXMLLoader loader =
                    new FXMLLoader(getClass().getResource("/views/Login.fxml"));

            Scene scene = new Scene(loader.load());

            Stage stage =
                    (Stage) addStudentButton.getScene().getWindow();

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Alternative method to open Add Grades using ActionEvent
     * (Not necessary, but kept for event-driven demonstration)
     */
    @FXML
    private void openAddGrades(ActionEvent event) throws Exception {

        Parent root =
                FXMLLoader.load(getClass().getResource("/views/AddGrades.fxml"));

        Stage stage =
                (Stage) ((Node) event.getSource())
                        .getScene()
                        .getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }

    /*
     * Clears all stored data from files
     * students.txt and grades.txt are reset (emptied)
     */
    @FXML
    private void clearData() {

        try {

            // Overwrite files with empty content
            new FileWriter("students.txt", false).close();
            new FileWriter("grades.txt", false).close();

            // Success message
            Alert alert =
                    new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Reset Data");
            alert.setHeaderText(null);
            alert.setContentText("All data has been cleared successfully!");
            alert.showAndWait();

        } catch (Exception e) {

            // Error message
            Alert alert =
                    new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to clear data!");
            alert.showAndWait();

            e.printStackTrace();
        }
    }
}