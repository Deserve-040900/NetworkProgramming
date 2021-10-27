/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComputerShop;

import Model.Product;
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
public class ProductCRUD extends UnicastRemoteObject implements ProductModify{
    public ProductCRUD() throws RemoteException{
        
    }
    public List<Product> findAll() throws RemoteException{
        List<Product> com = new ArrayList<>();
        
        Statement stm = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = ConnectDB.getConnect();
            // query
            String sql = "Select * From product";
            stm = con.createStatement();
            
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                Product cpt = new Product(rs.getInt("PID"), rs.getString("Producer"), rs.getInt("Price"), rs.getInt("TypeID"));
                com.add(cpt);
            }
        } catch (SQLException e) {
//            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
//        } finally {
//            if(stm != null){
//                try {
//                    stm.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ProductCRUD.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if(con != null){
//                try {
//                    con.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ProductCRUD.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
        }
        // the end
        return com;
    }
    
    public void insert(Product pr) throws RemoteException{
        PreparedStatement preS = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = ConnectDB.getConnect();
            // query
            String sql = "Insert into product(PID, Producer, Price, TypeID) values(?, ?, ?, ?)";
            preS = con.prepareCall(sql);
            // them du lieu vao data
            preS.setInt(1, pr.getId());
            preS.setString(2, pr.getProducer());
            preS.setInt(3, pr.getPrice());
            preS.setInt(4, pr.getTypeID());
            preS.execute();
            
        } catch (SQLException | NumberFormatException e) {
//            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
//        } finally {
//            if(preS != null){
//                try {
//                    preS.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ProductCRUD.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if(con != null){
//                try {
//                    con.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ProductCRUD.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
        }
        // ket thuc
    }
    
    public void update(Product p) throws RemoteException{
        PreparedStatement preS = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = ConnectDB.getConnect();
            // query
            String sql = "Update product set Producer=?, Price=?, TypeID=? Where PID = ?";
            preS = con.prepareStatement(sql);
            // them du lieu vao data
            preS.setString(1, p.getProducer());
            preS.setInt(2, p.getPrice());
            preS.setInt(3, p.getTypeID());
            preS.setInt(4, p.getId());
            preS.execute();
            
        } catch (SQLException e) {
//            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
//        } finally {
//            if(preS != null){
//                try {
//                    preS.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ProductCRUD.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if(con != null){
//                try {
//                    con.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ProductCRUD.class.getName()).log(Level.SEVERE, null, ex);
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
            String sql = "Delete from product Where PID = ?";
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
//                    Logger.getLogger(ProductCRUD.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if(con != null){
//                try {
//                    con.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ProductCRUD.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
        }
        // ket thuc
    }
    
    public List<Product> searchByProducer (String producer) throws RemoteException{
        List<Product> com = new ArrayList<>();
        
        PreparedStatement preStm = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = ConnectDB.getConnect();
            // query
            String sql = "Select * From product Where Producer like ?";
            preStm = con.prepareCall(sql);
            preStm.setString(1, "%" + producer + "%");
            
            ResultSet rs = preStm.executeQuery();
            while (rs.next()) {                
                Product cpt = new Product(rs.getInt("PID"), rs.getString("Producer"), rs.getInt("Price"), rs.getInt("TypeID"));
                com.add(cpt);
            }
        } catch (SQLException e) {
//            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
//        } finally {
//            if(preStm != null){
//                try {
//                    preStm.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ProductCRUD.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if(con != null){
//                try {
//                    con.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ProductCRUD.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
        }
        // the end
        return com;
    }
    
    public List<Product> searchByID (int id) throws RemoteException{
        List<Product> com = new ArrayList<>();
        
        PreparedStatement preStm = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = ConnectDB.getConnect();
            // query
            String sql = "Select * From product Where PID = ?";
            preStm = con.prepareCall(sql);
            preStm.setInt(1, id);
            
            ResultSet rs = preStm.executeQuery();
            while (rs.next()) {                
                Product cpt = new Product(rs.getInt("PID"), rs.getString("Producer"), rs.getInt("Price"), rs.getInt("TypeID"));
                com.add(cpt);
            }
        } catch (SQLException e) {
//            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
//        } finally {
//            if(preStm != null){
//                try {
//                    preStm.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ProductCRUD.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if(con != null){
//                try {
//                    con.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ProductCRUD.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
        }
        // the end
        return com;
    }
}
