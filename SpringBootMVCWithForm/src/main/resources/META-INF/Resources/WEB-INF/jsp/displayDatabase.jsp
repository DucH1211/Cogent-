<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"  %>
<!DOCTYPE html>
<html>
<style>
table, th, td {
  border:1px solid black;
  cellpadding: 2px;
}
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Students Here</h1>
	<table style="width: 60%">
	<tr>
        	<th><b>Student ID</b></th>
        	<th><b>First Name</b></th>
        	<th><b>Last Name</b></th>
        	<th><b>Email</b></th>
        	<th><b>Gender</b></th>
        	<th><b>Education</b></th>
        	<th><b>DOB</b></th>
    </tr>
    <c:forEach items = "${students}" var = "theStudent">
        <tr>
            <td><c:out value = "${theStudent.id}"></c:out></td>
            <td><c:out value = "${theStudent.firstName}"></c:out></td>
            <td><c:out value = "${theStudent.lastName}"></c:out></td>
            <td><c:out value = "${theStudent.email}"></c:out></td>
            <td><c:out value = "${theStudent.gender}"></c:out></td>
            <td><c:out value = "${theStudent.education}"></c:out></td>
            <td><c:out value = "${theStudent.DOB}"></c:out></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>