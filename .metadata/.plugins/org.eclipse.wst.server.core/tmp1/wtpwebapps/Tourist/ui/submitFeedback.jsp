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
	<%@include file="usercopy"%>
	<div class="sidenav3">
		<form method="post" action="addFeedback.obj">
			<textarea placeholder="Please give your feedback here" name="textarea" class="textarea" rows="20"
				name="comment[text]" id="comment_text" cols="40"
				class="ui-autocomplete-input" autocomplete="off" role="textbox"
				aria-autocomplete="list" aria-haspopup="true" ></textarea> <br> <br>
			<input type="submit" value="Submit Feedback" />
		</form>
	</div>
	</div>
</body>
</html>