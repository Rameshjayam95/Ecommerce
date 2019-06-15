<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<%@include file="/WEB-INF/view/Header.jsp"%>
<html>
<head>
<div class="container-fluid">
    <div class="content-wrapper">	
		<div class="item-container">	
			<div class="container">	
				<div class="col-md-12">
							<form action="<c:url value="/addToCart/${product.productId}"/>" method="post">
					<div class="product col-md-3 service-image-left">
						
							<img id="item-display" src="<c:url value="/resources/images/${product.productId}.jpg"/>" alt=""></img>
						
					</div>
					</div>
					<div>
				
				<div class="col-md-8 pull-left">
	
                
					<div class="product-title">${product.productName}</div>
					<div class="product-desc">${product.productDesc}</div>
					<hr>
					<div class="product-price">${product.price}</div>
					<div class="product-stock">In Stock</div>
					<hr>
					<div class="btn-group cart">
						<input type="submit" value="Add to cart" class="btn btn-success">
							
					</div>
					
				
					</div>
					</form>
				</div>
				
			 
		</div>
		
		</div>
		</div>
		
</head>
</html>