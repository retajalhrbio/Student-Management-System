package com.mycompany.studentmanagementsystem;

// Student model class
public class Student {

    // Student ID
    private String id;

    // Student name
    private String name;

    // Student email
    private String email;

    // Student major
    private String major;

    // Student grade
    private int grade;

    // Constructor without grade
    public Student(String id, String name, String email, String major) {

        // Assign ID
        this.id = id;

        // Assign name
        this.name = name;

        // Assign email
        this.email = email;

        // Assign major
        this.major = major;

        // Default grade
        this.grade = 0;
    }

    // Constructor with grade
    public Student(String id, String name, String email, String major, int grade) {

        // Assign ID
        this.id = id;

        // Assign name
        this.name = name;

        // Assign email
        this.email = email;

        // Assign major
        this.major = major;

        // Assign grade
        this.grade = grade;
    }

    // Get ID
    public String getId() {
        return id;
    }

    // Set ID
    public void setId(String id) {
        this.id = id;
    }

    // Get name
    public String getName() {
        return name;
    }

    // Set name
    public void setName(String name) {
        this.name = name;
    }

    // Get email
    public String getEmail() {
        return email;
    }

    // Set email
    public void setEmail(String email) {
        this.email = email;
    }

    // Get major
    public String getMajor() {
        return major;
    }

    // Set major
    public void setMajor(String major) {
        this.major = major;
    }

    // Get grade
    public int getGrade() {
        return grade;
    }

    // Set grade
    public void setGrade(int grade) {
        this.grade = grade;
    }

    // Convert object to file format
    @Override
    public String toString() {

        // Return CSV format
        return id + "," + name + "," + email + "," + major + "," + grade;
    }
}