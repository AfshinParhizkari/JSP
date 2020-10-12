<%--
  Created by IntelliJ IDEA.
  User: afshin
  Date: 10/12/20
  Time: 8:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete product</title>
</head>
<body>

operation result is :
<% Integer reslt= (Integer) request.getAttribute("rowaffected");
    if(reslt > 0){%>
    Success!
<%} else {%>
    Error!
<%}%>
<br><a href='Listproduct.html'>return</a>
</body>
</html>
