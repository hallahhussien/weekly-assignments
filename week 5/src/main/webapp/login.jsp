<%--
  Created by IntelliJ IDEA.
  User: paulawaite
  Date: 9/20/15
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h3>Please enter your userid and password below.</h3>
<form action="j_security_check" method="post">
    Email: <input type="text" name="j_username"><br />
    Password:  <input type="password" name="j_password"><br />
    <input type="submit" value="login">
</form>
</body>


