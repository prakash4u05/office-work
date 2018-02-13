<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Password Change</title>
<script type="text/javascript">
	document.getElementById('msg').style.color="red";
function validate()
{
		var password=document.getElementById("password_new").value;
		var cnf_password=document.getElementById("password_cnf").value;
		if(password==cnf_password)
		{
			document.getElementById("message").innerHTML="password match";
			document.getElementById("submit").disabled = false;
		}
		else
		{
			document.getElementById("message").innerHTML="password does not match";
			document.getElementById("submit").disabled = true;
		}
}
</script>
</head>
<body>
	<form method='post' action='change_password/change'>
	<p>Hi ${name}</p>
	<table>
		<tr>
		<th>Current Password</th>
		<td><input type='password' name='password'></td>
		</tr>
		<tr>
		<th>New Password</th>
		<td><input type='password' name='password_new' id='password_new'></td>
		</tr>
		<tr>
		<th>Confirm New Password</th>
		<td><input type='password' name='password_cnf' id='password_cnf' onkeyup='validate()'></td>
		<td><span id='message'></span></td>
		</tr>
		<tr>
		<td>
		<input type='submit' name='submit' id ='submit' value='Change Password'>
		</td>
		</tr>
		</table>
	</form>
	<p><span id='msg'>${msg}</span></p>
</body>
</html>