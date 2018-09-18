<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
 $(document).ready(function () {    
    
	$('#contact_editId').on('input', function() {
		  var input=$(this);
		  var is_editId=input.val();
		  if(is_editId){input.removeClass("invalid").addClass("valid");}
		  else{input.removeClass("valid").addClass("invalid");}
		  });

 $("#contact_submit button").click(function(event){
	 var form_data=$("#contact").serializeArray();
		var error_free=true;
		var input;
		for (input in form_data){
			var element=$("#contact_"+form_data[input]['name']);
			var valid=element.hasClass("valid");
			var error_element=$("span", element.parent());
			if(input>0)
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
			event.preventDefault(); 
		}
	});
 $("input:text#contact_editId").keyup(function(){ 
		var number=$("#contact_editId").val();
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
<div  align="center" style="margin-top:120px";>
<form id="contact" action="/editEmployeePage"  method="post" class="form-group" style="width:300px;margin-top:100px;">
		
		<div  class="form-group">
			<label for="contact_editId">Enter the Id of the employee to be Edited</label> 
			<input type="text" id="contact_editId" name="editId" class="form-control">
			<span class="error">This field is required</span>
		</div>
		<div>
			<input type="hidden" class="valid" id="contact_userId" name="userId" value="${userId}">
		</div>
		<div id="contact_submit">
			<button type="submit" class="btn btn-primary">SUBMIT</button>
		</div>
	</form>
</div>
</body>
</html>