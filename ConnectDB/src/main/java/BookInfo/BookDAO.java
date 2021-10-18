/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Database.ConnectMyDB;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Xuan040900
 */
public class BookDAO {
    List<Book> book = new ArrayList();
    
    public int Add (Book bk){
        book.Add(bk);
        return 1;
    }
    
    public void getAll(){
        for (Book bk : book){
            System.out.println(bk.toString());
        }
    }
    public Book findByID(int Id) throws Exception{
        for (Book bk : book){
            if(bk.getId() == Id){
                return bk;
            }
        }
        return null;
        
//        String sql = "select * from SinhVien where ID = ?";
//        try(
//            Connection con = ConnectMyDB.getConnection();
//            PreparedStatement c = con.prepareStatement(sql);
//            ){
//            c.setString(1, ID);
//            ResultSet rs = c.executeQuery();
//            
//            if (rs.next()){
//                Book bk = new Book();
//                bk.setId(rs.getInt("ID"));
//                bk.setName(rs.getString("Name"));
//                bk.setAuthor(rs.getString("Author"));
//                bk.setType(rs.getString("Type"));
//                bk.setDate(rs.getDate("Date"));
//                
//                return bk;    
//            }
//            return null;          
//        }
    }
    
    public int update(Book bk1){
        for (Book bk : book){
            if(bk.getId() == bk1.getId()){
                bk.setName(bk1.getName());
                bk.setAuthor(bk1.getAuthor());
                bk.setType(bk1.getType());
                bk.setDate(bk1.getDate());
            }
        }
        return 1;
    }
    public boolean insert(Book bk) throws Exception{
        String sql = "Insert into SinhVien (ID, Name, Author, Type, Date, Gender) values (?,?,?,?,?,?)";
        try(
            Connection con = ConnectMyDB.getConnection();
            PreparedStatement c = con.prepareStatement(sql);
            ){
            c.setInt(1, bk.getId());
            c.setString(2, bk.getName());
            c.setString(3, bk.getAuthor());
            c.setString(4, bk.getType());
            c.setDate(5, bk.getDate());
           
            return c.executeLargeUpdate() > 0;
        }
    }
    
    public boolean Update(Book bk) throws Exception{
        String sql = " Update SinhVien set Fullname = ?, Author = ?, Type = ?, Date = ?, Gender = ? " + " where ID = ? ";
        try(
            Connection con = ConnectMyDB.getConnection();
            PreparedStatement c = con.prepareStatement(sql);
            ){
            c.setInt(6, bk.getId());
            c.setString(1, bk.getName());
            c.setString(2, bk.getAuthor());
            c.setString(3, bk.getType());
            c.setDate(4, bk.getDate());
           
            return c.executeLargeUpdate() > 0;
        }
    }
    
    public boolean Delete(String ID) throws Exception{
        String sql = "Delete from SinhVien where ID = ?";
        try(
            Connection con = ConnectMyDB.getConnection();
            PreparedStatement c = con.prepareStatement(sql);
            ){
            c.setString(1, ID);         
            return c.executeLargeUpdate() > 0;
        }
    }

    void Add(Book bk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
