/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Xuan040900
 */
public class ConnectMyDB {
    public static Connection getConnection(){
         Connection con = null;
        try {           
            //Tao chuội ket nối
            String chuoiketnoi = "jdbc:sqlserver://localhost:1433; databasename=QLSV; user=sa; password=Phuong@3008";
            //Dky JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Thuc hien ketnoi
            con = DriverManager.getConnection(chuoiketnoi);
            System.err.println("Successful");
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectMyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
         return con;
    }
}
