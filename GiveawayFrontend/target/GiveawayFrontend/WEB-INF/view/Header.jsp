<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>{} </title>
</head>
<body>
<a href="login">Login</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="register">Register</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="<c:url value="/category"/>">Category Management</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="<c:url value="/supplier"/>">Supplier Management</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="<c:url value="/product"/>">Product Management</a>&nbsp;&nbsp;&nbsp;&nbsp;
</body>
</html>