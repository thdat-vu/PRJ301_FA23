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
public class RegistrationDAO implements Serializable{
    public boolean checkLogin(String username, String password)
    throws ClassNotFoundException, SQLException{
        //tat ca nhung gi xai trong JDBC phai khai bao truoc va nho dong lai. roi moi xai.
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;
        try{
            //1. create connection
            con = DBHelper.creatConnection();
            if(con != null){
            //2. create sql string
            String sql = "SELECT username " // nho' 1 khoang trang roi hang enter xuong hang
                    + "From Registration "
                    + "Where username = ? "
                    + "And password = ?";
            //? la gia tri tham so can truyen vao
            //nen truyen tham so thay vi ma cu  + username
            //cau lenh khong truyen tham so la nonPrepareStatement
            //cau lenh truyen tham so la PrepareStatement
            //thang nao khai bao dau tien, thang do dong' cuoi cung
            //chi can check connection thoi nen chi can khoa chinh la dc
        //3. create statement
        stm = con.prepareStatement(sql);
        //tham so la dau cham hoi dc tinh tu trai sang phai vi tri dc tinh so 1.
        stm.setString(1, username);
        stm.setString(2, password);
        //4. exe Query
        rs = stm.executeQuery();
        //5. process result set
        //neu viet cau lenh SELECT
        //xac dinh no se~ tra ve may dong???
        //neu 1 dong thi xai lenh if
        //neu nhieu dong thi xai lenh while
        if (rs.next()){
            result = true;
        }//end username and password is verified
            }//end connection is available
        }finally{
            if(rs != null){
                rs.close();
            }if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
        }
        
        return result;
    }
}
