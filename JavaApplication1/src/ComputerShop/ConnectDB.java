/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ComputerShop;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Xuan040900
 */
public class ConnectDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String url = "jdbc:mysql://localhost:3306/computershop";
        var user = "root";
        var password = "";
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection Successful");
            System.out.println(con.getCatalog());
        } catch (SQLException e) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
        }
    }    
}
// Search by Computer_ID, Computer_type, CPU_Name, Keyboard_Name, Mouse_Name