/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComputerShop;

import Model.Register;
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
public class RegisterCRUD extends UnicastRemoteObject implements RegisterModify{
    public RegisterCRUD() throws RemoteException{
        
    }
    public List<Register> findAll() throws RemoteException{
        List<Register> re = new ArrayList<>();
        
        Statement stm = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = ConnectDB.getConnect();
            // query
            String sql = "Select * From user";
            stm = con.createStatement();
            
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                Register cpt = new Register(rs.getInt("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("confirm"));
                re.add(cpt);
            }
        } catch (SQLException e) {
//            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
//        } finally {
//            if(stm != null){
//                try {
//                    stm.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(RegisterCRUD.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if(con != null){
//                try {
//                    con.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(RegisterCRUD.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
        }
        // the end
        return re;
    }
    
    public void insert(Register Re) throws RemoteException{
        PreparedStatement preS = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = ConnectDB.getConnect();
            // query
            String sql = "Insert into user(id, username, email, password, confirm) value(?, ?, ?, ?, ?)";
            preS = con.prepareStatement(sql);
            // them du lieu vao data
            preS.setInt(1, Re.getId());
            preS.setString(2, Re.getUsername());
            preS.setString(3, Re.getEmail());
            preS.setString(4, Re.getPassword());
            preS.setString(5, Re.getConfirm());
            preS.executeUpdate();
            
        } catch (SQLException e) {
//            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
//        } finally {
//            if(preS != null){
//                try {
//                    preS.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(RegisterCRUD.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if(con != null){
//                try {
//                    con.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(RegisterCRUD.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
        }
        // ket thuc
    }
    
    public void delete(int id) throws RemoteException{
        PreparedStatement preS = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = ConnectDB.getConnect();
            // query
            String sql = "Delete from user Where id = ?";
            preS = con.prepareCall(sql);
            // them du lieu vao data
            preS.setInt(1, id);
            preS.execute();
            
        } catch (SQLException e) {
//            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
//        } finally {
//            if(preS != null){
//                try {
//                    preS.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(RegisterCRUD.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if(con != null){
//                try {
//                    con.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(RegisterCRUD.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
        }
        // ket thuc
    }
    
    public List<Register> searchUsername (String name) throws RemoteException{
        List<Register> reg = new ArrayList<>();
        
        PreparedStatement preStm = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = ConnectDB.getConnect();
            // query
            String sql = "Select * From user Where username like ?";
            preStm = con.prepareCall(sql);
            preStm.setString(1, "%" + name + "%");
            
            ResultSet rs = preStm.executeQuery();
            while (rs.next()) {                
                Register cpt = new Register(rs.getInt("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("confirm"));
                reg.add(cpt);
            }
        } catch (SQLException e) {
//            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
//        } finally {
//            if(preStm != null){
//                try {
//                    preStm.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(RegisterCRUD.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if(con != null){
//                try {
//                    con.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(RegisterCRUD.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
        }
        // the end
        return reg;
    }
}
