<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration | Company</title>
<script type="text/javascript">
function validate()
{
		var password=document.getElementById("password").value;
		var cnf_password=document.getElementById("confirm_password").value;
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
<h2><Marquee>Welcome to the Largest Job Search Portal</Marquee></h2>

<%= java.util.Calendar.getInstance().getTime() %>
<h3>Registration</h3>
<form action ='employerregister/register' method='post' modelAttribute="employer">
<table>
<tr>
<th>Company Name:</th>
<td><input type='text' id='name' name="company_name" required></td>
</tr>
<tr>
<tr>
<th>Email:</th>
<td><input type='email' name='email' required></td>
</tr>
<tr>
<th>Password:</th>
<td><input type='password' name='password' id='password' required></td>
</tr>
<tr>
<th>Confirm Password:</th>
<td><input type='password' name='confirm_password' id='confirm_password'  onkeyup='validate()' required></td>
<td><span id='message'></span></td>
</tr>
<tr> 
<th>Website</th>
<td><input type='text' name='website'></td>
</tr>
<tr>
<th>Contact Person Name</th>
<td><input type='text' name='contact_person_name' required></td>
</tr>
<tr>
<th>Designation</th>
<td><input type='text' name='designation' required></td>
</tr>
<tr>
<th>Contact Number</th>
<td><input type='text' name='contact' required></td>
</tr>
<tr>
<th>Industry Type</th>
<td><select name='industry' required>
<option value="IT">IT</option>
<option value="BPO">BPO</option>
</select>
</td>
</tr>
<tr>
<th>Office Address</th>
<td><textarea name='office_address' rows='6' cols='30' ></textarea></td>
</tr>
<tr>
<td><input type='submit' name='submit' id='submit' value='register'></td>
</tr>
</table>
</form>
</body>
</html>