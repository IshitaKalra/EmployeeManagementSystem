<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Static content -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Insert title here</title>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	background: #6471d43b
}

form button {
	color: #7e979c;
}
</style>
</head>
<body>
	<div align="center" style="padding-top: 120px;margin-top:30px;">
		<form action="/view" class="form-group" style="width: 300px;">
			<button type="submit" class="btn btn-primary form-control" style="background-color:#7e979c;">print all employees</button>
			<input type="hidden" name="userId" value="${id}">
		</form>
		<form action="/listAll" class="form-group" style="width: 300px;">
			<button type="submit" class="btn btn-primary form-control" style="background-color:#7e979c;">find the list of reporting employees</button>
			<input type="hidden" name="userId" value="${id}">
		</form>
		<form action="/indexPage" class="form-group" style="width: 300px;">
			<button type="submit" class="btn btn-primary form-control" style="background-color:#7e979c;">Exit</button>
			<input type="hidden" name="userId" value="${userId}">
		</form>
	</div>
</body>
</html>