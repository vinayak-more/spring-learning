<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
</head>
<body>
	<h2>
		<c:out value="${spittle.message}"></c:out>
	</h2>
	<div>
		date:
		<c:out value="${spittle.time}"></c:out>
	</div>

</body>
</html>