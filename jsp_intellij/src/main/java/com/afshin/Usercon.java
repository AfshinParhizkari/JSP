package com.afshin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

//import java.lang.ProcessBuilder.Redirect;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name="welcome",urlPatterns = {"/welcome"})
public class Usercon extends HttpServlet
{
    private static final long serialVersionUID = 2L;
    protected static Map<String, User> usrmap =new ConcurrentHashMap<>();
    
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
       
        //rd.forward(request, response);
        Userdao dl=new Userdao();
        User welcomeuser = new User();
        String action=request.getParameter("distinct");
        if(action.equals("log")) {

            welcomeuser = dl.getusr(request.getParameter("username"));

            if (welcomeuser.getUsr().equals(request.getParameter("username")) &&
                    welcomeuser.getPws().equals(request.getParameter("password"))) {
                    /*  in cookie way

                    //**cookie** :Start create session mgmnt via cookie*****
                    System.out.println("**Start create session mgmnt via cookie*****");
                    String random =UUID.randomUUID().toString();
                    //servlet: Hotel room lock
                    usrmap.put(random, welcomeuser);
                    //client: key card
                    Cookie cookie = new Cookie("mycookieid",random);
                    cookie.setMaxAge(-1);
                    //reception give key to client
                    response.addCookie(cookie);
                    System.out.println("**session is created via cookie*****");
                    //**cookie** :session is created via cookie
                    */
                HttpSession session = request.getSession(true);
                session.setAttribute("myappsessionsecdata", welcomeuser);

                response.sendRedirect("FirstPage.html");
            } else {
                response.sendRedirect("error.html");
            }
        }
        else{
            welcomeuser.setUsr(request.getParameter("username"));
            welcomeuser.setPws(request.getParameter("password"));
            welcomeuser.setLocate(request.getParameter("locale"));
            int reslt = dl.adduser(welcomeuser);
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
                out.write("<br><a href='FirstPage.html'>return</a>");
                out.write("</body>");
                out.write("</html>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException
        {
            /* cookie logout

            //**Cookie : Logout
            System.out.println("**Cookie : Logout");
            if(request.getCookies()!=null)
            {
                for(Cookie co : request.getCookies())
                {
                    if(co.getName().equals("mycookieid"))
                    {
                        co.setMaxAge(0);
                        response.addCookie(co);
                    }
                }
            }
            System.out.println("**Cookie : is Logout");
            //**Cookie : Logout
            */

        request.getSession(true).invalidate();
        response.sendRedirect("login.html");
        System.out.println("Get method: logout");
        }


}