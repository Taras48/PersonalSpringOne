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
</p>
<c:if test="${list.size() > 0}">
    <table>
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Message</td>
        </tr>
        <c:forEach var="user" items="list">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getName()}</td>
                <td>${user.getMessage()}</td>
            </tr>

        </c:forEach>
    </table>
</c:if>
<c:if test="${list.size() == 0}">
    <c:out value="${var}" default="Table is emty!"/>
    <%--<h3>Table is empty</h3>--%>
</c:if>
</body>
</html>
