<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Authorization</title>
</head>
<body>

<form method="POST" action='authorization' name="frmAddUser">
    <table border="1">
        <tr>
            <td>
                Login : <input
                    type="text" name="login"
                    value="<c:out value="${user.login}" />"/> <br/></td>
        </tr>
        <tr>
            <td>
                Password : <input type="text" name="password"
                                  value="<c:out value="${user.password}" />"/> <br/></td>
        </tr>
    </table>
    <input type="submit" value="Log in"/>
</form>
<a href="insert_user">Sign in</a>
</body>
</html>