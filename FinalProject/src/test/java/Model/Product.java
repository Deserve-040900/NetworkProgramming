/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Xuan040900
 */
public class Product {
    int id;
    String producer;
    int price, typeID;

    public Product() {
    }

    public Product(int id, String producer, int price, int typeID) {
        this.id = id;
        this.producer = producer;
        this.price = price;
        this.typeID = typeID;
    }

    public Product(String producer, int price, int typeID) {
        this.producer = producer;
        this.price = price;
        this.typeID = typeID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }
    
}
