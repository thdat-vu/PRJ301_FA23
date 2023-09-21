/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datvt.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class DBHelper implements Serializable{
    public static Connection creatConnection()
    throws ClassNotFoundException, SQLException{
        //1. Load Driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //2. Create URL Connection String
        String url = "jdbc:sqlserver://localhost:1433;databaseName=ServletModelDB";
        //3. Open Connection
        Connection conn = DriverManager.getConnection(url, "sa", "12345");
        return conn;
    }
}
