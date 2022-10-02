<%--
  Created by IntelliJ IDEA.
  User: chant
  Date: 10/09/2022
  Time: 08:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>SwIndia Tours</title>
    <link rel="shortcut icon" href="resources/img/logo.png">
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
<header>
    <hgroup>
        <h1 class="title">SwIndia Tours by Gihara</h1>
    </hgroup>
    <nav>
        <ul>
            <li><a href="index.jsp"><%= "home" %><%!
                private Object register;
            %>
            </a></li>
            <li><a href="register.jsp"><%= "register" %>
            </a></li>
        </ul>
    </nav>
</header>
<form action="register" method="post">
    <fieldset>
        <legend><% register %></legend>
        <table>
            <tbody>
            <tr>
                <th>
                    <%--@declare id="email"--%><label for="email"><%email:%></label>
                </th>
            </tr>
            <tr>
                <td>
                    <input type="email"
                           name="email"
                           size="40"
                           maxlength="40"
                           title="muster@example.com"
                           placeholder="pls enter your email"
                           pattern=".{6,40}"
                           required="required">
                </td>
            </tr>
            <tr>
                <th>
                    <%--@declare id="password"--%><label for="password"><%password:%></label>
                </th>
            </tr>
            <tr>
                <td>
                    <input type="password"
                           name="password"
                           size="10"
                           maxlength="10"
                           title="6-10 signals"
                           placeholder="pls enter your password"
                           pattern=".{6,10}"
                           required="required">
                </td>
            </tr>
            <tr>
                <td>
                </td>
                <td>
                    <input type="submit">
                    <input type="reset">
                </td>
            </tr>
            </tbody>
        </table>
    </fieldset>
</form>
</body>
</html>