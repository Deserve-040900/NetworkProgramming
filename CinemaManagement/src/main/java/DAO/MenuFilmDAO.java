/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.MenuFilm;
import Utilities.DBUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TRI
 */
public class MenuFilmDAO {

    private static MenuFilmDAO instance;

    public MenuFilmDAO() {
    }

    public static MenuFilmDAO getInstance() {
        if (instance == null) {
            instance = new MenuFilmDAO();
        }
        return instance;
    }

    public static void setInstance(MenuFilmDAO instance) {
        MenuFilmDAO.instance = instance;
    }

    public List<MenuFilm> GetListMenuByTableId(int id) {
        List<MenuFilm> list = new ArrayList<MenuFilm>();
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT `film`.`name`, `orders`.`count`, `film`.`price`, `orders`.`count`*`film`.`price` AS totalPrice FROM `orders`, `invoice`, `film` WHERE `orders`.`invoice_ID` = `invoice`.`ID` AND `orders`.`film_ID` = `film`.`ID` AND `invoice`.`status` = 0 AND `invoice`.`opera_ID` = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                MenuFilm menu = new MenuFilm(rs.getString(1), rs.getInt(2),rs.getInt(3), rs.getInt(4));
                list.add(menu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuFilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
