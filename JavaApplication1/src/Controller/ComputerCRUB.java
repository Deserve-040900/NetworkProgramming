/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import ComputerShop.ConnectDB;
import Model.Computer;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.*;
import java.sql.*;
import java.util.logging.*;
/**
 * CRUB
 * @author Xuan040900
 */
public class ComputerCRUB extends UnicastRemoteObject implements ComputerModify{
    public ComputerCRUB() throws RemoteException{
    }
    public List<Computer> findAll() throws RemoteException{
        List<Computer> com = new ArrayList<>();
        
        Statement stm = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computershop", "root", "");
            // query
            String sql = "Select * From mycomputer";
            stm = con.createStatement();
            
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                Computer cpt = new Computer(rs.getString("id"), rs.getString("producer"), rs.getString("type"), rs.getInt("price"));
                com.add(cpt);
            }
        } catch (SQLException e) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if(stm != null){
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComputerCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComputerCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // the end
        return com;
    }
    
    public void insert(Computer com) throws RemoteException{
        PreparedStatement preS = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computershop", "root", "");
            // query
            String sql = "Insert into mycomputer(id, producer, type, price) value(?, ?, ?, ?)";
            preS = con.prepareCall(sql);
            // them du lieu vao data
            preS.setString(1, com.getId());
            preS.setString(2, com.getProducer());
            preS.setString(3, com.getType());
            preS.setInt(4, com.getPrice());
            preS.execute();
            
        } catch (SQLException e) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if(preS != null){
                try {
                    preS.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComputerCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComputerCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // ket thuc
    }
    
    public void update(Computer com) throws RemoteException{
        PreparedStatement preS = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computershop", "root", "");
            // query
            String sql = "Update mycomputer set id=?, producer=?, type=?, price=? Where id = ?";
            preS = con.prepareStatement(sql);
            // them du lieu vao data
            preS.setString(1, com.getId());
            preS.setString(2, com.getProducer());
            preS.setString(3, com.getType());
            preS.setInt(4, com.getPrice());
            preS.setString(5, com.getId());
            preS.execute();
            
        } catch (SQLException e) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if(preS != null){
                try {
                    preS.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComputerCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComputerCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // ket thuc
    }
    
    public void delete(String id) throws RemoteException{
        PreparedStatement preS = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computershop", "root", "");
            // query
            String sql = "Delete from mycomputer Where id = ?";
            preS = con.prepareCall(sql);
            // them du lieu vao data
            preS.setString(1, id);
            preS.execute();
            
        } catch (SQLException e) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if(preS != null){
                try {
                    preS.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComputerCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComputerCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // ket thuc
    }
    
    public List<Computer> searchByProducer (String producer) throws RemoteException{
        List<Computer> com = new ArrayList<>();
        
        PreparedStatement preStm = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computershop", "root", "");
            // query
            String sql = "Select * From mycomputer Where producer like ?";
            preStm = con.prepareCall(sql);
            preStm.setString(1, "%" + producer + "%");
            
            ResultSet rs = preStm.executeQuery();
            while (rs.next()) {                
                Computer cpt = new Computer(rs.getString("id"), rs.getString("producer"), rs.getString("type"), rs.getInt("price"));
                com.add(cpt);
            }
        } catch (SQLException e) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if(preStm != null){
                try {
                    preStm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComputerCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComputerCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // the end
        return com;
    }
    
    public List<Computer> searchByID (String id) throws RemoteException{
        List<Computer> com = new ArrayList<>();
        
        PreparedStatement preStm = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computershop", "root", "");
            // query
            String sql = "Select * From mycomputer Where id like ?";
            preStm = con.prepareCall(sql);
            preStm.setString(1, "%" + id + "%");
            
            ResultSet rs = preStm.executeQuery();
            while (rs.next()) {                
                Computer cpt = new Computer(rs.getString("id"), rs.getString("producer"), rs.getString("type"), rs.getInt("price"));
                com.add(cpt);
            }
        } catch (SQLException e) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if(preStm != null){
                try {
                    preStm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComputerCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComputerCRUB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // the end
        return com;
    }

    @Override
    public void delete(int id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}