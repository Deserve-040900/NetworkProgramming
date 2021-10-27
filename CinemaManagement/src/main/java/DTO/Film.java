/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author huyparody
 */
public class Film {

    private int id;
    private String name;
    private int price;
    private String dramatic_name;
    private Date startDate;
    private Date endDate;

    public Film() {
    }

    public Film(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Film(int id, String name, int price, String dramatic_name, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.dramatic_name = dramatic_name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDramatic_name() {
        return dramatic_name;
    }

    public void setDramatic_name(String dramatic_name) {
        this.dramatic_name = dramatic_name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
 @Override
    public String toString() {
        return name;
    }

    
   
}
