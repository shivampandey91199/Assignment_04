<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Home Page || Register Page</title>


<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
}

.container {
	background-color: #fff;
	border-radius: 8px;
	padding: 20px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
	width: 300px;
}

.form-group {
	margin-bottom: 15px;
}

label {
	font-weight: bold;
	display: block;
	margin-bottom: 5px;
}

input {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
}

#password-strength {
	margin-top: 5px;
}

button {
	background-color: #007bff;
	color: #fff;
	border: none;
	padding: 10px 20px;
	border-radius: 4px;
	cursor: pointer;
	width: 100%;
}
</style>
</head>
<body>
	<div class="container">
		<h2>Registration</h2>
		<form action="userController" method="post">
			<div class="form-group">
				<label for="name">Name</label> <input type="text" id="name"
					name="name" required>
			</div>
			<div class="form-group">
				<label for="contact">Contact</label> <input type="tel" id="contact"
					name="contact" required>
			</div>
			<div class="form-group">
				<label for="email">Email</label> <input type="email" id="email"
					name="email" required>
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					id="password" name="password" required>
				<div id="password-strength"></div>
			</div>
			<button type="submit" name="action" value="Register">Register</button>
		</form>
	</div>
	<script>
		const passwordInput = document.getElementById('password');
		const passwordStrengthIndicator = document
				.getElementById('password-strength');

		passwordInput.addEventListener('input', updatePasswordStrength);

		function updatePasswordStrength() {
			const password = passwordInput.value;
			const strength = calculatePasswordStrength(password);
			const strengthText = getStrengthText(strength);

			passwordStrengthIndicator.textContent = strengthText;
			passwordStrengthIndicator.style.color = getColorForStrength(strength);
		}

		function calculatePasswordStrength(password) {
			const lengthStrength = Math.min(password.length / 6, 1);
			const uppercaseStrength = /[A-Z]/.test(password) ? 1 : 0;
			const lowercaseStrength = /[a-z]/.test(password) ? 1 : 0;
			const digitStrength = /\d/.test(password) ? 1 : 0;
			const specialCharStrength = /[^A-Za-z0-9]/.test(password) ? 1 : 0;

			return (lengthStrength + uppercaseStrength + lowercaseStrength
					+ digitStrength + specialCharStrength) / 5 * 100;
		}

		function getStrengthText(strength) {
			if (strength >= 80) {
				return 'Strong';
			} else if (strength >= 60) {
				return 'Moderate';
			} else if (strength >= 30) {
				return 'Weak';
			} else {
				return 'Very Weak';
			}
		}

		function getColorForStrength(strength) {
			if (strength >= 80) {
				return 'green';
			} else if (strength >= 60) {
				return 'orange';
			} else if (strength >= 30) {
				return 'red';
			} else {
				return 'gray';
			}
		}

		const registrationForm = document.getElementById('registrationForm');

		registrationForm.addEventListener('submit', function(event) {
			event.preventDefault();
			alert('Form submitted!');
		});
	</script>
</body>
</html>
