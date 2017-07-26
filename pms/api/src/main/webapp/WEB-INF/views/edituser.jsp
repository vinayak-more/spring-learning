<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page session="false"%>
</head>
<body>
	<h3>
		<s:message code="edit.user.title" />
	</h3>
	<sf:form method="post"
		action="${pageContext.request.contextPath}/users/edit"
		commandName="user">
		<sf:hidden path="id" />
		Seller ID: <sf:input path="sellerId" />
		Name: <sf:input path="name" />
		<sf:errors path="name"></sf:errors>
		Contact Number: <sf:input path="contactNumber" />
		<sf:errors path="contactNumber"></sf:errors>
		Address: <sf:textarea path="address" />
		<input type="submit" name="Submit" value="Submit" />
	</sf:form>
</body>
</html>