<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table, th, td {
	border: 1px solid;
}
</style>
<script>
	function confirmation() {
		var result = confirm("Are you sure you want to delete?");
		if (result) {
			console.log("Deleted")
		}
	}
</script>
<meta charset="ISO-8859-1">
<title>CMS</title>
</head>
<body>

	<h2>Customer Management System</h2>
	<button name="Add Customers" type="submit"
		onclick="window.location.href = '/saveCustomer'">Add
		Customers</button>
	<br>

	<table>
		<tr>
			<th>ID</th>
			<th>Firstname</th>
			<th>Lastname</th>
			<th>Email</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="customer" items="${customers}">
			<c:url var="updateLink" value="/updateCustomers">
				<c:param name="customerId" value="${customer.id}"></c:param>
			</c:url>

			<c:url var="deleteLink" value="/deleteCustomers">
				<c:param name="customerId" value="${customer.id}"></c:param>
			</c:url>
			<tr>
				<td>${customer.id}</td>
				<td>${customer.firstName}</td>
				<td>${customer.lastName}</td>
				<td>${customer.email}</td>
				<td><a href="${updateLink}">Update </a></td>
				<td><a href="${deleteLink}"
					onclick="return confirm('Are you sure you want to delete this item?');">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>