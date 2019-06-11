<%@include file="Header.jsp"%>
<html>
<head>
</head>
<body>
	<form action="<c:url value="/UpdateSupplier"/>" method="post">
		<table align="center">
			<tr>
				<td>Supplier Management</td>
			</tr>
			<tr>
				<td>Supplier Id</td>
				<td><input type="text" value="${supplier.supplierId}"readonly name="supplierId"></td>
			</tr>
			
			<tr>
				<td>Supplier Name</td>
				<td><input type="text" value="${supplier.supplierName}" name="supplierName"></td>
			</tr>
			<tr>
				<td>Supplier Address</td>
				<td><input type="text" value="${supplier.suppAddr}" name="suppAddr"></td>
			</tr>
			<tr>
				<td colspan="2">
					<center>
						<input type="submit" value="UpdateSupplier">
				</td>
			</tr>
			</center>
			   
		</table>
	</form>
	</body>