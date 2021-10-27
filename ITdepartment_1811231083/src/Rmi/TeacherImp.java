/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rmi;

import ITInterface.TeacherITF;
import ITObject.TeacherObj;
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
public class TeacherImp extends UnicastRemoteObject implements TeacherITF {

    public TeacherImp() throws RemoteException {
    }

    @Override
    public void Insert(TeacherObj t) throws RemoteException {

        try {
            Connection conn = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            conn = Connect.connection();
            
            pst = conn.prepareStatement("INSERT INTO teacher(teacher_id, teacher_name, dob, address, phone, email, degree, type_name, course_name) VALUES (?,?,?,?,?,?,?,?,?)");
            pst.setString(1, t.getTeacher_id());
            pst.setString(2, t.getTeacher_name());
            pst.setString(3, t.getDob());
            pst.setString(4, t.getAddress());
            pst.setString(5, t.getPhone());
            pst.setString(6, t.getEmail());
            pst.setString(7, t.getDegree());
            pst.setString(8, t.getType_name());
            pst.setString(9, t.getCourse_name());
            pst.execute();

        } catch (HeadlessException | NumberFormatException | SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Please fill in all information");
        }
    }

    @Override
    public void Delete(TeacherObj t) throws RemoteException {
        try {
            Connection conn = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            conn = Connect.connection();
            pst = conn.prepareStatement("DELETE FROM teacher WHERE teacher_id =?");
            pst.setString(1, t.getTeacher_id());
            pst.execute();
            
        } catch (HeadlessException | SQLException  e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void Update(TeacherObj t) throws RemoteException {
        try {
            Connection conn = null;
            PreparedStatement pst = null;
            conn = Connect.connection();
            pst = conn.prepareStatement("UPDATE teacher SET teacher_name= ?, dob=? , address= ? , phone= ? , email= ?, degree= ?, type_name=?, course_name =? WHERE teacher_id =?");
                      
            pst.setString(1, t.getTeacher_name());
            pst.setString(2, t.getDob());
            pst.setString(3, t.getAddress());
            pst.setString(4, t.getPhone());
            pst.setString(5, t.getEmail());
            pst.setString(6, t.getDegree());
            pst.setString(7, t.getType_name());
            pst.setString(8, t.getCourse_name());
            pst.setString(9, t.getTeacher_id());
            pst.execute();

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public List<TeacherObj> display() throws RemoteException {
        List<TeacherObj> lst = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = Connect.connection();
            pst = conn.prepareStatement("SELECT * FROM teacher");
            rs = pst.executeQuery();
                                                                     //teacher_id, teacher_name, dob, address, phone, email, degree, type_name, course_name
            while (rs.next()) {
                TeacherObj sch = new TeacherObj(rs.getString("teacher_id"), rs.getString("teacher_name"), rs.getString("dob"), rs.getString("address"), rs.getString("phone"), rs.getString("email"), rs.getString("degree"), rs.getString("type_name"), rs.getString("course_name"));
                lst.add(sch);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return lst;
    }

}
