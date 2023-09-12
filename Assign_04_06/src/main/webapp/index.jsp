<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- Write a Java program to validate jsp form server side. 
	 First Name: Only Alphabets Last Name: Only Alphabets
	 Mobile: Only 10 Numbers Email: Standard Email Id 
	 Password: Minimum One 1 Upper, Minimum 1 Lower, Minimum 1 Digit,
     Minimum 1 Special Character from @, #, $, %, _, & I2.
     Write CRUD operation using jsp only.  -->

   <h1>Registration Form</h1>
    <form action="validateServer" method="post">
        <label for="fname">First Name:</label>
        <input type="text" id="fname" name="fname" required><br><br>
        
        <label for="lname">Last Name:</label>
        <input type="text" id="lname" name="lname" required><br><br>
        
        <label for="mobile">Mobile:</label>
        <input type="tel" id="mobile" name="mobile" pattern="[0-9]{10}" required><br><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <input type="submit" name ="action" value="Register">
    </form>


</body>
</html>