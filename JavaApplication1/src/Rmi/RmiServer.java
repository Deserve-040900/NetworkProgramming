/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import Rmi.ScheduleImp;

/**
 *
 * @author DELL
 */
public class RmiServer {

    public static void main(String args[]) throws RemoteException {
        try {
            Registry r = LocateRegistry.createRegistry(5000);
            ScheduleImp schI = new ScheduleImp();
            TeacherImp tI = new TeacherImp();
            ClassImp clI = new ClassImp();
            CourseImp cI = new CourseImp();
            SectionImp si = new SectionImp();
            r.bind("ScheduleITF", schI);
            r.bind("TeacherITF", tI);
            r.bind("ClassITF", clI);
            r.bind("Course", cI);
            r.bind("SectionITF", si);
            System.out.println("SERVER IS READY...");
        } catch (Exception e) {
        }
    }
}
