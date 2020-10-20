package com.afshin;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Selecttaglib extends Simpletaglib {
    public Selecttaglib() {
    }
    String componentname;
    String tablename;
    String whereclause;

    public String getComponentname() {
        return componentname;
    }

    public void setComponentname(String componentname) {
        this.componentname = componentname;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getWhereclause() {
        return whereclause;
    }

    public void setWhereclause(String whereclause) {
        this.whereclause = whereclause;
    }



    @Override
    public void doTag() throws JspException, IOException {
        List<Dropdownobject> dropdownobjects = new ArrayList<>();
        JspWriter out = getJspContext().getOut();
        Dropdownobjectdao dropdownobjectdao = new Dropdownobjectdao();
        out.println("<select name="+componentname+">");
        dropdownobjects = dropdownobjectdao.finddropdown(tablename,whereclause);
        for (Dropdownobject temp : dropdownobjects) {
            out.println("<option value ="+temp.getValue()+">"+ temp.getLable()+"</option >");
        }
        out.println("</select>");
    }
}