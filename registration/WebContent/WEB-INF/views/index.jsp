<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form:form action="loginMember" method="POST" commandName="userForm">
		<table>
			<tr>
				<td><form:label path="userName">email id :</form:label></td>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td><form:label path="loginPassword">password :</form:label></td>
				<td><form:input path="loginPassword" /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="submit" /></td>
				<td><input name="reset" type="reset" /></td>
			</tr>
			<tr>
				<td colspan='2'><a href="register"
					style="font: 14px normal arial"> Register </a></td>
			</tr>
		</table>
	</form:form>
</body>
</html>