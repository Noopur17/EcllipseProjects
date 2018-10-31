<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Student Registration form</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student">
First Name: <form:input path="firstName" />
		<br>
		<br>
Last Name: <form:input path="lastName" />
		<br>
		<br>
Country:
<form:select path="country">
<form:options items="${student.countryoptions }"/>

</form:select>

<br><br>
Favourite Language:
Java <form:radiobutton path="favouriteLanguage" value="Java"/>
PHP <form:radiobutton path="favouriteLanguage" value="PHP"/>
C# <form:radiobutton path="favouriteLanguage" value="C#"/>
Ruby <form:radiobutton path="favouriteLanguage" value="Ruby"/>
<br><br>
Operating Systems:

Linux: <form:checkbox path="os" value="Linux"/>
Mac: <form:checkbox path="os" value="Mac"/>
Windows: <form:checkbox path="os" value="Windows"/>
<br><br>
		<input type="submit" value="submit" />
	</form:form>


</body>
</html>