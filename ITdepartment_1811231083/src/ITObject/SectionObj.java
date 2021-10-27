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
public class SectionObj implements Serializable{
    private String section_id ;
    private String section_name;
    private String start_time ;
    private String end_time;

    public SectionObj() {
    }

    public SectionObj(String section_id, String section_name, String start_time, String end_time) {
        this.section_id = section_id;
        this.section_name = section_name;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public String getSection_id() {
        return section_id;
    }

    public void setSection_id(String section_id) {
        this.section_id = section_id;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    
}
