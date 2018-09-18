<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Static content -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>Spring Boot</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script> 
  $(document).ready(function () {    
    
  
	$('#contact_userId').on('input', function() {
  var input=$(this);
  var is_name=input.val();
  if(is_name){input.removeClass("invalid").addClass("valid");}
  else{input.removeClass("valid").addClass("invalid");}
  });

    $('#contact_password').on('input', function() {
  var input=$(this);
  var is_password=input.val();
  var len=is_password.length;
  if(is_password && len>5){input.removeClass("invalid").addClass("valid");}
  else{input.removeClass("valid").addClass("invalid");}
});

    $("#contact_submit button").click(function(event){
	var form_data=$("#contact").serializeArray();
	var error_free=true;
	for (var input in form_data){
		
		var element=$("#contact_"+form_data[input]['name']);
		var valid=element.hasClass("valid");
		var error_element=$("span", element.parent());
		if (!valid){error_element.removeClass("error").addClass("error_show"); error_free=false;}
		else{error_element.removeClass("error_show").addClass("error");}
	}
	if (!error_free){
		event.preventDefault(); 
	}
	
});
  $("input:text#contact_userId").keyup(function(){ 
	var number=$("#contact_userId").val();
	var len=number.length;
	if(!(number.charAt(len-1)<='9' && number.charAt(len-1)>='1' || number.charAt(len-1)=='0'))
		{alert("WRONG Input");}
		
	$(this).val($(this).val().replace(/[^0-9\.]/g, "").replace(/^\./, "") );

 })
.blur(function(){ $(this).val( $(this).val().replace(/[^0-9\.]/g, "").replace(/^\./, "") ); });
  });
</script>
<STYLE>


.error {
	display: none;
	margin-left: 10px;
}

.error_show {
	color: red;
	margin-left: 10px;
}

input.invalid, textarea.invalid {
	border: 2px solid red;
}

input.valid, textarea.valid {
	border: 2px solid green;
}
.head{
	background-color:grey;
}


.error {
	color: red;
	margin-left: 5px;
}

label.error {
	display: inline;
	
}
.footer {
    position: fixed;
    left: 0;
    bottom: 0;
    width: 100%;
    background-color: lightgrey;
    color: white;
    text-align: center;
}
.header {
    position: fixed;
    left: 0;
    top: 0;
    width: 100%;
    background-color: lightgrey;
    color: white;
    text-align: center;
}
body {font-family: Arial, Helvetica, sans-serif;background:#6471d43b}
</STYLE>
</head>
<body>
	
	<div class="container">
	<div class="row header">
	<div class="col-lg-12 head" align="center" >
	<h1 style="color:white;">Welcome to Girnarsoft!!!</h1>
	</div>
	</div>
	
	
		<form id="contact" class="form-group" action="hello" method="post" style="margin-top:170px;">
			<div class="form-group" >
						<label for="contact_userId">Employee Id</label>
						<input type="text" id="contact_userId" class="form-control" name="userId">
					<span class="error">This field is required</span>
			</div>
			<div class="form-group">
						<label for="contact_password">Password</label>
						<input type="password" id="contact_password" class="form-control" name="password">
					<span class="error">Insufficient Password length!!</span>
			</div>

			<div id="contact_submit" class="form-group" >
						<button type="submit" class="btn btn-default">login</button>
			</div>
			<div style="color:red;">
	${display}
	</div>


		</form>
		<div class="row footer">
	<div class="col-lg-12 head" align="center" style="width: 100%; height: 100px;">
	<h1 style="color:white;">About the company!!!</h1>
	</div>
	</div>
	</div>

</body>
</html>