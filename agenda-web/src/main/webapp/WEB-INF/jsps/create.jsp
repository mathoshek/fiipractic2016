<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Create Contact</title>
</head>
<body>
	<h1>Create Contact</h1>
	<table border="1">
		<form:form commandName="contact">
			<tbody>
				<tr>
					<td>Name</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Phone number</td>
					<td><form:input path="phoneNumber" /></td>
				</tr>
				<tr>
					<td>Birthday</td>
					<td><form:input path="birthday" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Create" /></td>
				</tr>
			</tbody>
		</form:form>
	</table>
	<p>
		<a href="<c:url value="/contacts/list"/>">Cancel</a>
	</p>
</body>
</html>