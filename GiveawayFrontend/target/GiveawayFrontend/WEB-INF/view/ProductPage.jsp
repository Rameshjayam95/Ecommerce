<%@include file="/WEB-INF/view/Header.jsp"%>
<html>
<head>
</head>
<body>
<div class="row text-center text-lg-left">
<c:forEach items="${productList}" var="product">
<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
<c:if test="${product.stock>0}">
<a href="<c:url value="/totalProductDisplay/${product.productId}"/>" class="d-block mb-4 h-100">
</c:if>
<img class="img-fluid img-thumbnail" src="<c:url value="/resources/images/${product.productId}.jpg"/>">
</a>
<p>Price : ${product.price}/-</p>
<p>Stock : <c:if test="${product.stock > 0}">${product.stock}</c:if>
           <c:if test="${product.stock <= 0}">
           <font color="red">out of stock</font>
           </c:if>	
           </p>
           <p><h4>${product.productName}</h4></p>
           
</div>
</c:forEach>
</div>
</body>
</html>