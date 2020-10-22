
<%@tag body-content="empty" description="Header for all pages" isELIgnored="false" %>
<%@attribute name="appname" required="true" %>

<h4>Welcome to ${appname}. your username is: ${sessionScope.myappsessionsecdata.usr}
    and Your locale is: ${sessionScope.myappsessionsecdata.locate}</h4>
<a href="/Listproduct.html">home</a>
<a href="/Showusers.jsp">users</a>

<hr>
<br>