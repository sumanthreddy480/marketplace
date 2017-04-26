<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<h1 style="color:blue">Customer In Market</h1>
	<c:if test="${not empty listCustomer}">
		<table border="1">
			<tr>
				<th>Customer Name</th>
				<th>Customer Data</th>
			</tr>
			<c:forEach items="${listCustomer}" var="customer">
				<tr>
					<td>${customer.getCustomerName()}</td>
					<td>Remove</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<c:if test="${empty listCustomer}">
		<h1>No Customer Found</h1>
	</c:if>
	
</div>
</body>
</html>