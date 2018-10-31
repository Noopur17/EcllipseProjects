<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Student Confirmation</title>
</head>
<body>

	The student is confirmed :${student.firstName }${student.lastName }
<br><BR>

Country:${student.country }

<br><BR>
Favourite Language:${student.favouriteLanguage }

<br><br>
OS:
<ul>
	<c:forEach var="temp" items="${student.os }">
<li>
	${temp }
</li>
</c:forEach>
</ul>
</body>
</html>