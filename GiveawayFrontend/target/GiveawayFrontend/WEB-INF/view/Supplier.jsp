<%@include file="Header.jsp"%>
<html>
<head>
<script>
function validateForm() {
  var x = document.forms["myForm"]["supplierName"].value;
  if (x == "") {
    alert("Name must be filled out");
    return false;
  }
}
</script>
</head>
<body>
	<form action="<c:url value="/InsertSupplier"/>" name="myForm" onsubmit="return validateForm()" method="post">
		<table align="center">
			<tr>
				<td>Supplier Management</td>
			</tr>
			<tr>
				<td>Supplier Name</td>
				<td><input type="text" name="supplierName"></td>
			</tr>
			<tr>
				<td>Supplier Address</td>
				<td><input type="text" name="suppAddr"></td>
			</tr>
			<tr>
				<td colspan="2">
					<center>
						<input type="submit" value="InsertSupplier">
				</td>
			</tr>
			</center>
			   
		</table>
	</form>
	<br>
	</br>
	<table align="center">
	<tr>
	<td>SL#</td>
			<td>SupplierName</td>
			<td>Supplier Address</td>
		</tr>
		<c:forEach items="${supplierList}" var="supplier">
		<tr>
		<td>${supplier.supplierId}</td>
		<td>${supplier.supplierName}</td>
		<td>${supplier.suppAddr}</td>
		<td> <a href="<c:url value="/editSupplier/${supplier.supplierId}"/>">Edit</a> 
		</td>
		<td> <a href="<c:url value="/deleteSupplier/${supplier.supplierId}"/>">delete</a>
		</td>
		</c:forEach>
		</tr>
	</table>
</body>
</html>