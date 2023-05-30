package com.mycompany.firstdatabase;

/**
 *
 * @author Drew
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class FirstDatabase {
    private Scanner scanner;
    private DatabaseConnection databaseConnection;
    
    public FirstDatabase(Scanner scanner, DatabaseConnection databaseConnection) {
        this.scanner = scanner;
        this.databaseConnection = databaseConnection;
    }
    
    public void add(String firstName, String lastName, int employeeID) {
        databaseConnection.insertEmployee(firstName, lastName, employeeID);
        
    } 
    
    public void delete(int employeeID) {
        databaseConnection.deleteEmployee(employeeID);
    }
    
    public void exit() {
        databaseConnection.closeConnection();
    }
    
    
}
