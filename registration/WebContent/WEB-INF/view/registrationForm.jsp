<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<h2>Member Data Form</h2>
	<form:form action="addMember" method="POST" commandName="userForm">
		<table>
			<tbody>
				<tr>
					<td><form:label path="firstName">First Name :</form:label></td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td><form:label path="lastName">Last Name:</form:label></td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td><form:label path="emailId">Email Id:</form:label></td>
					<td><form:input path="emailId" /></td>
				</tr>
				<tr>
					<td><form:label path="pwd">Password:</form:label></td>
					<td><form:input path="pwd" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>
