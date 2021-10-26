/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComputerShop;

import java.sql.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author Xuan040900
 */
public class ConnectDB {
    public static Connection getConnect(){
//        String url = "jdbc:mysql://localhost:3306/computershop";
//        var user = "root";
//        var password = "";
//        try(Connection con = DriverManager.getConnection(url, user, password)){
//            System.out.println("Connecting Successful");
//            System.out.println(con.getCatalog());
//        } catch (SQLException ex) {
//            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String unicode = "useSSL=false&autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8";
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/computershop?" + unicode, "root", "");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("couldn't connect!");
            throw new RuntimeException(ex);
        }
    }
    public static void main(String[] args) {
        
    }
}
