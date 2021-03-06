/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComputerShop;

import Model.PType;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.sql.PreparedStatement;
/**
 *
 * @author Xuan040900
 */
public class PTypeCRUD extends UnicastRemoteObject implements PTypeModify{
    public PTypeCRUD() throws RemoteException{
        
    }
    public List<PType> findAll() throws RemoteException{
        List<PType> type = new ArrayList<>();
        
        Statement stm = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = ConnectDB.getConnect();
            // query
            String sql = "Select * From product_type";
            stm = con.createStatement();
            
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                PType cpt = new PType(rs.getInt("TID"), rs.getString("Type_name"));
                type.add(cpt);
            }
        } catch (SQLException e) {
//            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
//        } finally {
//            if(stm != null){
//                try {
//                    stm.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(PTypeCRUD.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if(con != null){
//                try {
//                    con.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(PTypeCRUD.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
        }
        // the end
        return type;
    }
    
    public void insert(PType pt) throws RemoteException{
        PreparedStatement preS = null;
        Connection con = null;
        
        try {
            // lay tat ca danh sach may tinh
            con = ConnectDB.getConnect();
            // query
            String sql = "Insert into product_type(TID, Type_name) values(?, ?)";
            preS = con.prepareStatement(sql);
            // them du lieu vao data
            preS.setInt(1, pt.getId());
            preS.setString(2, pt.getType_name());
            preS.executeUpdate();
            
        } catch (SQLException e) {
//            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
//        } finally {
//            if(preS != null){
//                try {
//                    preS.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(PTypeCRUD.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if(con != null){
//                try {
//                    con.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(PTypeCRUD.class.getName()).log(Level.SEVERE, null, ex);
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
            String sql = "Delete from product_type Where TID = ?";
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
//                    Logger.getLogger(PTypeCRUD.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if(con != null){
//                try {
//                    con.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(PTypeCRUD.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
        }
        // ket thuc
    }
}
