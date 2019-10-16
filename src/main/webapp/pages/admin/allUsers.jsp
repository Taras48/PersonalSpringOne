<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Users</title>
</head>
<body>
<h1>All Users</h1>
<p><a href="/add">Add Users</a> |
    <a href="/update">Update Users</a> |
    <a href="/delete">Delete Users</a> |
    <a href="/user">User psge</a> |
</p>
<c:if test="${list.size() > 0}">
    <table border="1px solid black">
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Password</td>
            <td>Message</td>
            <td>Role</td>
        </tr>
        <c:forEach var="user" items="${list}">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getName()}</td>
                <td>${user.getPassword()}</td>
                <td>${user.getMessage()}</td>
                <td>${user.getRoles()}</td>
            </tr>

        </c:forEach>
    </table>
</c:if>
<c:if test="${list.size() == 0}">
      <h3>Table is empty</h3>
</c:if>
</body>
</html>
