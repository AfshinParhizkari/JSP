package com.afshin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Dropdownobjectdao {

    private  Connection2db conect =new Connection2db();

    public List<Dropdownobject> finddropdown(String tableName, String whereClause) {
        ResultSet rs = null;
        List<Dropdownobject> dropdownobjects=new ArrayList<>();
        if(whereClause==null) whereClause="";
        try{
            Connection con= conect.getConnection();
            PreparedStatement statement=con.prepareStatement("select * from "+ tableName+" "+whereClause);
            rs = statement.executeQuery();
            while(rs.next())
            {
                dropdownobjects.add(new Dropdownobject(rs.getInt(1),rs.getString(2)));
            }
        }catch(Exception ex){ex.printStackTrace();}
        return dropdownobjects;
    }
}
