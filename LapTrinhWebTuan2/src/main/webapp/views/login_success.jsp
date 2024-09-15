<%@page import="LapTrinhWeb_Cha.models.UserModel"%>
<%@page import="LapTrinhWeb_Cha.controllers.WaitingController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Success</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f9;
	margin: 0;
	padding: 0;
	text-align: center;
}

.container {
	max-width: 600px;
	margin: 50px auto;
	padding: 20px;
	background: #fff;
	border-radius: 8px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

h1 {
	color: #333;
}

p {
	font-size: 1.2em;
	color: #555;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Login Success</h1>
		<p>You are successfully logged in!</p>
		<%
		UserModel account = (UserModel) request.getAttribute("account");
		if (account != null) {
			out.print("<p>Welcome, " + account.getFullname() + "</p>");
		} else {
			out.print("<p>Error: Account not found.</p>");
		}
		%>
	</div>
</body>
</html>