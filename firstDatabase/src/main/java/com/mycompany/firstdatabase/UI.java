/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.firstdatabase;

import java.util.Scanner;


/**
 *
 * @author Drew
 */
public class UI {

    private Scanner scanner;
    private FirstDatabase database;
    

    public UI(Scanner scanner, FirstDatabase database) {
        this.scanner = new Scanner(System.in);
        this.database = database;
    }

    //starts User Intferace
    public void startUI(Scanner scanner) {

        //Used to see what the user would like to do
        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("Add: Add a user to the database");
            System.out.println("Delete: Delete user from the database");
            System.out.println("View: View information about an employee");
            System.out.println("Exit: Exits program");
            System.out.println("----------------------------------------");

            String input = scanner.nextLine();
            
            
            //used to exit database and exit program
            if (input.equalsIgnoreCase("Exit")){
                database.exit();
                break;
            }
            processInput(input, scanner);

        }

    }

    public void processInput(String input, Scanner scanner) {
        if (input.equalsIgnoreCase("Add")) {
            addEmployee(scanner);
        } else if (input.equalsIgnoreCase("Delete")) {
            deleteEmployee(scanner);
        } else if (input.equalsIgnoreCase("View")) {
            viewEmployee(scanner);
        } else {
            System.out.println("Not a valid input.");
        }
    }

    public void addEmployee(Scanner scanner) {
        System.out.println("Enter the employees first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter the employees last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter the employees ID:");
        int employeeID = scanner.nextInt();
        
        this.database.add(firstName, lastName, employeeID);
        scanner.nextLine();
        
    }
    
    public void deleteEmployee(Scanner scanner) {
        System.out.println("Enter the ID of the employee to be deleted from the system:");
        int employeeID = scanner.nextInt();
        
        this.database.delete(employeeID);
        scanner.nextLine();
    }
    
    public void viewEmployee(Scanner scanner) {
        System.out.println("Enter the ID of the employee's information you would like to view:");
        int employeeID = scanner.nextInt();
        
        this.database.viewEmployee(employeeID);
        scanner.nextLine();
    }
    
    

}
