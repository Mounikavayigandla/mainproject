<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Register</title>
<link href="File.css" rel="stylesheet" type="text/css">
<style type="text/css">
</style>
<script>
	function validate() {
		var UserId = document.form.UserId.value;
		var Password = document.form.Password.value;
		var FirstName = document.form.FirstName.value;
		var LastName = document.form.LastName.value;
		var Age = document.form.Age.value;
		var Gender = document.form.Gender.value;
		var ContactNumber = document.form.ContactNumber.value;
		var EmailAddress = document.form.EmailAddress.value;
		var City = document.form.city.value;
		var State = document.form.state.value;
		var message = "";
		var f = false;
		
		
		if (UserId == null || UserId == "") {
			f = true;
			message += "--Enter userId\n";
			document.form.UserId.focus();
		}
		if (Password == null || Password == "") {
			//alert("Password cannot be blank");
			f = true;
			message += "--Enter password\n";
			document.form.Password.focus();
		}

		if (LastName == null || LastName == "") {
			//alert("Last Name cannot be blank");
			f = true;
			message += "--Enter Last Name\n";
			document.form.LastName.focus();
		}
		if (FirstName == null || FirstName == "") {
			//alert("First Name cannot be blank");
			f = true;
			message += "--Enter First Name\n";
			document.form.FirstName.focus();
		}
		if (Age == null || Age == "") {
			//alert("First Name cannot be blank");
			f = true;
			message += "--Enter Age\n";
			document.form.FirstName.focus();
		}
		if (form.Gender.selectedIndex == 0) {
			//alert("First Name cannot be blank");
			f = true;
			message += "--Select Gender\n";
			document.form.FirstName.focus();
		}
		if (ContactNumber == null || ContactNumber == "") {
			//alert("First Name cannot be blank");
			f = true;
			message += "--Enter Contact Number\n";
			document.form.FirstName.focus();
		}

		if (EmailAddress == null || EmailAddress == "") {
			//alert("First Name cannot be blank");
			f = true;
			message += "--Enter EmailAddress\n";
			document.form.FirstName.focus();
		}

		if (City == null || City == "") {
			//alert("First Name cannot be blank");
			f = true;
			message += "--Enter City\n";
			document.form.FirstName.focus();
		}
		if (State == null || State == "") {
			//alert("First Name cannot be blank");
			f = true;
			message += "--Enter State\n";
			document.form.FirstName.focus();
		}

		if (f) {
			alert(message);
			return false;
		}
		return true;
	}
</script>
</head>
<body>

	<div class="container">
		<header> <big>PATIENT MONOTRING PORTAL</big> </header>
		<br> <br> <br> <br> <br> <br>
		<div style="text-align: center"></div>
		<form name="form" action="Controller" method="post"
			onsubmit="return validate()">
			<H2>
				<center>Patient Registration</center>
			</H2>
			<table align="center">


				<tr>
					<td>First Name</td>
					<td><input type="text" name="FirstName"
						pattern="(?=.*[a-z])(?=.*[A-Z]).{1,20}"
						title="Must contain at least one uppercase and lowercase letter, and at least 2 characters"></td>
				</tr>

				<tr>
					<td>Last Name</td>
					<td><input type="text" name="LastName"
						pattern="(?=.*[a-z])(?=.*[A-Z]).{1,20}"
						title="Must contain at least one uppercase and lowercase letter, and at least 2 or more characters"></td>
				</tr>

				<tr>
					<td>Age</td>
					<td><input type="text" name="Age"
						pattern="[-+]?[0-9]*[.,]?[0-9]+" minlength="1" maxlength="2"
						title="Must contain atleast one or two digits"></td>
				</tr>

				<tr>
					<td>Gender</td>
					<td><select name="Gender">
							<option value="select">Select</option>
							<option value="Male">Male</option>
							<option value="Female">Female</option>
					</select></td>
				</tr>

				<tr>
					<td>Contact Number</td>
					<td><input type="text" name="ContactNumber"
						pattern="[-+]?[0-9]*[.,]?[0-9]+" minlength="10" maxlength="12"
						title="Must contain atleast ten and maximum of twelve digits"></td>

				</tr>

				<tr>
					<td>Email Address</td>
					<td><input type="text" name="EmailAddress"
						pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
						title="Must contain a character followed by digit,@,. and maximum of 15 length"></td>
				</tr>

				<tr>
					<td>City</td>
					<td><input type="text" name="city"></td>
				</tr>

				<tr>
					<td>State</td>
					<td><input type="text" name="state"></td>
				</tr>

				<tr>
					<td>User Id</td>
					<td><input type="text" name="UserId"
						pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{5,15}"
						title="Must contain at least one number and one uppercase and lowercase letter, and at least 5 length"></td>
				</tr>

				<tr>
					<td>Password</td>
					<td><input type="password" name="Password"
						pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{5,}"
						title="Must contain at least one number and one uppercase and lowercase letter, and at least 5 length"></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Submit"></input></td>
				</tr>
			</table>

		</form>
</body>
</html>

