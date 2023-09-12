<%@page import="Model.userModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home-page</title>
</head>
<body>
 <%userModel u=(userModel)request.getAttribute("data"); %>
   <h1><%=u.getFname() %></h1>
   <h2><%=u.getLname() %></h2>
   <h3><%=u.getContact()%></h3>
   <h4><%=u.getGender()%></h4>
   <h5><%=u.getEmail()%></h5>
   <h6><%=u.getPassword() %></h6>  
</body>
</html>