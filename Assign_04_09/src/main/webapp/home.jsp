<%@page import="Model.user"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home Page</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f0f0f0;
}

header {
	background-color: #333;
	color: #fff;
	padding: 10px;
	text-align: right;
}

.container {
	max-width: 800px;
	margin: 40px auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.btn {
	padding: 10px 20px;
	background-color: #333;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.btn.edit {
	background-color: #007bff;
}

.btn.logout {
	background-color: #dc3545;
}
</style>
</head>
<body>
	<header>
		<%
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		
		
		if(session.getAttribute("data") !=null){
			user u=(user)session.getAttribute("data");
		}else{
			response.sendRedirect("login.jsp");
		}
		%>
		<div class="container">
			<button class="edit.jsp">Edit</button>
			<button class="logout.jsp">Logout</button>
		</div>
	</header>

	<div class="container">
		<h1>Welcome to Your Home Page</h1>

	</div>
</body>
</html>
