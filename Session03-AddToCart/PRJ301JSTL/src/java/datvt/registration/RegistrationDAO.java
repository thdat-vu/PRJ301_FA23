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
import javax.naming.NamingException;

/**
 *
 * @author LENOVO
 */
public class RegistrationDAO implements Serializable{
    public RegistrationDTO checkLogin(String username, String password) 
            throws SQLException, NamingException, ClassNotFoundException{
        //khai bao 3 thu:
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        //them 1 bien result de tra vao DTO
        RegistrationDTO result = null;
        try{
            //1.Create connection
            con = DBHelper.getConnection();
            if(con != null){
                //2. Create SQL String
                String sql = "select lastname, isAdmin "
                        + "from Registration"
                        + "where username=? and password=?";
                //3.create stm
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                //4.exe Querry
                rs = stm.executeQuery();
                //5.process RS
                if(rs.next()){
                    //mapping
                    //5.1 get data from rs
                    String fullname = rs.getString("lastname");
                    boolean role = rs.getBoolean("isAdmin");
                    //5.2 set data to DTO
                    result = new RegistrationDTO(username, password, fullname, role);
                }
            }
        }finally{
            //dong cac con tro giao tiep vs DB 
            //khai bao dau tien dong cuoi cung
            if(rs != null){
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null){
                con.close();
            }
        }
        return result;
    }
}
