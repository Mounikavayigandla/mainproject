<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="bmiBean.*, java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="File.css" rel="stylesheet" type="text/css">
<style type="text/css">
</style>
</head>
<body>
<div class="container">
		<header> <big>PATIENT MONOTRING PORTAL</big> </header>
		 <br> <br><br> <br><br> <br>
<%bmi bmiBean=(bmi)session.getAttribute("bmiBean");
int pid=bmiBean.getPatient_Id();
double b=bmiBean.getBMI();
System.out.println(b);
%>
<table align="center">
<tr align="center">
<td><b><font size="3">Calculated BMI is:</font></b></td>
<td ><b><font size="3"> <%out.print(b); %></font></b></td>
</tr>
<tr>
<td></td>
<td><a href="Glucose.jsp">Submit</a></td>
<br>
</tr>
</table>
</body>
</html>