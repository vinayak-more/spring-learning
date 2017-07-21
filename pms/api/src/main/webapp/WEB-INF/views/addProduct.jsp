<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false"%>
</head>
<body>
	<h3> <s:message code="add.product.title" />  </h3>
	<sf:form method="post" action="add" commandName="product">
		Product ID: <sf:input path="productId" />
		Name: <sf:input path="name" />
		<sf:errors path="name"></sf:errors>
		Product Seller Id: <sf:input path="sellerId" /> 
		Product	Height: <sf:input path="height" />
		<sf:errors path="height"></sf:errors>
		Product	Length: <sf:input path="length" /> 
		Product Width: <sf:input path="width" />  
		Product Price: <sf:input path="price" /> 
		<sf:errors path="price"></sf:errors>
		Product Description: <sf:textarea path="description" />
		<input type="submit" name="Submit" value="Submit" />
	</sf:form>
</body>
</html>