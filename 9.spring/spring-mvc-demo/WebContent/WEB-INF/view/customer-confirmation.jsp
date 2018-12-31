<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>

<html>
<head>
<title>Confirmation</title>
</head>
<body>
	<h2>Customer Confirmation Page</h2>

	<br /> The customer is confirmed: ${customer.firstName}
	${customer.lastName}

	<br /> The customer passes ${customer.freePasses}

	<br /> The Course code ${customer.postalCode}

	<br /> The Course code ${customer.courseCode}

</body>
</html>