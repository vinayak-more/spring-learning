<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
</head>
<body>
	<c:if test="${not empty  productList}">
		<h2>Products found</h2>
	</c:if>
	<div>
		<c:if test="${empty  productList}">
		Sorry No Products found for given Criteria.
	</c:if>
		<c:forEach items="${productList}" var="product">
			<li id="product_<c:out value="product.id"/>"><span
				class="productName"> <c:out value="${product.name}" />
			</span>
				<div>
					<span class="productHeight"><c:out value="${product.height}" /></span>
					<span class="productSellerAndPrice"> (<c:out
							value="${product.sellerId}" />, <c:out value="${product.price}" />)
					</span>
				</div></li>
		</c:forEach>
	</div>
</body>
</html>