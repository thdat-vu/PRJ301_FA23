/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datvt.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author datvt
 * This class was created to support for create connection between JDBC and DAO
 */

public class DBHelper implements Serializable{

    //How to createConnection()???
    //First thing: add jdbc4.jar in to this project!!!! PLEASE!!!!!
    public static Connection createConnection()
    throws ClassNotFoundException, SQLException{
        //1. Load driver by Class.forName()
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //2. Create SQL String
        String sql = "jdbc:sqlserver://localhost:1433;databaseName=ServletModelDB";
        //3. Open conncection
        Connection conn = DriverManager.getConnection(sql, "sa", "12345");
        return conn;
    }
    
}
