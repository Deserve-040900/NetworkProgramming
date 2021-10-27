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
public class CourseObj implements Serializable{
    private String course_Name;
    private int credits;
    private String start_date;
    private String end_date;

    public CourseObj() {
    }

    public CourseObj(String course_Name, int credits, String start_date, String end_date) {
        this.course_Name = course_Name;
        this.credits = credits;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public String getCourse_Name() {
        return course_Name;
    }

    public void setCourse_Name(String course_Name) {
        this.course_Name = course_Name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    
    
}
