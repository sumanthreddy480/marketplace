<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Market Home</title>

<style>
	input {
 margin: 40px 25px;
 width: 200px;
 display: block;
 border: none;
 padding: 10px 0;
 border-bottom: solid 1px #1abc9c;
 -webkit-transition: all 0.3s cubic-bezier(0.64, 0.09, 0.08, 1);
 transition: all 0.3s cubic-bezier(0.64, 0.09, 0.08, 1);
 background: -webkit-linear-gradient(top, rgba(255, 255, 255, 0) 96%, #1abc9c 4%);
 background: linear-gradient(to bottom, rgba(255, 255, 255, 0) 96%, #1abc9c 4%);
 background-position: -200px 0;
 background-size: 200px 100%;
 background-repeat: no-repeat;
 color: #0e6252;
}

input:focus,
  input:valid {
  box-shadow: none;
  outline: none;
  background-position: 0 0;
}

input::-webkit-input-placeholder {
  font-family: 'roboto', sans-serif;
  -webkit-transition: all 0.3s ease-in-out;
  transition: all 0.3s ease-in-out;
}

input:focus::-webkit-input-placeholder,
  input:valid::-webkit-input-placeholder {
  color: #1abc9c;
  font-size: 11px;
  -webkit-transform: translateY(-20px);
  transform: translateY(-20px);
  visibility: visible !important;
}
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript" src="styles/js/canvasjs.min.js"></script>
<script type="text/javascript" src="styles/js/shoptv.js"></script>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- Custom Fonts -->
<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">

<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">

</head>
<body>
	<h1>Welcome to Market</h1>
	
	<div align="right"> 
		<form action="/searchcustomer" method="post">
			<input type="text" name="customerName" placeholder="Search" required> 
			<input type="submit" name="search" value="Search"> 
		</form>
	</div>
	
	<div>
		<form action="/addproduct" method="post" name="marketform">
			<input placeholder="Customer Name" type="text" name="customerName" required> 
			<input placeholder="Product Name" type="text" name="productName" required>
			<input placeholder="Price" type="text" name="productPrice" required>
			<input type="submit" name="AddItem" value="Add Item"> 
		</form>
	</div>
	
	<div align="center">
	<h1 style="color:blue">Items In Market</h1>
	<c:if test="${not empty productList}">
		<table border="1">
			<tr>
				<th>ProductId</th>
				<th>Product</th>
				<th>Price</th>
				<th>Remove</th>
			</tr>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.getProductId()}</td>
					<td>${product.getProductName()}</td>
					<td>${product.getProductPrice()}</td>
					<td>Remove</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<c:if test="${empty productList}">
		<h1>No Products To Show</h1>
	</c:if>
	
</div>
	
</body>
</html>