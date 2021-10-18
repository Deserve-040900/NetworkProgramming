/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComputerShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Xuan040900
 */
public class KeyboardCRUB {
    public static List<Keyboard> findAll(){
        List<Keyboard> key = new ArrayList<>();
        
        Statement stm = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computershop", "root", "");
            // query
            String sql = "Select * From keyboard";
            stm = con.createStatement();
            
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                Keyboard cpt = new Keyboard(rs.getInt("id"), rs.getString("name"), rs.getString("color"), rs.getInt("price"));
                key.add(cpt);
            }
        } catch (SQLException e) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if(stm != null){
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CpuCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CpuCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // the end
        return key;
    }
    
    public static void insert(Keyboard Key){
        PreparedStatement preS = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computershop", "root", "");
            // query
            String sql = "Insert into keyboard(id, name, color, price) value(?, ?, ?, ?)";
            preS = con.prepareStatement(sql);
            // them du lieu vao data
            preS.setInt(1, Key.getId());
            preS.setString(2, Key.getName());
            preS.setString(3, Key.getColor());
            preS.setInt(4, Key.getPrice());
            preS.execute();
            
        } catch (SQLException e) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if(preS != null){
                try {
                    preS.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CpuCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CpuCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // ket thuc
    }
    
    public static void delete(int id){
        PreparedStatement preS = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computershop", "root", "");
            // query
            String sql = "Delete from keyboard Where id = ?";
            preS = con.prepareStatement(sql);
            // them du lieu vao data
            preS.setInt(1, id);
            preS.execute();
            
        } catch (SQLException e) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if(preS != null){
                try {
                    preS.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CpuCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CpuCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // ket thuc
    }
    
    public static List<Keyboard> searchByName (String name){
        List<Keyboard> key = new ArrayList<>();
        
        PreparedStatement preStm = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computershop", "root", "");
            // query
            String sql = "Select * From keyboard Where name like ?";
            preStm = con.prepareCall(sql);
            preStm.setString(1, "%" + name + "%");
            
            ResultSet rs = preStm.executeQuery();
            while (rs.next()) {                
                Keyboard cpt = new Keyboard(rs.getInt("id"), rs.getString("name"), rs.getString("color"), rs.getInt("price"));
                key.add(cpt);
            }
        } catch (SQLException e) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if(preStm != null){
                try {
                    preStm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CpuCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CpuCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // the end
        return key;
    }
}
