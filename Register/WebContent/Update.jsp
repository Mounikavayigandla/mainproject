<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>



<%
	String UserId = request.getParameter("UserId");
	String driver = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost/";
	String database = "patient";
	String userid = "root";
	String password = "root";
	//String id = request.getParameter("UserId");
	try {
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
%>
<html>
<head>
<link href="File.css" rel="stylesheet" type="text/css">
<style type="text/css">
</style>
</head>
<body>
	<div class="container">
		<header> <big>PATIENT MONOTRING PORTAL</big> </header>
		<br> <br>
		<h5>
			<font color="red">Click On Update To Update Profile</font>
		</h5>
<h3><center>UPDATE PROFILE</center></h3>

		<table id="myTable">
			<table border="1">
				<tr>
					<td>UserId</td>
					<td>FirstName</td>
					<td>LastName</td>
					<td>Age</td>
					<td>Gender</td>
					<td>ContactNumber</td>
					<td>EmailAddress</td>
					<td>city</td>
					<td>state</td>
					<td>Password</td>
					<td width="150">update</td>
				</tr>


				<%
					try {
						connection = DriverManager.getConnection(connectionUrl + database, userid, password);
						statement = connection.createStatement();

						String sql = "select * from patient_reg";

						resultSet = statement.executeQuery(sql);
						while (resultSet.next()) {
				%>

				<tr>
					<td><input type="text" name="UserId"
						value="<%=resultSet.getString("UserId")%>"></td>
					<td><%=resultSet.getString("FirstName")%></td>
					<td><%=resultSet.getString("LastName")%></td>
					<td><%=resultSet.getInt("Age")%></td>
					<td><%=resultSet.getString("Gender")%></td>
					<td><%=resultSet.getLong("ContactNumber")%></td>
					<td><%=resultSet.getString("EmailAddress")%></td>
					<td><%=resultSet.getString("city")%></td>
					<td><%=resultSet.getString("state")%></td>
					<td><%=resultSet.getString("Password")%></td>
					<td><a
						href="Next.jsp?UserId=<%=resultSet.getString("UserId")%>">update</a></td>

				</tr>






				<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
			</table>
</body>
</html>

