/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author TRI
 */
public class Invoices {

    private int id;
    private int accountId;
    private int opera_Id;
    private int totalPrice;
    private Timestamp invoiceDate;
    private int status;

    public Invoices() {
    }

    public Invoices(int id, int accountId, int opera_Id, int totalPrice, Timestamp invoiceDate, int status) {
        this.id = id;
        this.accountId = accountId;
        this.opera_Id = opera_Id;
        this.totalPrice = totalPrice;
        this.invoiceDate = invoiceDate;
        this.status = status;
    }   
}
