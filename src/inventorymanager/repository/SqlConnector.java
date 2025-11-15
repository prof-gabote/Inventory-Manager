/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorymanager.repository;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Gabote
 */
public class SqlConnector {

    //DB CONNECTION
    private static final String dbName = "inventory-manager";
    private static final String dbUser = "root";
    private static final String dbPassword = "";
    private static final String connectionString = String.format("jdbc:mysql://localhost/%s?user=%s&password=%s", dbName, dbUser, dbPassword);

    public Connection getConnection() {
        System.out.println("Intentando conexión con DB: " + connectionString);
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(connectionString);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Conexión realizada con éxito.");
        return conn;
    }

}
