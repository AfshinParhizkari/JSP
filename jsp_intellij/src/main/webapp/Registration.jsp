<%--
  Created by IntelliJ IDEA.
  User: afshin
  Date: 10/22/20
  Time: 10:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form action="welcome" method="POST">
    <br>
    <label for="Username">username: </label>
    <input id="Username" name="username" type="text"> <br><br>

    <label for="Password">Password: </label>
    <input id="Password" name="password" type="password"> <br><br>

    <label for="Locale">locale: </label>
    <input id="Locale" name="locale" type="text"> <br><br>

    <input type="hidden" name="distinct" value="reg">

    <input type="submit" value="Add New User">
</form>
</body>
</html>
