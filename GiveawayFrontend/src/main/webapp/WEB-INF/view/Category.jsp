<%@include file="Header.jsp"%>
<html>
<head>
<script>
function validateForm() {
  var x = document.forms["myForm"]["CategoryNames"].value;
  if (x == "") {
    alert("Name must be filled out");
    return false;
  }
}
</script>
</head>
<body>

	<form name="myForm" action="<c:url value="/InsertCategory"/>" onsubmit="return validateForm()" method="post">
		<table align="Center">
			<tr>
				<td colspan="2">Category Management</td>
			</tr>
			
			<tr>
				<td>Category Name</td>
				<td><input type="text" name="CategoryNames"></td>
			</tr>
			
			<tr>
				<td>Category Desc</td>
				<td><input type="text" name="CategoryDesc"></td>
			</tr>
			<tr>
				<td colspan="2">
			<center>
				<input type="submit" value="Insert Category">
			</center>
			</tr>
		</table>
	</form>


	<br>
	<br />

	<table align="center">
		<tr>
			<td>SL#</td>
			<td>CategoryName</td>
			<td>CategoryDesc</td>
		</tr>

		<c:forEach items="${categoryList}" var="category">
			<tr>
				<td>${category.categoryId}</td>
				<td>${category.categoryNames}</td/>
				<td>${category.categoryDesc}</td>
				<td><a
					href="<c:url value="/editCategory/${category.categoryId}"/>">Edit</a>
				</td>

				<td><a
					href="<c:url value="/deleteCategory/${category.categoryId}"/>">delete</a>
				</td>
		</c:forEach>
		</tr>
	</table>
</body>
</html>