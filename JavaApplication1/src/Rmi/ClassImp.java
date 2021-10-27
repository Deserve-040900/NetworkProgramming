/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rmi;

import ITInterface.ClassITF;
import ITObject.ClassObj;
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
public class ClassImp extends UnicastRemoteObject implements ClassITF{

    public ClassImp() throws RemoteException {
    }
    
    @Override
    public void Insert(ClassObj cl) throws RemoteException{
        try {
            Connection conn = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            conn = Connect.connection();
            pst = conn.prepareStatement("INSERT INTO class(class_id, course_name, student_quantity, teacher_id) VALUES (?,?,?,?)");
            
            pst.setString(1, cl.getClass_id());
            pst.setString(2, cl.getCourse_name());
            pst.setInt(3, cl.getStudent_quantity());
            pst.setString(4, cl.getTeacher_id());
            
            pst.execute();

        } catch (HeadlessException | NumberFormatException | SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Please fill in all information");
        }
    }

    @Override
    public void Delete(ClassObj cl) throws RemoteException{
        try {
            Connection conn = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            conn = Connect.connection();
            pst = conn.prepareStatement("DELETE FROM class WHERE class_id=?");
            pst.setString(1, cl.getClass_id());
            pst.execute();
            
        } catch (HeadlessException | SQLException  e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void Update(ClassObj cl) throws RemoteException{
        try {
            Connection conn = null;
            PreparedStatement pst = null;
            conn = Connect.connection();
            pst = conn.prepareStatement("UPDATE class SET course_name=?,student_quantity=?,teacher_id=? WHERE class_id=?");
            
            pst.setString(1, cl.getCourse_name());
            pst.setInt(2, cl.getStudent_quantity());
            pst.setString(3, cl.getTeacher_id());
            pst.setString(4, cl.getClass_id());
            pst.execute();
           
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public List<ClassObj> display() throws RemoteException {
        List<ClassObj> lst = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = Connect.connection();
            pst = conn.prepareStatement("SELECT * FROM class");
            rs = pst.executeQuery();

            while (rs.next()) {             
                ClassObj cl = new ClassObj(rs.getString("class_id"), rs.getString("course_name"), rs.getInt("student_quantity"), rs.getString("teacher_id"));
                lst.add(cl);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return lst;
    }
    
}
