package com.mycompany.studentmanagementsystem;

// JavaFX collections
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

// FXML support
import javafx.fxml.FXML;

// FXMLLoader
import javafx.fxml.FXMLLoader;

// Scene
import javafx.scene.Scene;

// Stage
import javafx.stage.Stage;

// UI controls
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

// Table binding
import javafx.scene.control.cell.PropertyValueFactory;

// File reading
import java.io.BufferedReader;
import java.io.FileReader;

// HashMap for grades
import java.util.HashMap;

// Controller for View Students screen
public class ViewStudentsController {

    // TableView to show students
    @FXML
    private TableView<Student> tableView;

    // ID column
    @FXML
    private TableColumn<Student, String> idColumn;

    // Name column
    @FXML
    private TableColumn<Student, String> nameColumn;

    // Email column
    @FXML
    private TableColumn<Student, String> emailColumn;

    // Major column
    @FXML
    private TableColumn<Student, String> majorColumn;

    // Grade column
    @FXML
    private TableColumn<Student, Integer> gradeColumn;

    // Label for average
    @FXML
    private Label averageLabel;

    // List of students
    private ObservableList<Student> studentList =
            FXCollections.observableArrayList();

    // Initialize table
    @FXML
    public void initialize() {

        // Bind ID column
        idColumn.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        // Bind name column
        nameColumn.setCellValueFactory(
                new PropertyValueFactory<>("name"));

        // Bind email column
        emailColumn.setCellValueFactory(
                new PropertyValueFactory<>("email"));

        // Bind major column
        majorColumn.setCellValueFactory(
                new PropertyValueFactory<>("major"));

        // Bind grade column
        gradeColumn.setCellValueFactory(
                new PropertyValueFactory<>("grade"));
    }

    // Load students method
    @FXML
    private void loadStudents() {

        // Clear old data
        studentList.clear();

        try {

            // Map for grades
            HashMap<String, Integer> gradesMap =
                    new HashMap<>();

            // Read grades file
            BufferedReader gradeReader =
                    new BufferedReader(new FileReader("grades.txt"));

            String line;

            // Read each line
            while ((line = gradeReader.readLine()) != null) {

                // Split data
                String[] data = line.split(",");

                // Store ID and grade
                gradesMap.put(
                        data[0],
                        Integer.parseInt(data[1]));
            }

            // Close file
            gradeReader.close();

            // Read students file
            BufferedReader studentReader =
                    new BufferedReader(new FileReader("students.txt"));

            // Total for average
            double total = 0;

            // Count students
            int count = 0;

            // Read each student
            while ((line = studentReader.readLine()) != null) {

                // Split student data
                String[] data = line.split(",");

                // Get fields
                String id = data[0];
                String name = data[1];
                String email = data[2];
                String major = data[3];

                // Get grade or default 0
                int grade =
                        gradesMap.getOrDefault(id, 0);

                // Create student object
                Student student =
                        new Student(id, name, email, major, grade);

                // Add to list
                studentList.add(student);

                // Add to total
                total += grade;

                // Increase count
                count++;
            }

            // Close file
            studentReader.close();

            // Set table data
            tableView.setItems(studentList);

            // Calculate average
            if (count > 0) {

                // Compute average
                double average = total / count;

                // Show average
                averageLabel.setText(
                        "Average Grade: " + average);
            }

        } catch (Exception e) {

            // Print error
            e.printStackTrace();
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
                    (Stage) tableView.getScene().getWindow();

            // Set scene
            stage.setScene(scene);

            // Show stage
            stage.show();

        } catch (Exception e) {

            // Print error
            e.printStackTrace();
        }
    }
}