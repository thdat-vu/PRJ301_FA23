/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datvt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 * Connect to DB
 */
public class DBUtils {
    //tai sao lai la static????
    //no la do dung chung
    //ham static thi quyen quan ly luc nay cua no la class chu ko con la Object nua
    //-> ko can tao Object nua
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=UserManagerment";
        conn = DriverManager.getConnection(url, "sa", "12345");
        return conn;
    }
}
