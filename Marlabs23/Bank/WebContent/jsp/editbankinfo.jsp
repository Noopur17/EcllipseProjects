<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="/Bank/er">
		<table border="3px">
			<tbody>
				<tr>
					<td align="right">Edit Your Data</td>
				</tr>
				<%-- <c:out value="${requestScope.list.fname}"/> --%>
				<c:forEach items="${requestScope.bvo}" var="list">
					<tr>
						<td>First Name :</td>
						<td><input type="text" id="fname" name="fname"
							value="<c:out value="${list.fname}"></c:out>" /></td>
					</tr>
					<tr>
						<td>Last Name :</td>
						<td><input type="text" id="lname" name="lname"
							value="<c:out value="${list.lname}"></c:out>" /></td>
					</tr>
					<tr>
						<td>Gender :</td>
						<td><input type="text" id="gender" name="gender"
							value="<c:out value="${list.gender}"></c:out>" /></td>
					</tr>
					<tr>
						<td>Address :</td>
						<td><input type="text" id="address" name="address"
							value="<c:out value="${list.address}"></c:out>" /></td>
					</tr>
					<tr>
						<td>City :</td>
						<td><input type="text" id="city" name="city"
							value="<c:out value="${list.city}"></c:out>" /></td>
					</tr>
					<tr>
						<td>State :</td>
						<td><input type="text" id="state" name="state"
							value="<c:out value="${list.state}"></c:out>" /></td>
					</tr>
					<tr>
						<td>Country :</td>
						<td><input type="text" id="country" name="country"
							value="<c:out value="${list.country}"></c:out>" /></td>
					</tr>
					<tr>
						<td>Phone No :</td>
						<td><input type="text" id="phone" name="phone"
							value="<c:out value="${list.phone}"></c:out>" /></td>
					</tr>
					<tr>
						<td>Bank Name :</td>
						<td><input type="text" id="bankname" name="bankname"
							value="<c:out value="${list.bankname}"></c:out>" /></td>
					</tr>
					<tr>
						<td>Account No :</td>
						<td><input type="text" id="account" name="account"
							value="<c:out value="${list.account}"></c:out>" /></td>
					</tr>
					<tr>
						<td>SSN :</td>
						<td><input type="text" id="ssn" name="ssn"
							value="<c:out value="${list.ssn}"></c:out>" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>