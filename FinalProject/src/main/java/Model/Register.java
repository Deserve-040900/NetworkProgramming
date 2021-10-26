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
public class Register implements Serializable{
    int id;
    String username, email, password, confirm;

    public Register() {
    }

    public Register(int id, String username, String email, String password, String confirm) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirm = confirm;
    }

    public Register(String username, String email, String password, String confirm) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirm = confirm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }    
}
