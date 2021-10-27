/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rmi;

import ITInterface.CourseITF;
import ITObject.CourseObj;
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
public class CourseImp extends UnicastRemoteObject implements CourseITF {

    public CourseImp() throws RemoteException {
         
    }

    @Override
    public void Insert(CourseObj c) throws RemoteException {

        try {
            Connection conn = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            conn = Connect.connection();
            pst = conn.prepareStatement("INSERT INTO course (course_name , credits, start_date, end_date) VALUES (?,?,?,?)");
            pst.setString(1, c.getCourse_Name());
            pst.setInt(2, c.getCredits());
            pst.setString(3, c.getStart_date());
            pst.setString(4, c.getEnd_date());

            pst.execute();

        } catch (HeadlessException | NumberFormatException | SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Please fill in all information");
        }
    }

    @Override
    public void Delete(CourseObj c) throws RemoteException {
        try {
            Connection conn = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            conn = Connect.connection();
            pst = conn.prepareStatement("DELETE FROM course WHERE course_name=?");
            pst.setString(1, c.getCourse_Name());
            pst.execute();
            

        } catch (HeadlessException | SQLException  e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void Update(CourseObj c) throws RemoteException {
        try {
            Connection conn = null;
            PreparedStatement pst = null;
            conn = Connect.connection();
            pst = conn.prepareStatement("UPDATE course SET credits = ?, start_date=?, end_date=?  WHERE course_name=?");
            pst.setInt(1, c.getCredits());
            pst.setString(2, c.getStart_date());
            pst.setString(3, c.getEnd_date());
            pst.setString(4, c.getCourse_Name());

            pst.execute();

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public List<CourseObj> display() throws RemoteException {
        List<CourseObj> lst = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = Connect.connection();
            pst = conn.prepareStatement("SELECT * FROM course");
            rs = pst.executeQuery();

            while (rs.next()) {
                CourseObj c = new CourseObj(rs.getString("course_name"), rs.getInt("credits"), rs.getString("start_date"), rs.getString("end_date"));
                lst.add(c);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return lst;
    }

}
