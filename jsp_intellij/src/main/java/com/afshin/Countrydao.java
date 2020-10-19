package com.afshin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Countrydao {

    private  Connection2db conect =new Connection2db();

    public List<Country> findcountry(String whereClause) {
        ResultSet rs = null;
        List<Country> countryLst=new ArrayList<>();
        //Country tempcountry=new Country();
        try{
            Connection con= conect.getConnection();
            PreparedStatement statement=con.prepareStatement("select * from tbl_country "+whereClause);
            rs = statement.executeQuery();
            while(rs.next())
            {
                //tempcountry.setCountryId(rs.getInt("countryid"));
                //tempcountry.setCountryName(rs.getString("countryname"));
                countryLst.add(new Country(rs.getInt("countryid"),rs.getString("countryname")));
            }
        }catch(Exception ex){ex.printStackTrace();}
        return countryLst;
    }
}
