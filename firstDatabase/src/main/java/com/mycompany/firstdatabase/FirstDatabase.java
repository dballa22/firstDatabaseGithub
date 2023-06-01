package com.mycompany.firstdatabase;

/**
 *
 * @author Drew
 */


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
    
    public void viewEmployee(int employeeID) {
        databaseConnection.viewEmployee(employeeID);
    }
    
    public void exit() {
        databaseConnection.closeConnection();
    }
    
    
}
