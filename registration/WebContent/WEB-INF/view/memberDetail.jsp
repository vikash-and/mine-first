<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>member</title>
</head>
<body>
	<h2>Submitted Member Information</h2>
	<table border="1">
		<tbody>
			<tr>
				<td>First Name</td>
				<td>${userForm.firstName}</td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td>${userForm.lastName}</td>
			</tr>
			<tr>
				<td>Email Id</td>
				<td>${userForm.emailId}</td>
			</tr>
			<tr>
				<td>Password</td>
				<td>${userForm.pwd}</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
