package com.afshin;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Selecttaglib extends Simpletaglib {


    @Override
    public void doTag() throws JspException, IOException {
        List<Country> countryList = new ArrayList<>();
        JspWriter out = getJspContext().getOut();
        Countrydao countrydao = new Countrydao();
        out.println("<select name='countryname'>");
        countryList = countrydao.findcountry("");
        for (Country tempcountry : countryList) {
            out.println("<option value ="+tempcountry.getCountryId()+">"+ tempcountry.getCountryName()+"</option >");
        }
        out.println("</select>");
    }
}