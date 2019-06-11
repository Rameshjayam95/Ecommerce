<%@include file="Header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<script>
function validateForm() {
  var x = document.forms["myForm"]["productName"].value;
  if (x == "") {
    alert("Name must be filled out");
    return false;
  }
}
</script>
</head>
<body>
	<form:form action="InsertProduct" modelAttribute="product" enctype="multipart/form-data" onsubmit="return validateForm()" name="myForm" method="Post">

		<table align="Center">
			<tr>
				<td colspan="2">Product Management</td>
			</tr>
			<tr>
				<td>ProductName</td>
				<td><form:input path="productName" /></td>
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
						<form:option value="0" label=" Select Category " />
						<form:options items="${categoryList}" /></td>
				</form:select>
			</tr>
			<tr>
				<td>Supplier</td>
				<td><form:select path="supplierId">
						<form:option value="0" label=" Select Supplier " />
						<form:options items="${supplierList}" /></td>
			 <tr>
                 <td>Product Image</td>
                 <td><form:input type="file" path="pimage"/></td>
            </tr>			
				</form:select>
			</tr>
			
			<tr>
				<td colspan="2">
					<center>
						<input type="submit" value="Insert Product">
				</td>
			</tr>
			</center>
		</table>
	</form:form>
	<table align="center">
	<tr>
	<td> Product Name</td>
	<td>Product Desc</td>
	<td> Price</td>
	<td>Stock</td>
	<td> CategoryId</td>
	<td>Supplier Id</td>
	</tr>
	<c:forEach items="${productList}" var="product">
	<tr>
	<td>${product.productName}</td>
	<td>${product.productDesc}</td>
	<td>${product.price}</td>
	<td>${product.stock}</td>
	<td>${product.categoryId}</td>
	<td>${product.supplierId}</td>
	<td> <a href="<c:url value="/editproduct/${product.productId}"/>">Edit </a>
	</td>
	<td> <a href="<c:url value="/deleteProduct/${product.productId}"/>">delte </a>
	</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>