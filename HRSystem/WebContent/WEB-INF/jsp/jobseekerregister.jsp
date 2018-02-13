<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration | JobSeeker</title>
<script type="text/javascript">
function myUpper() {
    var x = document.getElementById("name");
    x.value = x.value.toUpperCase();
}
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
<form action ='jobseekerregister/register' method='post' modelAttribute="jbseeker">
<table>
<tr>
<th>Username:</th>
<td><input type='text' name='username' required></td>
</tr>
<tr>
<th>Full Name:</th>
<td><input type='text' id='name' name="name" onchange="myUpper()" required></td>
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
<tr> 
<th>Gender</th>
<td><input type='radio' name='gender' value='male'required>Male <input type='radio' name='gender' value='female' required>Female</td>
</tr>
<tr>
<th>Date of Birth</th>
<td><input type='date' name='dob' required></td>
</tr>
<tr>
<th>Contact Number</th>
<td><input type='text' name='contact' required></td>
</tr>
<tr>
<th>Total Experience</th>
<td><input type='number' name='experience' required></td>
</tr>
<tr>
<th>Current CTC(in Lakhs)</th>
<td><input type='number' step="0.01" min="0" name='salary' required></td>
<td><b>(Put 0 if fresher)</b></td>
</tr>
<tr>
<th>Industry</th>
<td><select name='industry' required>
<option value="IT">IT</option>
<option value="BPO">BPO</option>
</select>
</td>
</tr>
<tr>
<td><input type='submit' name='submit' id='submit' value='register'></td>
</tr>
</table>
</form>


</body>
</html>