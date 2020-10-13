package com.afshin;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class Simpletaglib extends SimpleTagSupport {
    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    String str1;
    String str2;
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter wrt = getJspContext().getOut();
        wrt.println(str1+" "+str2);
    }
}
