<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
 $(document).ready(function () {    
    
   $('#contact_name').on('input', function() {
  var input=$(this);
  var is_name=input.val();
  if(is_name){input.removeClass("invalid").addClass("valid");}
  else{input.removeClass("valid").addClass("invalid");
}
  });
	$('#contact_salary').on('input', function() {
  var input=$(this);
  var is_salary=input.val();
  if(is_salary){input.removeClass("invalid").addClass("valid");}
  else{input.removeClass("valid").addClass("invalid");}
  });
	
	$('#contact_password').on('input', function() {
		  var input=$(this);
		  var is_password=input.val();
		  var len=is_password.length;
		  if(len>5){input.removeClass("invalid").addClass("valid");}
		  else{input.removeClass("valid").addClass("invalid");}
		  });
	
	$('#contact_phone').on('input', function() {
		  var input=$(this);
		  var is_name=input.val();
		  if(is_name && is_name.length==10){input.removeClass("invalid").addClass("valid");}
		  else{input.removeClass("valid").addClass("invalid");}
		  });

	$('#contact_headId').on('input', function() {
		  var input=$(this);
		  var is_headId=input.val();
		  if(is_headId){input.removeClass("invalid").addClass("valid");}
		  else{input.removeClass("valid").addClass("invalid");}
		  });

 $('#contact_submit').click(function(event){
	var form_data=$("#contact").serializeArray();
	var error_free=true;
	var input;
	for (input in form_data){
		var element=$("#contact_"+form_data[input]['name']);
		var valid=element.hasClass("valid");
		var error_element=$("span", element.parent());
		if(input>4)
			{
			error_element.removeClass("error_show").addClass("error");
			}
		else if (!valid){
			error_element.removeClass("error").addClass("error_show"); error_free=false;
			}
		else{
			error_element.removeClass("error_show").addClass("error");
			}
		
		
	}
	if (!error_free){
		alert("Error!!");
		event.preventDefault(); 
	}
});
  $("input:text#contact_phone").keyup(function(){ 
	var number=$("#contact_phone").val();
	var len=number.length;
	if(len>10)
	{
		alert("Wrong Input for a Mobile Number");
			
	}
	if(!(number.charAt(len-1)<='9' && number.charAt(len-1)>='1' || number.charAt(len-1)=='0'))
		{alert("WRONG Input");}
		
	$(this).val($(this).val().replace(/[^0-9\.]/g, "").replace(/^\./, "") );

 })
.blur(function(){ $(this).val( $(this).val().replace(/[^0-9\.]/g, "").replace(/^\./, "") ); });
  $("input:text#contact_name")
.keyup(function(){
	var name=$("#contact_name").val();
	var len=name.length;
	if(!((name.charAt(len-1)<='z' && name.charAt(len-1)>='a') || (name.charAt(len-1)<='Z'&& (name.charAt(len-1)>='A')) || name.charAt(len-1)==' '))
		{
		alert("WRONG Input");
	 	$(this).val( $(this).val().replace(/[^a-zA-Z\.]/g, "").replace(/^\./, "") );}
 })
.blur(function(){ $(this).val( $(this).val().replace(/[^a-zA-Z\. ]/g, "").replace(/^\./, "") ); });
  $("input:text#contact_salary").keyup(function(){ 
		var number=$("#contact_salary").val();
		var len=number.length;
		if(!(number.charAt(len-1)<='9' && number.charAt(len-1)>='1' || number.charAt(len-1)=='0'))
			{alert("WRONG Input");}
			
		$(this).val($(this).val().replace(/[^0-9\.]/g, "").replace(/^\./, "") );

	 })
	.blur(function(){ $(this).val( $(this).val().replace(/[^0-9\.]/g, "").replace(/^\./, "") ); });
  $("input:text#contact_headId").keyup(function(){ 
		var number=$("#contact_headId").val();
		var len=number.length;
		if(!(number.charAt(len-1)<='9' && number.charAt(len-1)>='1' || number.charAt(len-1)=='0'))
			{alert("WRONG Input");}
		$(this).val($(this).val().replace(/[^0-9\.]/g, "").replace(/^\./, "") );

	 })
	.blur(function(){ $(this).val( $(this).val().replace(/[^0-9\.]/g, "").replace(/^\./, "") ); });
  


});
</script>

<style>

/* Add a grey background color to dropdown links on hover */
.dropdown-content li:hover {
	background-color: #ddd;
}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
	display: block;
}

form label {
	display: inline-block;
	width: 300px;
}

form div {
	margin-bottom: 10px;
}

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

.error {
	color: red;
	margin-left: 5px;
}

label.error {
	display: inline;
}
body {font-family: Arial, Helvetica, sans-serif;background:#6471d43b}
</style>
</head>
<body>
<div align="center">
	<form id="contact" action="/add" method="post" class="form-group" style="padding:10px;width:300px;">
		<div class="form-group">
			<label for="contact_name">Name:</label> 
			<input type="text" id="contact_name" name="name" class="form-control"> 
			<span class="error">This field is required</span>
		</div>
		<div class="form-group">
			<label for="contact_phone">Mobile Number:</label> 
			<input type="text" id="contact_phone" name="phone" class="form-control">
			 <span class="error">This field is required</span>
		</div>
		<div class="form-group">
			<label for="contact_salary">Salary:</label> 
			<input type="text" id="contact_salary" name="salary" class="form-control">
			 <span class="error">This field is required</span>
		</div>
		<div class="form-group">
			<label for="contact_password">Password:</label> 
			<input type="text" id="contact_password" name="password" class="form-control" > 
			<span class="error">This field is required</span>
		</div>
		<div class="form-group">
			<label for="contact_headId" >headId:</label> 
			<input type="text" id="contact_headId" name="headId" class="form-control"> 
			<span class="error">This field is required</span>
		</div >
		<div class="form-group">
			<label for="contact_roleId">Employee Role</label> 
			<select class="valid form-control" id="roleId" name="roleId">
				<option value="0" >Employee</option>
				<option value="1">Manager</option>
				<option value="2">Hr</option>
			</select>
		</div>
		<div class="form-group">
			<input type="hidden" name="userId" class="valid" id="contact_userId" value="${userId}">
			<span class="error">This field is required</span>	
		</div>
		<div align="center" class="form-group">
			<button id="contact_submit" type="submit" class="btn btn-primary">SUBMIT</button>
		</div>
		

	</form>
	</div>


</body>
</html>