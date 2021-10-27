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
public class ClassObj implements Serializable{
    
    private String class_id;
    private String course_name;
    private int student_quantity ;
    private String teacher_id;

    public ClassObj() {
    }

    public ClassObj(String class_id, String course_name, int student_quantity, String teacher_id) {
        this.class_id = class_id;
        this.course_name = course_name;
        this.student_quantity = student_quantity;
        this.teacher_id = teacher_id;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getStudent_quantity() {
        return student_quantity;
    }

    public void setStudent_quantity(int student_quantity) {
        this.student_quantity = student_quantity;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    
}
