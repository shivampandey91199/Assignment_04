<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Verify OTP</title>
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
}
</style>

</head>
<body>

	<%
	int otp1 = (Integer) request.getAttribute("otp");
  	String msg = (String) request.getAttribute("msg");
	if (msg != null) {
		out.print(msg);
	}
	%>

	<div class="container">
		<form action="userController" method="post">
			<h2>Verify OTP</h2>
			<p>We have sent an OTP to your email. Please enter it below:</p>
			<div class="input-group">
				<input type="hidden" name="otp1" value="<%=otp1%>"> <label
					class="d-block mb-4"> <span class="form-label d-block">OTP</span>
					<input name="otp2" type="text" class="form-control"
					placeholder="Enter the OTP" required />
				</label>
			</div>
			<button name="action" type="submit" value="Verify">Verify</button>

		</form>
	</div>
</body>
</html>
