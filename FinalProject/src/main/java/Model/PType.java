/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.*;
import java.io.Serializable;

/**
 *
 * @author Xuan040900
 */
public class PType implements Serializable{
    int id;
    String type_name;

    public PType() {
    }

    public PType(int id, String type_name) {
        this.id = id;
        this.type_name = type_name;
    }

    public PType(String type_name) {
        this.type_name = type_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }
     
}
