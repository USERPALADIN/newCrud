<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 12.04.2018
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show all Users</title>
</head>
<body>
<table border=1>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Login</th>
        <th>Password</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.getId}" /></td>
            <td><c:out value="${user.getName}" /></td>
            <td><c:out value="${user.getLogin}" /></td>
            <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${user.dob}" /></td>
            <td><a href="ServletClients?action=edit&userId=<c:out value="${user.userid}"/>">Update</a></td>
            <td><a href="ServletClients?action=delete&userId=<c:out value="${user.userid}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="ServletClients?action=insert">Add User</a></p>
</body>
</html>
