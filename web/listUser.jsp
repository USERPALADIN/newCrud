<%@ page import="tables.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Владелец
  Date: 15.04.2018
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Show All Users</title>
</head>
<body>
<table border=1>
    <thead>
    <tr>
        <th>User Id</th>
        <th>Name</th>
        <th>Login</th>
        <th>Password</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.id}" /></td>
            <td><c:out value="${user.name}" /></td>
            <td><c:out value="${user.login}" /></td>
            <td><c:out value="${user.password}" /></td>
            <td><a href="UpdateServlet?userId=<c:out value="${user.id}"/>">Update</a></td>
            <td><a href="DeleteServlet?userId=<c:out value="${user.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="UpdateServlet">Add User</a></p>
</body>
</html>