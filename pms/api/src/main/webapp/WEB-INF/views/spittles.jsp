<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page session="false" %>
</head>
<body>
<h2>Recent Spittles</h2>
	<div>
		<c:forEach items="${spittleList}" var="spittle">
			<li id="spittle_<c:out value="spittle.id"/>">
				<span class="spittleMessage">
					<c:out value="${spittle.message}" />
				</span>
				<div>
					<span class="spittleTime"><c:out value="${spittle.time}" /></span>
					<span class="spittleLocation"> (<c:out value="${spittle.latitude}" />, 
							<c:out value="${spittle.longitude}" />)
					</span>
				</div>
			</li>
		</c:forEach>
	</div>
</body>
</html>