<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Static content -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Insert title here</title>
<style type="text/css">
body {
	font-family: Arial, Helvetica, sans-serif;
	background: #6471d43b
}
</style>
</head>
<body>
	<div align="center" style="margin-top: 120px;width:80% ;padding:10px;margin-left: auto;margin-right: auto;">
	<form class="form-group">
		<c:forEach items="${display}" var="element">
			<div class="form-control">
				<c:out value="${element}" />
			</div>
			<br>
		</c:forEach>
		</form>

		<form action="/exit" class="form-group"
			style="padding: 10px; width: 300px;">
			<input type="hidden" name="userId" value="${userId}">
			<button type="submit" class="btn btn-primary">Go to the menu!!!</button>
			
		</form>
	</div>
</body>
</html>