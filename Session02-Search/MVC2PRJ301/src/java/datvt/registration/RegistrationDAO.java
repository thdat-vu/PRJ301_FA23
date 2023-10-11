/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datvt.registration;


import datvt.utils.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class RegistrationDAO implements Serializable {

    public boolean checkLogin(String username, String password)
            throws ClassNotFoundException, SQLException {
        //Create connection pointer : Connection -> PrepearStm => resultSet
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        boolean result = false;
        try {
            //1. Get connection
            conn = DBHelper.createConnection();
            //2. Create SQL String
            String sql = "select username "
                    + "from Registration "
                    + "where username=? "
                    + "and password=?";
            //3. Preapare Statement
            stm = conn.prepareStatement(sql);
            //3.1.SetDataType for each ?
            //REMEMBER: ? START FROM LEFT TO RIGHT, COUNT FROM 1 -> N
            stm.setString(1, username);
            stm.setString(2, password);
            //4. execute Query
            rs = stm.executeQuery();
            //5. Process SQL
            if (rs.next()) {
                result = true;
            }
            return result;

        } finally {
            //close order: Declare first. Close latest.
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

    }
    private List<RegistrationDTO> accounts;

    public List<RegistrationDTO> getAccounts() {
        return accounts;
    }

    public void searchLastName(String searchValue)
            throws ClassNotFoundException, SQLException {
        //Create connection pointer : Connection -> PrepearStm => resultSet
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            conn = DBHelper.createConnection();
            //2. Create SQL String
            String sql = "select username ,password, lastname, isAdmin "
                    + "from Registration "
                    + "where lastname like ?";
            //3. Preapare Statement
            stm = conn.prepareStatement(sql);
            //3.1.SetDataType for each ?
            //REMEMBER: ? START FROM LEFT TO RIGHT, COUNT FROM 1 -> N
            stm.setString(1, "%" + searchValue + "%");
            //4. execute Query
            rs = stm.executeQuery();
            //5. Process SQL
            while (rs.next()) {
                String usernamme = rs.getString("username");
                String password = rs.getString("password");
                String fullname = rs.getString("lastname");
                boolean role = rs.getBoolean("isAdmin");
                RegistrationDTO dto = new RegistrationDTO(usernamme, password, fullname, role);
                if (this.accounts == null) {
                    this.accounts = new ArrayList<>();
                }
                accounts.add(dto);
            }
        } finally {
            //close order: Declare first. Close latest.
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
    }
}
