/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.firstdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    
    //used to excecute SQL commands 
    public void insertEmployee(String firstName, String lastName, int employeeID) {
        try {
            String sql = "INSERT INTO Employees (first_name, last_name, employee_id) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setInt(3, employeeID);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
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
