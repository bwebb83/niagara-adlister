<%--
  Created by IntelliJ IDEA.
  User: Brian
  Date: 1/30/17
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%@ include file="partials/navbar.jsp" %>
<h1>Login</h1>

<form method="post" action="/login">
<input type="text" id="username" name="username" placeholder="Enter your username">
<br>
<input type="text" id="password" name="password" placeholder="Enter your password">

<br>
<input type="submit">
    </form>

</body>
</html>
