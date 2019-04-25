<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="File.css" rel="stylesheet" type="text/css">
<style type="text/css">
</style>
<script>
	function validate() {
		var rbc = document.form.RBC.value;
		var wbc = document.form.WBC.value;
		var plate = document.form.Platelet.value;
		var message = "";
		var f = false;

		if (rbc == null || rbc == "") {
			f = true;
			message += "--Enter RBC\n";
			document.form.RBC.focus();
		}
		if (wbc == null || wbc == "") {
			//alert("Password cannot be blank");
			f = true;
			message += "--Enter WBC\n";
			document.form.WBC.focus();
		}
		if (plate == null || plate == "") {
			//alert("Password cannot be blank");
			f = true;
			message += "--Enter Platelet\n";
			document.form.Platelet.focus();
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
<form name="form"  action="CountController" method="post" onsubmit="return validate()">
<h2><center>BLOOD COUNT DETAILS</center></h2>
<table align="center">

<tr>
<td>RBC Count</td>
<td><input type="number"  name="RBC" pattern="[-+]?[0-9]*[.,]?[0-9]+"></td>
</tr>

<tr>
<td>WBC Count</td>
<td><input type="number"  name="WBC" pattern="[-+]?[0-9]*[.,]?[0-9]+"></td>
</tr>

<tr>
<td>Platelet Count</td>
<td><input type="number"  name="Platelet" pattern="[-+]?[0-9]*[.,]?[0-9]+"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" name="BCount" value="Submit"></td>
</table>
</form>

</body>
</html>