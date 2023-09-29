/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datvt.registration;

import datvt.util.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
//nho: DAO phai giao tiep vs database nen can implement Serializable
public class RegistrationDAO implements Serializable {

    public boolean checkLogin(String username, String password)
            throws ClassNotFoundException, SQLException {

        //luu y, nhung gi lam trong DAO thi nho khai bao o dau
        //va dong o finally
        //thang nao khai bao dau tien thi phai dong cuoi cung
        //buoc 1: khai bao cac con tro ket noi
        Connection con = null;
        //buoc 2: khai bao PrepareStatement va nho dong lai
        PreparedStatement stm = null;
        //buoc 3: Chuan bi con tro ResultSet va nho dong lai
        ResultSet rs = null;
        //tao bien boolean check gia tri co user nay trong DB hay ko o day
        boolean result = false;
        try {
            //buoc 4: getConnection() nhu trong so do MVC
            con = DBHelper.createConnection();
            //buoc 5: create SQL String()
            if (con != null) {
                String sql = "SELECT username "
                        + "FROM Registration2 "
                        + "WHERE username = ? "
                        + "AND password = ?";
                //buoc 5: prepareStatement()
                stm = con.prepareStatement(sql);
                //set gia tri cho phan minh moi truy van
                stm.setInt(1, Integer.parseInt(username.trim()));
                System.out.println(username.getClass());
                stm.setInt(2, Integer.parseInt(password.trim()));
                //buoc 6: thuc thi cau lenh SQL
                rs = stm.executeQuery();
                //buoc 7: xu li result set
                //vi la ham check login nen tra ve 1 dong
                //vi vay nen if statement
                //tao ra 1 bien boolean de check xem ResultSet co the next dc ko
                //neu next duoc nghia la co 1 dong du lieu trung voi tham tri truyen xuon
                //neu next khong duoc nghia la BOF va EOF la 1 va ko co dong du lieu trung voi tham tri truyen xuong
                if (rs.next()) {
                    result = true;
                }//end user and password is verified
            }//end connection is available
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
}
