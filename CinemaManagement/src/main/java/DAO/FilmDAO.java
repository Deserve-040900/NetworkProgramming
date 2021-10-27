/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Film;
import Utilities.DBUtility;
import java.awt.HeadlessException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author TRI
 */
public class FilmDAO {
    
    private static FilmDAO instance;
    
    public FilmDAO() {
    }
    
    public static FilmDAO getInstance() {
        if (instance == null) {
            instance = new FilmDAO();
        }
        return instance;
    }
    
    public List<Film> GetListFilm() {
        List<Film> list = new ArrayList<Film>();
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `film`");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Film film = new Film(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),rs.getDate(5), rs.getDate(6));
                list.add(film);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
   
}
