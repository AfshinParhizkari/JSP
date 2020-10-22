<%@ page import="java.util.List" %>
<%@ page import="com.afshin.Userpas" %>
<%@ page import="com.afshin.Userdao" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="afy" uri="http://Apec459.net" %>
<%--
  Created by IntelliJ IDEA.
  User: afshin
  Date: 10/22/20
  Time: 11:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Show users with jstl</title>
    <afy:header appname="Car Products"/>
</head>
<body>
<%
    Userdao userdao=new Userdao();
    List<Userpas> users = userdao.findall();
    request.setAttribute("userlist",users);
%>
<table border="1" width="90%">
    <tr><th>Id</th><th>Name</th><th>Locale</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach items="${userlist}" var="u">
        <tr><td>${u.id}</td>
            <td>${u.usr}</td>
            <td>${u.locate}</td>
            <td><a href="editform.jsp?id=${u.id}">Edit</a></td>
            <td><a href="deleteuser.jsp?id=${u.id}">Delete</a></td></tr>
    </c:forEach>
</table>
</body>
</html>
