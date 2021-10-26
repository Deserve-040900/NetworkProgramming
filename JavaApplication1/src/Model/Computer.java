/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Xuan040900
 */
public class Computer implements Serializable{
    String id;
    String producer,type;
    int price;

    public Computer() {
    }

    public Computer(String id, String producer, String type, int price) {
        this.id = id;
        this.producer = producer;
        this.type = type;
        this.price = price;
    }

    public Computer(String producer, String type, int price) {
        this.producer = producer;
        this.type = type;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
