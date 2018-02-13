<html>
<body>
<h2><Marquee>Welcome to the Largest Job Search Portal</Marquee></h2>

<%= java.util.Calendar.getInstance().getTime() %>
<form action ='login' method='post'>
<table>
<tr>
<td><select name='type'>
	<option value='employer'>Employer</option>
	<option value='jobseeker'>JobSeeker</option>
</select></td>
</tr>
<tr>
<th>Username:</th>
<td><input type='text' name='user' required></td>
</tr>
<tr>
<th>Password:</th>
<td><input type='password' name='pass' required></td>
</tr>
<tr>
<td><input type='submit' name='submit' value='login'></td>
</tr>
</table>
</form>
<p>not having account ? <a href='register'>Sign up</a></p>
</body>
</html>
