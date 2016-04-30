<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="contact" scope="request"
	type="com.fiipractic.agenda.web.models.Contact" />

<html>
<head>
<title>View Contact</title>
</head>
<body>
	<h1>View Contact</h1>
	<table border="1">
		<tbody>
			<tr>
				<td>Name</td>
				<td>${contact.name}</td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td>${contact.phoneNumber}</td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td>${contact.birthday}</td>
			</tr>
		</tbody>
	</table>
	<p>
		<a href="<c:url value="/contacts/list"/>">Go to list</a>
	</p>
</body>
</html>