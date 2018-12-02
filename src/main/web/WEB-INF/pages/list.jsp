<%--
  Created by IntelliJ IDEA.
  User: 1999g
  Date: 27.11.2018
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <table>
        <tbody>
        <tr>
            <th>id</th><th>Name</th><th>age</th>
        </tr>
        <c:forEach var = "user" items="${list}"  >
            <tr>
                <td> ${user.id} </td>
                <td><c:out value="${user.name}" /></td>
                <td><c:out value="${user.age}" /></td>
                <td>
                    <form action="/changeUser">
                <td><input type="hidden" name="idChange" value="${user.id}"></td>
                <td><input type="hidden" name="nameChange" value="${user.name}"></td>
                <td><input type="hidden" name="ageChange" value="${user.age}"></td>
                <td><input type="hidden" name="loginChange" value="${user.login}"></td>
                <td><input type="hidden" name="passwordChange" value="${user.password}"></td>
                <td><input type="submit" value="Изменить пользователя"></td>
                </form>
                </td>
                <td> <form action="/removeUser">
                <td><input type="hidden" name="id" value="${user.id}"> </td>
                <td><input type="submit" value="Удалить пользователя"> </td>
                </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form action="/addUser" >
        <input type="submit" value="Добавить пользователя">

    </form>
    <form action="/logout" method="post">
        <input type="submit" value="Выйти">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>

    <form action="/" method="post">
        <input type="submit" value="Назад">
    </form>
</div>

</body>
</html>
