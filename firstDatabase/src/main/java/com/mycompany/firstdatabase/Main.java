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
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseConnection databaseConnection = new DatabaseConnection();
        FirstDatabase database = new FirstDatabase(scanner, databaseConnection);
        UI userInterface = new UI(scanner, database);
        
        userInterface.startUI(scanner);
        

    }

}
