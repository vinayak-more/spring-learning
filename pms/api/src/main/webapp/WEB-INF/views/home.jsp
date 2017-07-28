<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<title>OMS</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
</head>
<body>
	<h1>Welcome to OMS</h1>
	<a href="<c:url value="/products" />">Products</a> |
	<a href="<c:url value="/users" />">Users</a>
</body>
</html>