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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB_Access {
    private Connection con;
    private Statement stm;
    public DB_Access() {
        try {
            ConnectMysql mc = new ConnectMysql();
            con = mc.getConnection();
            stm = con.createStatement();
        } catch (Exception e) {
        }
    }
    public int Update(String str){
        try {
            int i = stm.executeUpdate(str);
            return i;
        } catch (Exception e) {
            return -1;
        }
    }
    public ResultSet Query(String str){
        try {
            ResultSet re = stm.executeQuery(str);
            return re;
        } catch (Exception e) {
            return null;
        }
    }
}
