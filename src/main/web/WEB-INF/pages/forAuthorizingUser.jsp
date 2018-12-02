<%--
  Created by IntelliJ IDEA.
  User: 1999g
  Date: 27.11.2018
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Привет!

<form action="/logout" method="post">
    <input type="submit" value="Выйти">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>

<form action="/" method="post">
    <input type="submit" value="Назад">
</form>
</body>
</html>
