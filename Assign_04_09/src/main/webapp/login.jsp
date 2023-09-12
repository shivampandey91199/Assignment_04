<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login Form</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	background-color: #f5f5f5;
}

.container {
	background-color: #fff;
	border-radius: 5px;
	padding: 20px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

.input-group {
	margin-bottom: 15px;
}

label {
	display: block;
	margin-bottom: 5px;
	font-weight: bold;
}

input {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 3px;
}

button {
	display: block;
	width: 100%;
	padding: 10px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 3px;
	cursor: pointer;
}

button:hover {
	background-color: #0056b3;
}
</style>

</head>
<body>

<% String msg= (String)request.getAttribute("msg");
    if(msg !=null){
    	out.print(msg);
    }
 

%>
	<div class="container">
		<form action="userController" method="post">
			<h2>Login</h2>
			<div class="input-group">
				<label for="email">Email:</label> <input type="email" id="email"
					name="email" required>
			</div>
			<div class="input-group">
				<label for="password">Password:</label> <input type="password"
					id="password" name="password" required>
			</div>
			<button  name="action" type="submit">Login</button>
		</form>
	</div>
	<script>
		document.getElementById("login-form").addEventListener("submit",function(event) {
					event.preventDefault();
					const email = document.getElementById("email").value;
					const password = document.getElementById("password").value;
					console.log("Email:", email);
					console.log("Password:", password);
				});
	</script>
</body>
</html>

