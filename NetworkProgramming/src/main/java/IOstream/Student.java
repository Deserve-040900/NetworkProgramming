/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOstream;

import java.io.*;
/**
 *
 * @author Quoc
 */
public class Student implements Serializable{

//    private static final long serialVersionUID = 1L;
    int ID;
    String fullname;    
    String classID;
    String address;

    public Student() {
    }

    public Student(int ID, String fullname, String classID, String address) {
        this.fullname = fullname;
        this.ID = ID;
        this.classID = classID;
        this.address = address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}