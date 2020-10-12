<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: afshin
  Date: 10/12/20
  Time: 6:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>diese sind meine producte</title>
</head>
<body>
<a href='Addproduct.html'>Add new Product</a>
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
        <td>createdate</td>
        <td>Delete</td>
        <td>Edit</td>
    </tr>
    <% ResultSet rs= (ResultSet) request.getAttribute("productrs");
       while (rs.next())
       {
    %>
    <tr>
    <td><%=rs.getString(1)%></td>
    <td><%=rs.getString(2)%></td>
    <td><%=rs.getString(3)%></td>
    <td><%=rs.getString(4)%></td>
    <td><%=rs.getString(5)%></td>
    <td><%=rs.getString(6)%></td>
    <td><a href="<%=application.getContextPath()%>/products?CRUD=del&id=<%=rs.getInt(1)%>">delete</a></td>
    <td><a href="<%=application.getContextPath()%>/products?CRUD=edit&id=<%=rs.getInt(1)%>">edit</a></td>
    </tr>
    <%}%>
</table>

</body>
</html>
