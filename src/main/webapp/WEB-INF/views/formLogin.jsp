<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/entry?action=Login" var="linkLogin"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In</title>
</head>
<body>

	<h2>Log In:</h2>

	<form action="${linkLogin}" method="POST">
		Login: <input type="text" name="login"/><br/>
		Password: <input type="password" name="password"/><br/>
		<button type="submit">Login</button>
	</form>

</body>
</html>