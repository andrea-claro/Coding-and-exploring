<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Student confirmation</title>
</head>
<body>
	The student name: ${student.firstName} ${student.lastName} <br>
	from ${student.country} <br>
	language ${student.favoriteLanguage} <br>
	systems
	<c:forEach var="temp" items="${student.operatingSystems}">
		${temp}
	</c:forEach>
	 
</body>
</html>