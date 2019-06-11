<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>{} </title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
			<a class="navbar-brand" href="#"></a>
		</div>
		<ul class="nav navbar-nav">
		<li class="active"></li>
<li><a href="login">Login</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
<li><a href="register">Register</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
<li><a href="<c:url value="/productPage"/>">Product</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
<li><a href="<c:url value="/category"/>">Category Management</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
<li><a href="<c:url value="/supplier"/>">Supplier Management</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
<li><a href="<c:url value="/product"/>">Product Management</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
</ul>
</div>
</nav>
</body>
</html>