<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>output Validation and JDBC </title>
</head>
<body>

<form method="post" action=''>
<h1><font color=blue size=5> Registered Successfully</font></h1>

<table cellspacing ='5' border="0"> 
<tr>
<td align= "right"> First Name:</td> <td><c:out value="${userBean.firstName}"/> </td>
</tr>

<tr>
<td align= "right"> Last Name:</td> <td><c:out value="${userBean.lastName}"/> </td>
</tr>

<tr>
<td align= "right"> Gender:</td> <td><c:out value="${userBean.gender}"/> </td>
</tr>

<tr>
<td align= "right"> Address:</td> <td><c:out value="${userBean.address}"/> </td>
</tr>

<tr>
<td align= "right"> City:</td> <td><c:out value="${userBean.city}"/> </td>
</tr>

<tr>
<td align= "right"> State:</td> <td><c:out value="${userBean.state}"/> </td>
</tr>


<tr>
<td align= "right"> Country:</td> <td><c:out value="${userBean.country}"/> </td>
</tr>

<tr>
<td align= "right"> Phone :</td> <td><c:out value="${userBean.phone}"/> </td>
</tr>

<tr>
<td align= "right"> Bank Name:</td> <td><c:out value="${userBean.bankName}"/> </td>
</tr>

<tr>
<td align= "right"> Account No:</td> <td><c:out value="${userBean.accountNumber}"/> </td>
</tr>

<tr>
<td align= "right"> SSN :</td> <td><c:out value="${userBean.ssn}"/> </td>
</tr>



</table>
<input type = 'submit' value="Click here to view all and other operations"></input>
</form>


</body>
</html>