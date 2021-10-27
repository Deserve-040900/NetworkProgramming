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
public class ScheduleObj implements Serializable{
    private String class_id;
    private String course_name;
    private String section_id;
    private String day_of_week;
    private String room;
    
    
    public ScheduleObj() {
    }

    public ScheduleObj(String class_id, String course_name, String section_id, String day_of_week, String room) {
        this.class_id = class_id;
        this.course_name = course_name;
        this.section_id = section_id;
        this.day_of_week = day_of_week;
        this.room = room;
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

    public String getSection_id() {
        return section_id;
    }

    public void setSection_id(String section_id) {
        this.section_id = section_id;
    }

    public String getDay_of_week() {
        return day_of_week;
    }

    public void setDay_of_week(String day_of_week) {
        this.day_of_week = day_of_week;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    
}
