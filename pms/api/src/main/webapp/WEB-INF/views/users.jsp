<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page session="false"%>
</head>
<body>
	<c:if test="${ empty userList}">
	No Users found for giver Search Criteria
	</c:if>
	<c:if test="${ not empty userList}">
		<h3>All Users</h3>
		<table>
			<thead>
				<tr>
					<th>User</th>
					<th>Contact Number</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${userList}" var="user">
					<tr>
						<td><c:out value=" ${user.name}" /></td>
						<td><c:out value=" ${user.contactNumber}" /></td>

					</tr>

				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>