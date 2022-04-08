<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/entry?action=CreateCompany" var="linkCreateCompany"/>
<c:url value="/entry?action=ListCompanies" var="linkListCompanies"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New company</title>
</head>
<body>

	<a href="${linkListCompanies}">List registered companies</a>

	<h2>New company:</h2>

	<form action="${linkCreateCompany}" method="POST">
		Name: <input type="text" name="name"/><br/>
		Established date: <input type="text" name="date"/><br/>
		<button type="submit">Register</button>
	</form>

</body>
</html>