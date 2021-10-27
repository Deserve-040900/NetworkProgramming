/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rmi;

import ITInterface.SectionITF;
import ITObject.SectionObj;
import ITdepartment.Connect;
import java.awt.HeadlessException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class SectionImp extends UnicastRemoteObject implements SectionITF{

    public SectionImp() throws RemoteException {
    }
    
    @Override
    public void Insert(SectionObj s) {
        try {
            Connection conn = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            conn = Connect.connection();
            pst = conn.prepareStatement("INSERT INTO section( section_id , section_name, start_time, end_time ) VALUES (?,?,?,?)");
            pst.setString(1,s.getSection_id());
            pst.setString(2,s.getSection_name());
            pst.setString(3,s.getStart_time());
            pst.setString(4,s.getEnd_time());
            
            pst.execute();
           
        } catch (HeadlessException | NumberFormatException | SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Please fill in all information");
        }
    }

    @Override
    public void Delete(SectionObj s) throws RemoteException{
        try {
            Connection conn = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            conn = Connect.connection();
            pst = conn.prepareStatement("DELETE FROM section WHERE section_id =?");
            pst.setString(1,s.getSection_id());
            pst.execute();
            
        } catch (HeadlessException | SQLException  e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void Update(SectionObj s) throws RemoteException{
        try {
            Connection conn = null;
            PreparedStatement pst = null;
            conn = Connect.connection();
            pst = conn.prepareStatement("UPDATE section SET section_name= ?, start_time=?, end_time=?  WHERE section_id =?");
            
            pst.setString(1,s.getSection_name());
            pst.setString(2,s.getStart_time());
            pst.setString(3,s.getEnd_time());
            pst.setString(4,s.getSection_id());
            pst.execute();
            
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public List<SectionObj> display() throws RemoteException {
        List<SectionObj> lst = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = Connect.connection();
            pst = conn.prepareStatement("SELECT * FROM section");
            rs = pst.executeQuery();

            while (rs.next()) {
                SectionObj c = new SectionObj(rs.getString("section_id"), rs.getString("section_name"), rs.getString("start_time"), rs.getString("end_time"));
                lst.add(c);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return lst;
    }
    
}
