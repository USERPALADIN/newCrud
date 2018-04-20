<%--
  Created by IntelliJ IDEA.
  User: Владелец
  Date: 15.04.2018
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Update user</title>
</head>
<body>

<form method="POST" action='UpdateServlet' name="frmAddUser">
    User ID : <input type="text" readonly="readonly"  name="userId"
                     value="<c:out value="${user.id}" />" /> <br />
     Name : <input
        type="text" name="name"
        value="<c:out value="${user.name}" />" /> <br />
     Login : <input
        type="text" name="login"
        value="<c:out value="${user.login}" />" /> <br />

    Password : <input type="text" name="password"
                   value="<c:out value="${user.password}" />" /> <br />
    <input type="submit" value="Submit" />
</form>
</body>
</html>
