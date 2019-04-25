
<%@ page import="bmiBean.* ,javax.xml.parsers.*,javax.xml.transform.*, javax.xml.transform.dom.*,javax.xml.transform.stream.*,javax.xml.*,org.w3c.dom.*,bmiBean.bmi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BMI</title>
<link href="File.css" rel="stylesheet" type="text/css">
<style type="text/css">
</style>
<script>
	function validate() {
		var H = document.form.Height.value;
		var W = document.form.Weight.value;
		
		var message = "";
		var f = false;

		if (W == null || W == "") {
			f = true;
			message += "--Enter Weight\n";
			document.form.Height.focus();
		}
		if (H == null || H == "") {
			//alert("Password cannot be blank");
			f = true;
			message += "--Enter Height\n";
			document.form.Weight.focus();
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
		<br> <br> <br> <br> 
<div style="text-align: center">
<h1>BMI Calculation</h1>
</div>
<form name="form"  action="bmicontroller" method="post" onsubmit="return validate()">

<table align="center">

<tr>
<td>Height</td>
<td><input type="number"  name="Height" pattern="[-+]?[0-9]" minlength="1" maxlength="3"></td>
</tr>
<tr>
<td>Weight</td>
<td><input type="number" step="any" name="Weight" pattern="[-+]?[0-9]*[.,]?[0-9]+" minlength="1" maxlength="2"></td>
</tr>

<tr>
<td></td>
<td width="250"><input type="submit"  value="Calculate"></td>
</tr>
</table>
</form>
</html>