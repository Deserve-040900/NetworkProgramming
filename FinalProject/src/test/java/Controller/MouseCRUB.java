/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import ComputerShop.ConnectDB;
import Model.Mouse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
/**
 *
 * @author Xuan040900
 */
public class MouseCRUB extends UnicastRemoteObject implements MouseModify{
    public MouseCRUB() throws RemoteException{
        
    }
    public List<Mouse> findAll() throws RemoteException{
        List<Mouse> mou = new ArrayList<>();
        
        Statement stm = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computershop", "root", "");
            // query
            String sql = "Select * From mouse";
            stm = con.createStatement();
            
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                Mouse cpt = new Mouse(rs.getInt("id"), rs.getString("name"), rs.getInt("price"));
                mou.add(cpt);
            }
        } catch (SQLException e) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if(stm != null){
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MouseCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MouseCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // the end
        return mou;
    }
    
    public void insert(Mouse Mou) throws RemoteException{
        PreparedStatement preS = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computershop", "root", "");
            // query
            String sql = "Insert into mouse(id, name, price) value(?, ?, ?)";
            preS = con.prepareStatement(sql);
            // them du lieu vao data
            preS.setInt(1, Mou.getId());
            preS.setString(2, Mou.getName());
            preS.setInt(3, Mou.getPrice());
            preS.execute();
            
        } catch (SQLException e) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if(preS != null){
                try {
                    preS.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MouseCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MouseCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // ket thuc
    }
    
    public void delete(int id) throws RemoteException{
        PreparedStatement preS = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computershop", "root", "");
            // query
            String sql = "Delete from mouse Where id = ?";
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
                    Logger.getLogger(MouseCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MouseCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // ket thuc
    }
    
    public List<Mouse> searchByName (String name) throws RemoteException{
        List<Mouse> mou = new ArrayList<>();
        
        PreparedStatement preStm = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computershop", "root", "");
            // query
            String sql = "Select * From mouse Where name like ?";
            preStm = con.prepareCall(sql);
            preStm.setString(1, "%" + name + "%");
            
            ResultSet rs = preStm.executeQuery();
            while (rs.next()) {                
                Mouse cpt = new Mouse(rs.getInt("id"), rs.getString("name"), rs.getInt("price"));
                mou.add(cpt);
            }
        } catch (SQLException e) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if(preStm != null){
                try {
                    preStm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MouseCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MouseCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // the end
        return mou;
    }
}
