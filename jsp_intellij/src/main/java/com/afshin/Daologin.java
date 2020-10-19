package com.afshin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Daologin {

    public void Daologin()
    {
    }

    Connection2db conect =new Connection2db();

    public Userpas getusr(String strusr)
    {
        
        Userpas up=new Userpas();
        try{
            Connection con= conect.getConnection();
            PreparedStatement statement=con.prepareStatement("SELECT * FROM test01.tbl_auth WHERE usr=?");
            statement.setString(1,strusr);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                //rs.next();
                up.setUsr(rs.getString("usr"));
                up.setPws(rs.getString("pws"));
                up.setLocate(rs.getString("locate"));
            }
            else
            {
                up.setUsr("null");
            }
            con.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return up;    
    }
}
