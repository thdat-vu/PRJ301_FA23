/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datvt.dao;

import datvt.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class UserDAO {

    public boolean checkLogin(String username, String password) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if(conn != null){
                String sql = "SELECT USERID FROM tblUsers " + "WHERE userID = ? AND password = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if(rs.next()){
                    check = true;
                }
            }
            
        } catch (Exception e) {
            //Tai sao phai co finally??
            //Giong nhu viec dong con tro doc file hoi hoc PRO192,
            //Cho du co chuyen gi xay ra(check co true and false), cac con tro ket noi
            //van phai duoc thuc thi lenh dong lai.
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return check;
    }
}
