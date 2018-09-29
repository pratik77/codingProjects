<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"  href="css/loginstyle.css" media="all">
<script type="text/javascript" src="javascript/overlayEffect.js"></script>
<script type="text/javascript" src="javascript/validateTags.js"></script>
</head>
<body onload="reset()">
<%@include file="header.jsp" %>
</div>
	<form action="login.obj" method="post">
		<table align="center">
			<tr>
				<td><input type="text" name="username" placeholder="Username"
					class="input" required /></td>
			</tr>
			<tr>
				<td><input type="password" name="password"
					placeholder="Password" class="input" required /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Log in" class="login" required /><a
					href=""><button class="signup" type="button" onclick="return overlayEffect()">Sign
							up</button></a></td>
			</tr>

		</table>
<font id="outPopUp" color="red">${message}</font>
	</form>
	<div id="overlay" class="overlay">
		<a href="javascript:void(0)" class="closeButton"
			onclick="return off();"><font color="#ff7735">&times</font></a>
		<div class="overlayContent">
			<form:form name="form" action="addUser.obj" id="signupForm"
				modelAttribute="user" method="post"
				onsubmit="return validateTags(${tags.size()})">

				<br>
				<form:input path="firstName" pattern="[A-Za-z]{1}[A-Za-z ]{1,50}"
					id="username"
					title=" First Name should contain alphabets only and maximum 50 characters allowed"
					required="true" placeholder="First Name" class="input" />
				<br />

				<br>
				<form:input path="lastName" pattern="[A-Za-z]{1}[A-Za-z ]{1,50}"
					title=" First Name should contain alphabets only and maximum 50 characters allowed"
					required="true" placeholder="Last Name" class="input" />
				<br />
				<br>
				<form:input path="username" pattern="[A-Za-z0-9]{1,15}"
					id="username"
					title="username should contain alphanumeric characters only and maximum 15 characters allowed"
					required="true" placeholder="username" class="input" />
				<br />

				<br>
				<form:password path="password" required="true"
					pattern="[A-Za-z@_.0-9]{1,15}"
					title="password should contain alphanumeric, @, _, . characters only and minimum 4 and maximum 15 characters allowed"
					placeholder="password" class="input" />
				<br />

				<br>
				<form:input path="email" required="true" placeholder="email"
					pattern="[A-Za-z0-9_.]{1,}[@]{1}[A-Za-z0-9]{2,}[.]{1}[A-Za-z0-9]{2,}"
					title="Sample pattern is abc9_@abc.abc" class="input" />
				<br />


				<br>
				<form:input path="phoneNum" required="true" pattern="[0-9]{10}"
					title="Please enter a valid 10 digit phone number"
					placeholder="phone number" class="input" />
				<br />
				<br>
				<form:label path="tags">
					<font color="white">Select Tags</font>
				</form:label>
				<c:forEach items="${tags}" var="tag">

					<br>

					<input type="checkbox" name="tagSelect" class="input"
						value="${tag }" />
					<font color="white">${tag}</font>
				</c:forEach>
				<br>
				<input type="submit" value="Create Account" class="login1" />
			</form:form>
		</div>
	</div>

</body>
</html>