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
<form:form modelAttribute="userAttribute">
    <table >
        <tr>
            <td>Name : </td>
            <td><form:input path="name"  /></td>
        </tr>
        <tr>
            <td>Age :</td>
            <td><form:input path="age" /></td>
        </tr>
        <tr>
            <td>Login :</td>
            <td><form:input path="login" /></td>
        </tr>
        <tr>
            <td>Password :</td>
            <td><form:input path="password" /></td>
        </tr>
        <tr>
            <form:form modelAttribute="roleAttribute">
                <table>
                    <tr>
                        <td>Role :</td>
                        <td><form:input path="nameRole" /></td>
                    </tr>

                    <tr>
                        <td><input type="submit" value="Save" /></td>
                    </tr>
                </table>
            </form:form>
        </tr>
    </table>
</form:form>

</body>
</html>
