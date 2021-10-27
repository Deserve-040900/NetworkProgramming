/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rmi;

import ITInterface.ScheduleITF;
import ITObject.ScheduleObj;
import ITdepartment.Connect;
import java.awt.HeadlessException;
import java.util.List;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class ScheduleImp extends UnicastRemoteObject implements ScheduleITF{

    public ScheduleImp() throws RemoteException{
    }

    @Override
    public void Insert(ScheduleObj sch) throws RemoteException{
         try {
            Connection conn = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            conn = Connect.connection();
            pst = conn.prepareStatement("INSERT INTO schedule ( class_id, course_name, section_id , day_of_week, room ) VALUES (?,?,?,?,?)");
            
            pst.setString(1, sch.getClass_id());
            pst.setString(2, sch.getCourse_name());
            pst.setString(3, sch.getSection_id());
            pst.setString(4, sch.getDay_of_week());
            pst.setString(5, sch.getRoom());
            

            pst.execute();

        } catch (HeadlessException | NumberFormatException | SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Please fill in all information");
        }
    }

    @Override
    public void Delete(ScheduleObj sch) throws RemoteException{
        try {
            Connection conn = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            conn = Connect.connection();
            pst = conn.prepareStatement("DELETE FROM schedule WHERE class_id =?");
            pst.setString(1, sch.getClass_id());
            pst.execute();

        } catch (HeadlessException | SQLException  e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void Update(ScheduleObj sch) throws RemoteException{
        try {
            Connection conn = null;
            PreparedStatement pst = null;
            conn = Connect.connection();
            pst = conn.prepareStatement("UPDATE schedule SET  course_name=?, section_id=?, day_of_week=?, room=?  WHERE class_id=?");

            pst.setString(1, sch.getCourse_name());
            pst.setString(2, sch.getSection_id());
            pst.setString(3, sch.getDay_of_week());
            pst.setString(4, sch.getRoom());
            pst.setString(5, sch.getClass_id());

            pst.execute();

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public List<ScheduleObj> display() throws RemoteException {
        List<ScheduleObj> lst = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = Connect.connection();
            pst = conn.prepareStatement("SELECT * FROM schedule");
            rs = pst.executeQuery();

            while (rs.next()) {
                ScheduleObj sch = new ScheduleObj(rs.getString("class_id"), rs.getString("course_name"), rs.getString("section_id"), rs.getString("day_of_week"), rs.getString("room"));
                lst.add(sch);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return lst;
    }

    @Override
    public List<ScheduleObj> displaySchedule() throws RemoteException {
        List<ScheduleObj> lst = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = Connect.connection();
            pst = conn.prepareStatement("SELECT * FROM schedule");
            rs = pst.executeQuery();

            while (rs.next()) {
                ScheduleObj sch = new ScheduleObj(rs.getString("class_id"), rs.getString("course_name"), rs.getString("section_id"), rs.getString("day_of_week"), rs.getString("room"));
                lst.add(sch);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return lst;
    }
    
}
