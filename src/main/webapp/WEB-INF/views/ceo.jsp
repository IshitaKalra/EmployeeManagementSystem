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

<title>Insert title here</title>
</head>
<style>
body {font-family: Arial, Helvetica, sans-serif;background:#6471d43b}
form button{
color:#7e979c;
}
</style>
<body >
<div class="container" >
	<div align="center" style="padding-top: 120px;margin-top:30px;">
		<form action="/view" class="form-group" style="width: 300px;">
			<div class="form-group">
				<button type="submit" class="btn btn-primary form-control" style="background-color:#7e979c;">print
					all employees</button>
				<input type="hidden" name="userId" value="${userId}">
			</div>
		</form>
		<form action="/getEditId" class="form-group" style="width: 300px;">
			<div class="form-group">
				<button type="submit" class="btn btn-primary form-control" style="background-color:#7e979c;">Edit
					the details of Employee</button>
				<input type="hidden" name="userId" value="${userId}">
			</div>
		</form>
		<form action="/removeEmployee" class="form-group"
			style="width: 300px;">
			<div class="form-group">
				<button type="submit" class="btn btn-primary form-control" style="background-color:#7e979c;">remove
					an employee</button>
				<input type="hidden" name="userId" value="${userId}">
			</div>
		</form>
		<form action="/addEmployee" class="form-group" style="width: 300px;">
			<div class="form-group">
				<button type="submit" class="btn btn-primary form-control" style="background-color:#7e979c;">add
					a new employee</button>
				<input type="hidden" name="userId" value="${userId}">
			</div>
		</form>

		<form action="/listAll" class="form-group" style="width: 300px;">
			<div class="form-group">
				<button type="submit" class="btn btn-primary form-control" style="background-color:#7e979c;">find
					the list of reporting employees</button>
				<input type="hidden" name="userId" value="${userId}">
			</div>
		</form>
		<form action="/promotePage" class="form-group" style="width: 300px;">
			<div class="form-group">
				<button type="submit" class="btn btn-primary form-control" style="background-color:#7e979c;">promote
					an employee</button>
				<input type="hidden" name="userId" value="${userId}">
			</div>
		</form>
		<form action="/indexPage" class="form-group" style="width: 300px;">
			<div class="form-group" style="padding-bottom: 100px;">
				<button type="submit" class="btn btn-primary form-control" style="background-color:#7e979c;">Exit</button>
				<input type="hidden" name="userId" value="${userId}">
			</div>
		</form>
	</div>
	</div>
</body>
</html>