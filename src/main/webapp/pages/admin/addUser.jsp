<%--
  Created by IntelliJ IDEA.
  User: TARAZ
  Date: 09.10.2019
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddUser</title>
</head>
<body>
<h1>Add User</h1>
<p><a href="/admin">All Users</a> |
    <a href="/admin/update">Update Users</a> |
    <a href="/admin/delete">Delete Users</a> |
    <a href="/helloUser">User psge</a> |
    <a href="/logout">logout</a>
</p>
<form action="/admin/add" method="post">
    Name:<input type="text" name="name">
    Password:<input type="text" name="password">
    Role:<select name="role" required>
    <option value="user">user</option>
    <option value="admin">admin</option>
</select>
    Message:<input type="text" name="message"><br/><br/>
    <button>Add user</button>
</form>

</body>
</html>
