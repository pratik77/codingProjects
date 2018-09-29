<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/adminstyle.css">
</head>
<body>
	<%@include file="admincopy.jsp"%>
	<div class="sidenav3">
	<c:if test="${feedbacks.size()==0}">
			<h1>No feedbacks are currently in the record</h1>
		</c:if>
		
		<c:if test="${feedbacks.size()!=0}">
	<table border="1" id="table">

		<tr>
			<th>Feedbacks</th>

		</tr>
		<c:forEach items="${feedbacks}" var="feedback">
			<tr>

				<td>&#x02022 ${feedback}</td>
			</tr>

		</c:forEach>
	</table>
	</c:if>
	</div>
	</div>
</body>
</html>