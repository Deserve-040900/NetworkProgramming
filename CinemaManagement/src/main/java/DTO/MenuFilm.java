/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author TRI
 */
public class MenuFilm {

    private String Film_Name;
    private int count;
    private int price;
    private int totalPrice;

    public MenuFilm() {
    }

    public MenuFilm(String Film_Name, int count, int price, int totalPrice) {
        this.Film_Name = Film_Name;
        this.count = count;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public String getFilm_Name() {
        return Film_Name;
    }

    public void setFilm_Name(String Film_Name) {
        this.Film_Name = Film_Name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    
   
    
  
    
}
