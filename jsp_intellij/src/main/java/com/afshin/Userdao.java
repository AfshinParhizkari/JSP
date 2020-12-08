package com.afshin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Userdao {

    public void Userdao()
    {
    }

    private Connection2db conect =new Connection2db();

    public User getusr(String strusr)
    {
        
        User up=new User();
        try{
            Connection con= conect.getConnection();
            PreparedStatement statement=con.prepareStatement("SELECT * FROM tbl_auth WHERE usr=?");
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

    public int adduser(User usr){
        Integer status=0;
        try{
            Connection con= conect.getConnection();
            PreparedStatement statement=con.prepareStatement("INSERT INTO tbl_auth (usr, pws, locate) VALUES (?, ?, ?)");
            statement.setString(1, usr.getUsr());
            statement.setString(2, usr.getPws());
            statement.setString(3, usr.getLocate());

            status=statement.executeUpdate();
            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return status;
    }

    public List<User> findall() {
        List<User> users =new ArrayList<>();
        try{
            Connection con= conect.getConnection();
            PreparedStatement statement=con.prepareStatement("select * from tbl_auth ");
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                users.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        }catch(Exception ex){ex.printStackTrace();}
        return users;
    }

}