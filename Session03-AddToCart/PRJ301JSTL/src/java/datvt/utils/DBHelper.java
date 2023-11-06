/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datvt.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author LENOVO
 */
public class DBHelper implements Serializable{
    public static Connection getConnection()
    throws SQLException,NamingException, ClassNotFoundException{
        //1. Get current context
        Context currentContext = new InitialContext();
        //2. Look up tomcat context
        Context tomcatContext = (Context)currentContext.lookup("java:comp/env");
        
        //3. Look up out datasource
        //1 lan nua , nho la xai cai DataSource cua javax.sql nha ong noi
        DataSource ds = (DataSource)tomcatContext.lookup("DATVTDS");
        //4. Open con from the DS
        Connection con = ds.getConnection();
        return con;
    }
    
}
