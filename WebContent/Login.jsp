<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><link href="styleSheet.css" rel="stylesheet" type="text/css"></head>
<script>
function shownewuserdiv(){
	document.getElementById("login").style.display = "none";
	document.getElementById("newuser").style.visibility = "visible";
	
}
function checkpassword(){
	var password = document.getElementById("password").value;
	var confirmpassword = document.getElementById("confirmpassword").value;
	if(password == confirmpassword)
	{
		document.getElementById("newuserform").submit();
	}
	else{
		document.getElementById("errorline").innerHTML = "Password doesn't match!!";
	}
	
}
</script>
<body style= "background-color:#87CEFA">
<div id = "login" >

Welcome to Bugbox


<form action = "login" method ="post">
<p>
UserName:<br>
<input type="text" name="username" style="border-radius:2px" ></p>
<p>
Password:<br>
<input type= "password" name="password" style="border-radius:2px" ></p>
<input type="submit" value="Login" style="border-radius:2px">
</form>
<br>
<button onclick="shownewuserdiv()">Create New Account</button>

<c:if test = "${!empty param.error}">
	<p>
	Not Logged In!!
	</p>
</c:if>	
<c:if test = "${!empty param.sameUserError}">
	<p>
	User already exist !!
	</p>
</c:if>	
 
</div>
<div id = "newuser" >

Welcome to Bugbox


<form id= "newuserform"action = "addUser" method ="post">
<p>
UserName:<br>
<input type="text" name="username" style="border-radius:2px" ></p>
<p>
Password:<br>
<input id = "password" type= "password" name="password" style="border-radius:2px" ></p>
<p>
Confirm Password:<br>
<input id ="confirmpassword" type= "password" name="confirmpassword" style="border-radius:2px" ></p>


</form>
<button onclick="checkpassword()" style="border-radius:2px">Sign In</button>
<p id= "errorline"></p>


 
</div>



</body>
</html>