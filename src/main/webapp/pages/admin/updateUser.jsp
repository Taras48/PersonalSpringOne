<%--
  Created by IntelliJ IDEA.
  User: TARAZ
  Date: 09.10.2019
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UpdateUser</title>
</head>
<body>
<h1>Update User</h1>
<p><a href="/">All Users</a> |
    <a href="/add">add Users</a> |
    <a href="/delete">Delete Users</a> |
    <a href="/user">User psge</a> |
</p>
<form action="/update" method="post">
    ID:<input type="number" name="id">
    Name:<input type="text" name="name">
    Role:<input type="text" name="role">
    Message:<input type="text" name="message"><br/><br/>
    <button>Update user</button>
</form>

</body>
</html>
