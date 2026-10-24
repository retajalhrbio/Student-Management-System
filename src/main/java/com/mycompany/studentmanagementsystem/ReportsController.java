package com.mycompany.studentmanagementsystem;

// FXML support
import javafx.fxml.FXML;

// UI label
import javafx.scene.control.Label;

// File reading
import java.io.BufferedReader;
import java.io.FileReader;

// Reports controller
public class ReportsController {

    // Total students label
    @FXML
    private Label totalStudentsLabel;

    // Average label
    @FXML
    private Label averageGradeLabel;

    // Generate report method
    @FXML
    private void generateReport() {

        try {

            // Read grades file
            BufferedReader reader =
                    new BufferedReader(new FileReader("grades.txt"));

            String line;

            // Total students
            int totalStudents = 0;

            // Sum of grades
            double totalGrades = 0;

            // Read each line
            while ((line = reader.readLine()) != null) {

                // Split data
                String[] data = line.split(",");

                // Get grade
                int grade =
                        Integer.parseInt(data[1]);

                // Add grade
                totalGrades += grade;

                // Count student
                totalStudents++;
            }

            // Close file
            reader.close();

            // Calculate average safely
            double average =
                    (totalStudents > 0)
                            ? totalGrades / totalStudents
                            : 0;

            // Show total students
            totalStudentsLabel.setText(
                    "Total Students: " + totalStudents);

            // Show average
            averageGradeLabel.setText(
                    "Average Grade: " + average);

        } catch (Exception e) {

            // Print error
            e.printStackTrace();
        }
    }
}