/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ITdepartment;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author DELL
 */
public class Connect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    public static Connection connection() {
        try {
               java.lang.Class.forName("com.mysql.cj.jdbc.Driver");
               String unicode = "useSSL=false&autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8";
               return DriverManager.getConnection("jdbc:mysql://localhost:3306/itdepartment?" + unicode, "root", "");
           } catch (Exception ex) {
               System.out.println(ex.getMessage());
               System.out.println("couldn't connect!");
               throw new RuntimeException(ex);
           }
    }
}

