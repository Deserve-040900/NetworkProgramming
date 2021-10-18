/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookInfo;

import java.sql.Date;

/**
 *
 * @author Xuan040900
 */
public class Book {
    private int id;
    private String name;
    private Date date;
    private String type;
    private String author;

    public Book() {
    }

    public Book(int id) {
        this.id = id;
    }

    public Book(int id, String name, Date date, String type, String author) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.type = type;
        this.author = author;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", name=" + name + ", date=" + date + ", type=" + type + ", author=" + author + '}';
    }
    
    
}
