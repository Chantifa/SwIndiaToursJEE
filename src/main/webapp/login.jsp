<%--
  Created by IntelliJ IDEA.
  User: chant
  Date: 04/10/2022
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@page import="ch.swindiatours.model.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
</head>
<body>
    <h3>Login</h3>
    <form method="post" action="LoginServlet">

        <table class="table-bordered">
            <thead>
            <tr>
                <th colspan="2">Login</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Username</td>
                <td><input type="text" name="uname" value="" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" value="" /></td>
            </tr>
            </tbody>
        </table>
        <br>
        <input type="submit" class="btn btn-primary" value="Login" />
        <p> Not Registered? <a href="register.jsp">Register Here</a></p>
<br>
<jsp:include page="foot.jspf"/>
</form>
</body>
</html>
