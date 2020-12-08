package com.afshin.lib;

import javax.servlet.jsp.JspException;
import java.io.IOException;
import java.io.StringWriter;

public class Bodytaglib extends Simpletaglib {

    StringWriter sw = new StringWriter();
    @Override
    public void doTag() throws JspException, IOException {
        getJspBody().invoke(sw);
        getJspContext().getOut().println(sw.toString());
    }
}
