/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComputerShop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Xuan040900
 */
public class RamCRUB {
    public static List<RAM> findAll(){
        List<RAM> ram = new ArrayList<>();
        
        Statement stm = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computershop", "root", "");
            // query
            String sql = "Select * From ram";
            stm = con.createStatement();
            
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                RAM cpt = new RAM(rs.getInt("id"), rs.getString("name"), rs.getString("type"), rs.getInt("price"));
                ram.add(cpt);
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
        return ram;
    }
    
    public static void insert(RAM Ram){
        PreparedStatement preS = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computershop", "root", "");
            // query
            String sql = "Insert into ram(id, name, type, price) value(?, ?, ?, ?)";
            preS = con.prepareStatement(sql);
            // them du lieu vao data
            preS.setInt(1, Ram.getId());
            preS.setString(2, Ram.getName());
            preS.setString(3, Ram.getType());
            preS.setInt(4, Ram.getPrice());
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
            String sql = "Delete from ram Where id = ?";
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
    
    public static List<RAM> searchByName (String name){
        List<RAM> ram = new ArrayList<>();
        
        PreparedStatement preStm = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computershop", "root", "");
            // query
            String sql = "Select * From ram Where name like ?";
            preStm = con.prepareCall(sql);
            preStm.setString(1, "%" + name + "%");
            
            ResultSet rs = preStm.executeQuery();
            while (rs.next()) {                
                RAM cpt = new RAM(rs.getInt("id"), rs.getString("name"), rs.getString("type"), rs.getInt("price"));
                ram.add(cpt);
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
        return ram;
    }
}
