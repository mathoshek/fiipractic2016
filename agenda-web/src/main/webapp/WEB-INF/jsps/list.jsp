<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="contacts" scope="request"
	type="java.util.Map<java.lang.Integer,com.fiipractic.agenda.web.models.Contact>"/>

<html>
<head>
<title>List Contacts</title>
</head>
<body>
	<h1>List Contacts</h1>
	<p>
		<a href="<c:url value="/contacts/create"/>">Create new contact</a>
	</p>
	<table border="1">
		<thead>
			<tr>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Phone Number</td>
				<td>Actions</td>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="contact" items="${contacts}">
				<tr>
					<td>${contact.value.name}</td>
					<td>${contact.value.phoneNumber}</td>
					<td><a
						href="<c:url value="/contacts/view?contactId=${contact.key}"/>">View</a>
						<a href="<c:url value="/contacts/edit?contactId=${contact.key}"/>">Edit</a>
						<form
							action="<c:url value="/contacts/delete?contactId=${contact.key}"/>"
							method="POST" style="display: inline">
							<input type="submit" value="Delete" />
						</form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>