/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.firstdatabase;

import java.sql.Connection;

/**
 *
 * @author Drew
 */
public class Main {

    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        
        //Use the connection
        Connection connection = databaseConnection.getConnection();
        databaseConnection.closeConnection();
    }

}
