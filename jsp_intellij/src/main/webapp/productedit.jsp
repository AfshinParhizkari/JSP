<%@ page import="com.afshin.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.afshin.Country" %><%--
  Created by IntelliJ IDEA.
  User: afshin
  Date: 10/12/20
  Time: 8:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit product</title>
</head>
<body>
<%Product pro= (Product) request.getAttribute("myproduct"); %>
<form action='products' method='POST'><br>
    Product ID: <%=pro.getId()%> <br><br>
    <input type='hidden' name='id' value=<%=pro.getId()%>> <br><br>
    Product name: <input name='proname' type='text' value="<%=pro.getName()%>"> <br><br>
    countryname : <select  name="countryname">
        <%
            List<Country> countryList = (List<Country>) request.getAttribute("countrys");
            for(Country tempcountry : countryList)
            {
                if(pro.getCountryid()==tempcountry.getCountryId())
                {
        %>
        <option  selected=<%=tempcountry.getCountryName()%>  value=<%=tempcountry.getCountryId()%>><%=tempcountry.getCountryName()%></option>
        <%     }
        else{
        %>
        <option value=<%=tempcountry.getCountryId()%>><%=tempcountry.getCountryName()%></option>
        <%}
        }
        %>
    </select><br><br>

    count:<input id='hcount' name='count' type='number' value="<%=pro.getCount()%>"> <br><br>
    Price:<input id='hprice' name='price' type='number' value="<%=pro.getPrice()%>"> <br><br>
    //out.write(String.format(tag, "Createdate: <input id='hcreatedate' name='createdate' type='date'> <br><br>
    <input type='hidden' name='CRUD' value='update'>
    <input type='submit' value='Update Product'>
</form>

</body>
</html>
