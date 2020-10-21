<%--
  Created by IntelliJ IDEA.
  User: afshin
  Date: 10/12/20
  Time: 6:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="afy" uri="http://Apec459.net" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>diese sind meine producte</title>
</head>
<body>
<a href='Addproduct.jsp'>Add new Product</a>
<form action='welcome' method='GET'>
    <input type='submit' value='logout'> <br></br>
</form>

<form action='products' method='POST'>
    find product by name:<input type='text' name='findbyid'></br>
    <input type='checkbox' name='allrec' value='all'>AllRecords</input></br>
    <input type='hidden' name='CRUD' value='find'>
    <input type='submit' name='Find Product'></br>
    <label></label>
</form>

<table>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>countryid</td>
        <td>count</td>
        <td>price</td>
        <td>Total</td>
        <td>createdate</td>
        <td>Delete</td>
        <td>Edit</td>
    </tr>
    <% ResultSet rs= (ResultSet) request.getAttribute("productrs");

       while (rs.next())
       {
           pageContext.setAttribute("count",rs.getInt(4));
           pageContext.setAttribute("price",rs.getInt(5));
           pageContext.setAttribute("createdate",rs.getDate(6));
    %>
    <tr>

    <td><%=rs.getInt(1)%></td>
    <td><%=rs.getString(2)%></td>
    <td><%=rs.getInt(3)%></td>
    <td><%=rs.getInt(4)%></td>
    <td><%=rs.getFloat(5)%></td>

    <!--customTag function-->
    <td>${afy:multiple(count,price)}</td>
    <td>${afy:conver2persian(createdate)}</td>

    <td><a href="<%=application.getContextPath()%>/products?CRUD=del&id=<%=rs.getInt(1)%>">delete</a></td>
    <td><a href="<%=application.getContextPath()%>/products?CRUD=edit&id=<%=rs.getInt(1)%>">edit</a></td>
    </tr>
    <%}%>
</table>
</body>
</html>