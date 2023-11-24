/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.firstdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Drew
 */
public class DatabaseConnection {

    private static final String DATABASE_URL = "jdbc:sqlite://Users/Drew/Desktop/SQLite\\ 3\\testDatabase.db";
    private Connection connection;

    public DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL);
            System.out.println("Connected to SQL database.");
        } catch (SQLException e) {
            System.err.println("Failed to connect to SQLite database." + e.getMessage());
        }
    }

    //used to connect to sql database
    public Connection getConnection() {
        return connection;
    }

    //uses SQL to add an employee to database
    public void insertEmployee(String firstName, String lastName, int employeeID) {
        try {
            String sql = "INSERT INTO Employees (first_name, last_name, employee_id) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, firstName);
                statement.setString(2, lastName);
                statement.setInt(3, employeeID);
                statement.executeUpdate();
                System.out.println("Employee was succesfully added.");
            }

        } catch (SQLException e) {
            System.out.println("An error has occured: " + e.getMessage());
        }
    }

    //uses SQL to delete employee from database
    public void deleteEmployee(int employeeID) {
        try {
            String sql = "DELETE FROM Employees WHERE employee_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, employeeID);
                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Employee was sucessfully deleted.");
                } else {
                    System.out.println("Employee with ID " + employeeID + " was not found.");
                }
            }
        } catch (SQLException e) {
            System.out.println("An error has occured: " + e.getMessage());
        }
    }

    //used to retrieve information about employee
    public void viewEmployee(int employeeID) {
        try {
            String sql = "SELECT first_name , last_name FROM Employees WHERE employee_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, employeeID);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        //Employee found, retrieve details
                        String firstName = resultSet.getString("first_name");
                        String lastName = resultSet.getString("last_name");
                        System.out.println("Employee number: " + employeeID + "'s current information:");
                        System.out.println("First Name: " + firstName);
                        System.out.println("Last Name: " + lastName);
                    } else {
                        System.out.println("Employee with ID number " + employeeID + " not found.");
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("An error has occured: " + e.getMessage());
        }
    }

    //used to disconnect from database
    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Connection to SQLite database closed");
        } catch (SQLException e) {
            System.err.println("Failed to close SQLite database connection: " + e.getMessage());
        }
    }

}
