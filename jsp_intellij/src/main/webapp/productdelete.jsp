<%--
  Created by IntelliJ IDEA.
  User: afshin
  Date: 10/12/20
  Time: 8:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="afy" uri="http://Apec459.net" %>

<html>
<head>
    <title>Delete product</title>
    <afy:header appname="Car Product"/>

</head>
<body>

operation result is :
<% Integer reslt= (Integer) request.getAttribute("rowaffected");
    if(reslt > 0){%>
    Success!
<%} else {%>
    Error!
<%}%>
<br><a href='FirstPage.html'>return</a>
</body>
</html>
