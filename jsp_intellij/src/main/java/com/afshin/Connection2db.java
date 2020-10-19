package com.afshin;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connection2db {
    public Connection2db() {
    }

    public static Connection getConnection(){

        Connection con=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test01", "admin", "123456");
        }
        catch (Exception e){System.out.println(e);}
        return con;
    }
}
