<%--
  Created by IntelliJ IDEA.
  User: chant
  Date: 10/09/2022
  Time: 08:01
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@include file="header.jspf"%>
<%@page import="ch.swindiatours.model.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register</title>

</head>
<body>
    <h3>Register</h3>
    <form method="POST" action="register">
        <fieldset>
            <legend>Register</legend>
        <table class="table-bordered">
            <tbody>
            <tr>
                <th>
                    <td>
                <input type="name" name="firstname" size="40" maxlength="40" title="John" placeholder="your firstname"
                required="required">
            </td>
                </th>
            </tr>
            <tr>
                <th>
                    <td>
                <input type="name" name="name" size="40" maxlength="40" title="Muster" placeholder="your lastname">
            </td>
                </th>
            </tr>
            <tr>
                <th colspan="2">
                <%--@declare id="email"--%><label for="email">e-mail:</label>
                </th>
            <td><input type="email" name="email" size="40" maxlength="40" title="muster@example.ch" placeholder="enter your email"
            pattern=".{6,40}" required="required">
            </td>
            </tr>
            <tr>
                <th>
                    <%--@declare id="password"--%><label for="password">password</label>
                </th>
                <td>
                    <input type="password" name="password" size="10" maxlength="10" title="6-10 characters" placeholder="please enter your password"
                    pattern=".{6,10}" required="required">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" class="btn btn-success" value="Register" />
                    <input type="reset">
                </td>
            </tr>
            </tbody>
        </table>
        <br>
        <p>Already registered? <a href="login.jsp">Login Here</a><p/>
<br>
        </fieldset>
</form>
    <%@ include  file="foot.jspf"%>

</body>
</html>
