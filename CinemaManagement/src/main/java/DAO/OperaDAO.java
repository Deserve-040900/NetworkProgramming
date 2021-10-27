/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Opera;
import GiaoDien.QuanLyRap;
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
public class OperaDAO {

    private static OperaDAO instance;

    public OperaDAO() {
    }

    public static OperaDAO getInstance() {
        if (instance == null) {
            instance = new OperaDAO();
        }
        return instance;
    }

    public static void setInstance(OperaDAO instance) {
        OperaDAO.instance = instance;
    }

    public List<Opera> LoadListTables() {
        List<Opera> listTable = new ArrayList<Opera>();

        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `opera`");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Opera tables = new Opera(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4) == 0 ? "Còn trống" : "Đã đặt");
                listTable.add(tables);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTable;
    }
}
