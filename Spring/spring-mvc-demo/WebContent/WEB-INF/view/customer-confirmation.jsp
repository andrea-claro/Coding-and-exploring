<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer confirmation</title>
</head>
<body>
	The customer name: ${customer.firstName}  ${customer.lastName} <br>
	Free passes: ${customer.freePasses} <br>
	Postal code; ${customer.postalCode} <br>
	Course code; ${customer.courseCode}
</body>
</html>