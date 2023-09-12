<%@page import="Model.user"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Edit Profile</title>
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

  .form-group {
    margin-bottom: 20px;
  }

  label {
    display: block;
    font-weight: bold;
    margin-bottom: 5px;
  }

  input[type="text"],
  input[type="email"],
  input[type="tel"],
  input[type="password"] {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
  }

  .btn {
    padding: 10px 20px;
    background-color: #333;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }
</style>
</head>
<body>
<% user u=(user)request.getAttribute("data"); %>
  
  <div class="container">
    <h1>Edit Your Profile</h1>
    <form action="userController" method="post">
      <div class="form-group">
        <label for="name">Name</label>
        <input type="text" id="name" name="name" value="<%=u.getName()%>" required>
      </div>
      <div class="form-group">
        <label for="email">Email</label>
        <input type="email" id="email" name="email" value="<%=u.getEmail() %>" required>
      </div>
      <div class="form-group">
        <label for="contact">Contact</label>
        <input type="tel" id="contact" name="contact" value="<%=u.getContact() %>" required>
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" value="<%=u.getPassword() %>" required>
      </div>
      <button name="action" type="submit" value="update">Update</button>
    </form>
  </div>
</body>
</html>
