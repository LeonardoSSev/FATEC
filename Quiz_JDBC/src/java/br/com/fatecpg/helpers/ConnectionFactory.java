/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jeffersoncn
 */
public class ConnectionFactory {
    private static final String URL=  "jdbc:derby://localhost:1527/quiz";
    private static final String USER = "quiz";
    private static final String PASS = "quiz";
    private static Connection connection = null;
    
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            if (ConnectionFactory.connection == null || ConnectionFactory.connection.isClosed()) {
                ConnectionFactory.connection = DriverManager.getConnection(URL, USER, PASS);
            } 
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
        return ConnectionFactory.connection;
    }
}
