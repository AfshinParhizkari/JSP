package com.afshin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;

@WebServlet(name = "products", urlPatterns = { "/products" })
public class Contproduct extends HttpServlet {

    private static final long serialVersionUID = 1L;
    final static String tag="<td>%s</td>";
    Daoproduct daoprd = new Daoproduct();

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        /*
         * cookie
         * 
         * //**cookie** :Start check session via cookie*****
         * System.out.println("********Start check session via cookie**********");
         * Boolean iscookievalid = false; if(request.getCookies()!=null) { for(Cookie co
         * : request.getCookies()) { if(co.getName().equals("Jsession")) { String coval
         * = co.getValue(); if(Contlogin.usrmap.containsKey(coval)) { iscookievalid =
         * true; } } } } if(!iscookievalid) { response.sendRedirect("error.html");
         * return; } System.out.println("********session checked via cookie**********");
         * //**cookie** :session checked via cookie*****
         * 
         */

        System.out.println("********Start check session**********");
        Userpas userpas = (Userpas) req.getSession(true).getAttribute("myappsessionsecdata");
        if (userpas == null) {
            res.sendRedirect("error.html");
            return;
        }

        String action = req.getParameter("CRUD");
        System.out.println(action);

        if (action.equals("add")) {
            addproduct(req, res);
        }
        if (action.equals("find")) {
            String[] checked = req.getParameterValues("allrec");
            if (checked == null) {
                try {
                    findallproduct(req, res, " where name like '%" + req.getParameter("findbyid")+"%'");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                if (checked[0].equals("all")) {
                    try {
                        findallproduct(req, res,"");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (action.equals("update")) {
            Product myproduct = new Product();
            myproduct.setId(Integer.parseInt(req.getParameter("id")));
            myproduct.setName(req.getParameter("proname"));
            myproduct.setCountryid(Integer.parseInt(req.getParameter("countryname")));
            // try {
            //     myproduct.setCreatedate(formatter.parse(req.getParameter("createdate")));
            // } catch (ParseException e) {
            //     // TODO Auto-generated catch block
            //     e.printStackTrace();
            //     System.out.println(e.toString());
            // }
            myproduct.setPrice(Float.parseFloat(req.getParameter("price")));
            myproduct.setCount(Integer.parseInt(req.getParameter("count")));
            
            int reslt=daoprd.updateproduct(myproduct);
            PrintWriter out;
            try {
                out = res.getWriter();
                out.write("<html>");
                out.write("<body>");
    
                out.write("<br>operation result is : ");
                if (reslt > 0)
                    out.write("Success!");
                else
                    out.write("Error!");
                out.write("<br><a href='Listproduct.html'>return</a>");
                out.write("</body>");
                out.write("</html>");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        Userpas userpas = (Userpas) req.getSession(true).getAttribute("myappsessionsecdata");
        if (userpas == null) {
            res.sendRedirect("error.html");
            return;
        }
        String action = req.getParameter("CRUD");
        if (action.equals("del")) {
            int reslt=daoprd.deleteproduct(req.getParameter("id"));
            req.setAttribute("rowaffected",reslt);
            req.getRequestDispatcher("/productdelete.jsp").forward(req,res);
        }
        if (action.equals("edit")) {
            Dropdownobjectdao countrydao = new Dropdownobjectdao();
            List<Dropdownobject> dropdownobjectList= countrydao.finddropdown("tbl_country","");
            req.setAttribute("countrys",dropdownobjectList);

            Product product=daoprd.findbyid(req.getParameter("id"));
            req.setAttribute("myproduct",product);
            req.getRequestDispatcher("/productedit.jsp").forward(req,res);
        }
    }

    private void addproduct(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Log method is Save");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        Product myproduct = new Product();
        myproduct.setName(request.getParameter("proname"));
        myproduct.setCountryid(Integer.parseInt(request.getParameter("countryname")));
        try {
            myproduct.setCreatedate(formatter.parse(request.getParameter("createdate")));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.toString());
        }
        myproduct.setPrice(Float.parseFloat(request.getParameter("price")));
        myproduct.setCount(Integer.parseInt(request.getParameter("count")));

        Integer reslt = daoprd.saveproduct(myproduct);

        PrintWriter out;
        try {
            out = response.getWriter();
            out.write("<html>");
            out.write("<body>");

            out.write("<br>operation result is : ");
            if (reslt > 0)
                out.write("Success!");
            else
                out.write("Error!");

            out.write("<br><a href='Listproduct.html'>return</a>");
            // Simple code: just a simple response
            // out.write("<br>Product name: ");
            // out.write(request.getParameter("proname"));

            // out.write("<br>brand: ");
            // out.write(request.getParameter("brnname"));

            // out.write("<br>countryname: ");
            // out.write(request.getParameter("countryname"));

            // out.write("<br>price: ");
            // out.write(request.getParameter("price"));

            out.write("</body>");
            out.write("</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findallproduct(HttpServletRequest request, HttpServletResponse response, String whereclause) throws IOException, ServletException, SQLException
    {
        try {
            ResultSet rs= daoprd.findallproduct(whereclause);
            if(rs!=null)
            {
                request.setAttribute("productrs",rs);
                request.getRequestDispatcher("/productlist.jsp").forward(request,response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
