/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import ComputerShop.ConnectDB;
import Model.CPU;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
/**
 *
 * @author Xuan040900
 */
public class CpuCRUB extends UnicastRemoteObject implements CpuModify{
    public CpuCRUB() throws RemoteException{       
    }
    public List<CPU> findAll() throws RemoteException{
        List<CPU> cpu = new ArrayList<>();
        
        Statement stm = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computershop", "root", "");
            // query
            String sql = "Select * From cpu";
            stm = con.createStatement();
            
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                CPU cpt = new CPU(rs.getInt("id"), rs.getString("name"), rs.getString("chip"), rs.getInt("price"));
                cpu.add(cpt);
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
        return cpu;
    }
    
    public void insert(CPU Cpu) throws RemoteException{
        PreparedStatement preS = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computershop", "root", "");
            // query
            String sql = "Insert into cpu(id, name, chip, price) value(?, ?, ?, ?)";
            preS = con.prepareCall(sql);
            // them du lieu vao data
            preS.setInt(1, Cpu.getId());
            preS.setString(2, Cpu.getName());
            preS.setString(3, Cpu.getChip());
            preS.setInt(4, Cpu.getPrice());
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
    
    public void delete(int id) throws RemoteException{
        PreparedStatement preS = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computershop", "root", "");
            // query
            String sql = "Delete from cpu Where id = ?";
            preS = con.prepareCall(sql);
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
    
    public List<CPU> searchByName (String name) throws RemoteException{
        List<CPU> cpu = new ArrayList<>();
        
        PreparedStatement preStm = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computershop", "root", "");
            // query
            String sql = "Select * From cpu Where name like ?";
            preStm = con.prepareCall(sql);
            preStm.setString(1, "%" + name + "%");
            
            ResultSet rs = preStm.executeQuery();
            while (rs.next()) {                
                CPU cpt = new CPU(rs.getInt("id"), rs.getString("name"), rs.getString("chip"), rs.getInt("price"));
                cpu.add(cpt);
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
        return cpu;
    }
}
