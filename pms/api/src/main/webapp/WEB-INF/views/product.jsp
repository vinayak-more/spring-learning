<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
</head>
<body>
	<h2>Product ${product.name}</h2>
	<div>
		<li id="product_<c:out value="product.id"/>"><span
			class="productName"> <c:out value="${product.name}" />
		</span>
			<div>
				<span class="productHeight"><c:out value="${product.height}" /></span>
				<span class="productSellerAndPrice"> (<c:out
						value="${product.sellerId}" />, <c:out value="${product.price}" />)
				</span>
			</div></li>
	</div>
</body>
</html>