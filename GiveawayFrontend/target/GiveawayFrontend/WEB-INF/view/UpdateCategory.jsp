<%@include file="Header.jsp"%>
<html>
<head>
</head>
<body>
	<form action="<c:url value="/UpdateCategory"/>" method="post">
		<table align="Center">
			<tr>
				<td colspan="2">Category Management</td>
			</tr>
			
			<tr>
				<td><input type="hidden" name="CategoryId" value="${category.categoryId}" readonly></td>
			</tr>

			<tr>
				<td>Category Name</td>
				<td><input type="text" name="CategoryNames" value="${category.categoryNames}"></td>
			</tr>

			<tr>
				<td>Category Desc</td>
				<td><input type="text" name="CategoryDesc" value="${category.categoryDesc}"></td>
			</tr>

			<tr>
				<td colspan="2">
					<center>
						<input type="submit" value="Update Category">
				</td>
			</tr>

			</center>
		</table>
	</form>
</body>
</html>



