<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.*,java.util.*" %>
<%@taglib prefix="afy" uri="http://Apec459.net" %>
<html>
<head>
<title></title> 
</head>
<% SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy"); %>

//fur futur extention
<!--input id="Vorname" type="text" name="vorname">
<input id="btn" type="button" name="setname"-->

<br>
Dein Vorname und Nachname ist:
<afy:concatination str1="afshin" str2="Parhizkari"/>
<br>
<afy:bodypresent>
    Hello this is body
</afy:bodypresent>
<body>
<h1>Welcome to Tomcat! Today is <%= sdf.format(new Date()) %></h1>
</body>
</html>