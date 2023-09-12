<%@page import="Model.student"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Page</title>
</head>
<body>

<% student s=(student)request.getAttribute("data");%>

    <h1>Home Page</h1>
    <form action="studentController" method="post">
        
        <label for="fname">First Name:</label>
        <input type="text" id="fname" name="fname" value = "<%=s.getFname() %>"required><br><br>
        
        <label for="lname">Last Name:</label>
        <input type="text" id="lname" name="lname" value="<%=s.getLname()%>" required><br><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="<%=s.getEmail() %>"   required><br><br>
        
        <label for="mobile">Mobile:</label>
        <input type="tel" id="mobile" name="mobile" pattern="[0-9]{10}" value="<%=s.getContact() %>" required><br><br>
        
        <label>Gender:</label>
        <select id="gender" name="gender" required>
            <option value="<%=s.getGender() %>">Male</option>
            <option value="<%=s.getGender() %>">Female</option>
            
        </select><br><br>
        <input type="submit" name ="action"value="Register">
    </form>
</body>
</html>

</body>
</html>