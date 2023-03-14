<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CMS</title>
</head>
<body>

	<form:form action="processCustomer" method="POST"
		modelAttribute="customer">
		<form:hidden path="id" />
		<table>
			<tr>
				<td><label>First Name</label></td>
				<td><form:input path="firstName" /></td>
			</tr>

			<tr>
				<td><label>Last Name</label></td>
				<td><form:input path="lastName" /></td>
			</tr>

			<tr>
				<td><label>Email</label></td>
				<td><form:input path="email" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>

	</form:form>

</body>
</html>