<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify Place</title>
<link rel="stylesheet" type="text/css" href="css/adminstyle.css">
<script type="text/javascript" src="javascript/addressDropDown.js"></script>
</head>
<body onload="populateCountry('${place.country}','${place.state}','${place.tags}');">
	<%@include file="admincopy.jsp"%>
	<div class="sidenavModify">
		<h1>Modify Place Details</h1>
		<form:form name="form" action="insertModifiedPlace.obj"
			modelAttribute="place" method="post">

			<form:label path="name">Name            </form:label>
			<br>
			<form:input path="name" value="${place.name}"
				pattern="[A-Za-z]{1}[A-Za-z ]{0,}"
				title="Name should contain alphabets and max 50 characters only"
				required="true" readonly="true" />
			<br />



			<br>
			<form:label path="addressLine1">Address Line 1            </form:label>
			<br>
			<form:input path="addressLine1" value="${place.addressLine1}"
				pattern="[A-Za-z0-9,./- ]{0,50}"
				title="Address should contain alphanumeric , . / - characters and max 50 characters only"
				required="true" />
			<br />
			<br>
			<form:label path="addressLine2">Address Line 2            </form:label>
			<br>
			<form:input path="addressLine2" value="${place.addressLine2}"
				pattern="[A-Za-z0-9,./- ]{0,50}"
				title="Address should contain alphanumeric , . / - characters and max 50 characters only" />
			<br />
			<br>
			<form:label path="city">City            </form:label>
			<br>
			<form:input path="city" value="${place.city}"
				pattern="[A-Za-z ]{0,50}"
				title="City should contain alphabets and max 50 characters only"
				required="true" />
			<br />
			<form:label path="country">Country      </form:label>
			<br>
			<form:select path="country" id="area" required="true"
				value="${place.country}" onclick="addressDropDown()">
				<option value="">Select Country</option>
				<c:forEach items="${areas}" var="area">
					<option value="${area}">${area }</option>
				</c:forEach>
			</form:select>
			<br />

			<form:label path="state">State </form:label>
			<br>
			<form:select path="state" id="address" required="true"
				value="${place.state}">
			</form:select>
			<br />
			<br>
			<form:label path="pincode">Pincode            </form:label>
			<br>
			<form:input path="pincode" value="${place.pincode}"
				pattern="[0-9]{5,6}"
				title="Pincode should contain numer only and length must be 5 or 6"
				required="true" />
			<br />

			<br>
			<form:label path="latitude">Latitude   </form:label>
			<br>
			<form:input path="latitude" value="${place.latitude}" required="true" />
			<br />
			<form:label path="longitude">Longitude   </form:label>
			<br>
			<form:input path="longitude" value="${place.longitude}"
				required="true" />
			<br />

			<form:label path="tags">Tag</form:label>
			<br>
			<form:select path="tags" id="tags" pattern="[A-Za-z]{1}[A-Za-z ]{0,20}" 
				title="Tags should contain alphabets and max 20 characters only"
				required="true">
				<option value="Beach">Beach</option>
				<option value="Monument">Monument</option>
				<option value="Fort">Fort</option>
			</form:select>
			<br />
			<form:label path="description">Description</form:label>
			<br>
			<form:input path="description" pattern="[A-Za-z0-9,./- ]{1,250}"
				title="Description should contain alphabets and max 250 characters only"
				value="${place.description}" required="true" />
			<br />

			<input type="submit" value="Modify Details" />
			<a href="retrieveAllPlaces.obj" class="close">Close</a>
		</form:form>
	</div>
	</div>
</body>
</html>