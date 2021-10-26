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
public class CPU implements Serializable{
    int id;
    String name,chip;
    int price;

    public CPU() {
    }

    public CPU(int id, String name, String chip, int price) {
        this.id = id;
        this.name = name;
        this.chip = chip;
        this.price = price;
    }

    public CPU(String name, String chip, int price) {
        this.name = name;
        this.chip = chip;
        this.price = price;
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

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
