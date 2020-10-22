
<%@tag body-content="empty" description="Header for all pages" isELIgnored="false" %>
<%@attribute name="appname" required="true" %>

<h4>Welcome to ${appname}. your username is: ${sessionScope.myappsessionsecdata.usr}
    and Your locale is: ${sessionScope.myappsessionsecdata.locate}</h4>

<hr>
<br>