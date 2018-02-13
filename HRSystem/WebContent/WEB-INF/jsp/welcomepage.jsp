<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HOME</title>
</head>
<body>
<h2><Marquee>Welcome to the Largest Job Search Portal</Marquee></h2>
<%= java.util.Calendar.getInstance().getTime() %>
Welcome ${name} <br/>
<a href='change_password'>Change Password</a> <a href='logout'>Logout</a> 
<% if(session.getAttribute("type").toString().equals("employer")){ %>
<a href='post_jobs' >Post Jobs</a>
<%} %>
</body>
</html>