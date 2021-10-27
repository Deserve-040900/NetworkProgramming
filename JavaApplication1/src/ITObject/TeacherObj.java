/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ITObject;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class TeacherObj implements Serializable{
    private String teacher_id;
    private String teacher_name;
    private String dob;
    private String address;
    private String phone;
    private String email;
    private String degree;
    private String type_name;
    private String course_name;

    public TeacherObj() {
    }

    public TeacherObj(String teacher_id, String teacher_name, String dob, String address, String phone, String email, String degree, String type_name, String course_name) {
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.degree = degree;
        this.type_name = type_name;
        this.course_name = course_name;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    
}
