<%@include file="Header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
<c:url var="updateUrl" value="/UpdateProduct"/>
	<form:form action="${updateUrl}" modelAttribute="product" method="Post">

		<table align="Center">
			<tr>
				<td colspan="2">Product Management</td>
			</tr>
			<tr>
			<td> Product Id</td>
			<td> <form:input path="productId"/></td>

			<tr>
				<td>ProductName</td>
				<td><form:input path="productName" value="${product.productId}" /></td>
			</tr>

			<tr>
				<td>Product Description</td>
				<td><form:input path="productDesc" /></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td>Stock</td>
				<td><form:input path="stock" /></td>
			</tr>
			<tr>
				<td>category</td>
			<td><form:select path="CategoryId">
						<form:option value="0" label=" Select Category "/>
						<form:options items="${categoryList}"/>
				</form:select></td>
			</tr>
			<tr>
				<td>Supplier</td>
				<td><form:select path="supplierId">
						<form:option value="0" label=" Select Supplier " />
						<form:options items="${supplierList}" /></td>
				</form:select>
			</tr>
			<tr>
				<td colspan="2">
					<center>
						<input type="submit" value="Update Product">
				</td>
			</tr>
			</center>
		</table>
	</form:form>
</body>
</html>