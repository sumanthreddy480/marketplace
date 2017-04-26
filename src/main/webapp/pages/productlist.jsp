<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.market.objects.StaticVariables" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Market Item List</title>

<script type="text/javascript">

function doBack(){

	document.itemlistform.action = "<%=StaticVariables.jspPath%>/market";
	document.itemlistform.method = "GET";
	document.itemlistform.submit();

	}
</script>

</head>
<body>
<form action="<%=StaticVariables.jspPath%>/market" name="itemlistform" method="post">

<div align="center">
	<h1 style="color:blue">Items In Market</h1>
	<c:if test="${not empty productList}">
		<table border="1">
			<tr>
				<th>ProductId</th>
				<th>Product</th>
				<th>Price</th>
			</tr>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.getProductId()}</td>
					<td>${product.getProductName()}</td>
					<td>${product.getProductPrice()}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<c:if test="${empty productList}">
		<h1>No Products To Show</h1>
	</c:if>
	
	<a href="javascript:void(0);" onclick="javascript:doBack();" class="btn btn-primary">Add More Items </a> 
</div>	
</form>
</body>
</html>