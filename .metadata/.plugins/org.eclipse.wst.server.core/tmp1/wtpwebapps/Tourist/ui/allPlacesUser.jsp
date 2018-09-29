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
<script type="text/javascript" src="javascript/sort.js"></script>

</head>
<body>
<%@include file="usercopy"%>
	<div class="rightnav">
		<form method="post" action="searchPlace.obj">
			<input type="text" name="place" autofocus value="${search}" onfocus="this.value=this.value;"
				placeholder="quick place search" id="searchBox" value="${search}" />
			<input type="submit" id="searchButton" value="Submit"/> <a
				href="retrieveAllPlaces.obj" id="resetButton">Reset</a>
		</form>
	</div>
	<div class="sidenav4">
		<c:if test="${places.size()==0}">
			<h1>No places are currently in the record</h1>
		</c:if>

		<c:if test="${places.size()!=0}">
			<table>

				<form:form method="post" modelAttribute="place"
					action="modifyOrDelete.obj">
					<h1>Places Details</h1>
					<table border="1" id="table">

						<tr>
							<th onclick="return sort('Name',0);">Name &#x21F5</th>
							<th onclick="return sort('Address Line 1',1);">Address Line 1&#x21F5</th>
							<th onclick="return sort('Address Line 2',2);">Address Line 2&#x21F5</th>
							<th onclick="return sort('City',3);">City&#x21F5</th>
							<th onclick="return sort('Country',4);">Country&#x21F5</th>
							<th onclick="return sort('State',5);">State&#x21F5</th>
							<th onclick="return sortNumber('Pincode',6);">Pincode&#x21F5</th>
							<th>Latitude</th>
							<th>Longitude</th>
							<th onclick="return sort('Tag',9);">Tag &#x21F5</th>
							<th>Description</th>

						</tr>
						<c:if test="${places.size()<3}">
						<c:forEach var="i" begin="0" end="${places.size()-1 }" >
					
							<tr>

								<td>${places.get(i).name}</td>
								<td>${places.get(i).addressLine1 }</td>
								<td>${places.get(i).addressLine2 }</td>
								<td>${places.get(i).city }</td>
								<td>${places.get(i).country }</td>
								<td>${places.get(i).state }</td>
								<td>${places.get(i).pincode }</td>
								<td>${places.get(i).latitude }</td>
								<td>${places.get(i).longitude }</td>
								<td>${places.get(i).tags }</td>
								<td>${places.get(i).description }</td>
								
							</tr>

						</c:forEach>
						</c:if>
						<c:if test="${places.size()>=3}">
						<c:forEach var="i" begin="0" end="2" >
					
							<tr>

								<td>${places.get(i).name}</td>
								<td>${places.get(i).addressLine1 }</td>
								<td>${places.get(i).addressLine2 }</td>
								<td>${places.get(i).city }</td>
								<td>${places.get(i).country }</td>
								<td>${places.get(i).state }</td>
								<td>${places.get(i).pincode }</td>
								<td>${places.get(i).latitude }</td>
								<td>${places.get(i).longitude }</td>
								<td>${places.get(i).tags }</td>
								<td>${places.get(i).description }</td>
					
							</tr>

						</c:forEach>
						</c:if>
					</table>
				</form:form>

			</table>
			
		</c:if>
	</div>
	<c:if test="${places.size()!=0}">
	<div class="pagination">
	<a href="">&laquo</a>
	<a href="retrieveAllPlaces.obj">1</a>
	<c:forEach var="i" begin="2" end="${j}">
	<a href="pagination.obj?i=${i-1}">${i}</a>
	</c:forEach>
	<a href="">&raquo</a>
	</div>
	</c:if>
	
	
</body>
</html>