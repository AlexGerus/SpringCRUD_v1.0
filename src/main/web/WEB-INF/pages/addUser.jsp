<%--
  Created by IntelliJ IDEA.
  User: 1999g
  Date: 27.11.2018
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute = "userAttribute" method="post" >
    <table>
        <tr>
            <td><form:label path="name">Name:</form:label></td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td><form:label path="age">Age:</form:label></td>
            <td><form:input path="age" /></td>
        </tr>
        <tr>
            <td><form:label path="login">Login:</form:label> </td>
            <td><form:input path="login" /></td>
        </tr>
        <tr>
            <td><form:label path="password">Password:</form:label> </td>
            <td><form:input path="password"/></td>
        </tr>
        <tr>
            <td><form:label path="role">Role:</form:label></td>
            <td><form:input path="role"/></td>
        </tr>
    </table>
    <input type="submit" value="Добавить">
</form:form>
</body>
</html>
