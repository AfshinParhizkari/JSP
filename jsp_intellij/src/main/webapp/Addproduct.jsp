<%@taglib prefix="afy" uri="http://Apec459.net" %>
<html>
    <head><title style="text-align: center;">servlet_webapp_vscode_j2ee : from scratch servlet</title></head>
    <body>
        <form action="products" method="POST">
            <br>
        <label for="hname">Product name: </label>
        <input id="hname" name="proname" type="text"> <br><br>

        <!--label for="hcountryname">countryname: </label>
        <input id="hcountryname" name="countryname" type="text"-->
        countryname: <afy:select componentname="countryname" tablename="tbl_country"/><br><br>

        <label for="hcount">count: </label>
        <input id="hcount" name="count" type="number"> <br><br>

        <label for="hprice">Price: </label>
        <input id="hprice" name="price" type="number"> <br><br>

        <label for="hcreatedate">createdate: </label>
        <input id="hcreatedate" name="createdate" type="date"> <br><br>

        <input type="hidden" name="CRUD" value="add">

        <input type="submit" value="Add New Product">
    </form>
    </body>
</html>