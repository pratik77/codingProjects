<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/adminstyle.css">
</head>
<body>
<%@include file="admincopy.jsp"%>
	<div class="rightnav">
		<form method="post" action="searchPlace.obj">
			<input  type="text" name="place" placeholder="quick place search" id="searchBox" /> <input 
				 type="submit" id="searchButton"/> <a
				href="retrieveAllPlaces.obj" id="resetButton">Reset</a>
		</form>
	</div>
	<div class="sidenav2">
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
							<th>Name</th>
							<th>Area</th>
							<th>Address</th>
							<th>Latitude</th>
							<th>Longitude</th>
							<th>Tag</th>
							<th>Description</th>
							<th colspan="2">Actions</th>

						</tr>
						<c:forEach items="${places}" var="placeObj">
							<tr>

								<td>${placeObj.name}</td>
								<td>${placeObj.area }</td>
								<td>${placeObj.address }</td>
								<td>${placeObj.latitude }</td>
								<td>${placeObj.longitude }</td>
								<td>${placeObj.tags }</td>
								<td>${placeObj.description }</td>
								<td><a
									href="modifyOrDelete.obj?placeObj=${placeObj.name}&submit=modify">modify</a></td>
								<td><a
									href="modifyOrDelete.obj?placeObj=${placeObj.name}&submit=delete">delete</a></td>
							</tr>

						</c:forEach>
					</table>
				</form:form>

			</table>
		</c:if>
	</div>
	</div>
</body>
</html>