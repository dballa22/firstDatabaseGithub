/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.firstdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
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
    
    public Connection getConnection() {
        return connection;
    }
    
    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Connection to SQLite database closed");
        } catch (SQLException e) {
            System.err.println("Failed to close SQLite database connection: " + e.getMessage());
        }
    }
    
}
