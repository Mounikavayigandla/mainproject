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
		var glucose = document.form.bGlucose.value;
		
		var message = "";
		var f = false;

		if (glucose == null || glucose == "") {
			f = true;
			message += "--Enter Glucose Level\n";
			document.form.bGlucose.focus();
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
		
<form name="form"  action="glucoseController" method="post" onsubmit="return validate()">
<h3><center>Enter Glucose Level</center></h3>
<table align="center">

<tr>
<td>Blood Glucose Level</td>
<td><input type="number" step="any" name="bGlucose" pattern="[-+]?[0-9]*[.,]?[0-9]+"></td>
</tr>

<tr>
<td></td>
<td width="250"><input type="submit" name="BMI" value="Submit"></td>
</table>

</form>
</body>
</html>