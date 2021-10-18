/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserManagement;

/**
 *
 * @author Xuan040900
 */
import java.sql.*;
import javax.swing.*;

public class ConnectMysql {
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String unicode = "useSSL=false&autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8";
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement?" + unicode, "root", "");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(),"Error",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
