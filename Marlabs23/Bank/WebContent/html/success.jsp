<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	 <pre>
	<jsp:useBean id = "bvo" class = "com.apex.VO.BankVO" scope="session"></jsp:useBean>
	
		
		First Name : <jsp:getProperty property="fname" name="bvo"/>
		Last Name  : <jsp:getProperty property="lname" name="bvo"/>
		Gender     : <jsp:getProperty property="gender" name="bvo"/>
		Address    : <jsp:getProperty property="address" name="bvo"/>
		City	   : <jsp:getProperty property="city" name="bvo"/>
		State      : <jsp:getProperty property="state" name="bvo"/>
		Country	   : <jsp:getProperty property="country" name="bvo"/>
		Phone      : <jsp:getProperty property="phone" name="bvo"/>
		Bank Name  : <jsp:getProperty property="bankname" name="bvo"/>
		Account    : <jsp:getProperty property="account" name="bvo"/>
		SSN	       : <jsp:getProperty property="ssn" name="bvo"/>
	</pre>
	
	<%-- <form  action = "/Bank/edit">
		<font color="blue">You have registered successfully</font>
		<pre>
			First Name : <c:out value="${bvo.fname}" />
			Last Name  : <c:out value="${bvo.lname}" />
			Gender     : <c:out value="${bvo.gender}" />
			Address    : <c:out value="${bvo.address}" />
			City	   : <c:out value="${bvo.city}" />
			State      : <c:out value="${bvo.state}" />
			Country	   : <c:out value="${bvo.country}" />
			Phone      : <c:out value="${bvo.phone}" />
			Bank Name  : <c:out value="${bvo.bankname}" />
			Account    : <c:out value="${bvo.account}" />
			SSN	       : <c:out value="${bvo.ssn}" />
			
		</br>	<button id="edit" name="btnedit" value="${bvo.fname}">Edit</button>
					
			
			<button id="delete" name="btndelete" value="${bvo.fname}">Delete</button>
					
			
		</pre> --%> 
	</form>
	 <%-- <table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Gender</th>
			<th>Address</th>
			<th>City</th>
			<th>State</th>
			<th>Country</th>
			<th>Bank Name</th>
			<th>Phone</th>
			<th>Account</th>
			<th>SSN</th>
		</tr>
		<tr>
			<c:forEach items="${requestScope.bvo}" var="bvo">
				<td><c:out value="${bvo.fname }"/></td>
				<td><c:out value ="${bvo.lname}"/></td>
				<td><c:out value ="${bvo.gender}"/></td>
				<td><c:out value ="${bvo.address}"/></td>
				<td><c:out value ="${bvo.city}"/></td>
				<td><c:out value ="${bvo.state}"/></td>
				<td><c:out value ="${bvo.country}"/></td>
				<td><c:out value ="${bvo.phone}"/></td>
				<td><c:out value ="${bvo.bankname}"/></td>
				<td><c:out value ="${bvo.account}"/></td>
				<td><c:out value ="${bvo.ssn}"/></td>
			
			</c:forEach> --%>
		
		
		</tr>	
	
	
	</table>
	
</body>
</html>