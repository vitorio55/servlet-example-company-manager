<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Company registered</title>
</head>
<body>

	<c:if test="${not empty company}">
		Company "${company}" registered successfully!
	</c:if>

	<c:if test="${empty company}">
		No companies registered.
	</c:if>
	<a href="formNewCompany.jsp">Register new company</a>

</body>
</html>