<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
  }

  .login-container {
    background-color: #ffffff;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
    width: 300px;
  }

  .login-container h2 {
    margin-bottom: 15px;
    text-align: center;
  }

  .login-form input {
    width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 3px;
    box-sizing: border-box;
  }

  .login-form button {
    background-color: #007bff;
    color: #fff;
    border: none;
    padding: 10px 15px;
    border-radius: 3px;
    width: 100%;
    cursor: pointer;
  }

  .login-form button:hover {
    background-color: #0056b3;
  }
</style>
</head>
<body>
	<%
		String msg = (String) request.getAttribute("msg");
	    if(msg !=null){
	    	out.print(msg);
	}
		%>
  <div class="login-container">
    <h2>Login</h2>
    <form class="login-form" action="studentController" method="post">
      <input type="text" placeholder="email" name="email" required>
      <input type="password" placeholder="Password" name="" required>
      <button type="submit" name="action">Login</button>
    </form>
  </div>
</body>
</html>
