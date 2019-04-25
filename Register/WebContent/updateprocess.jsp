<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<meta http-equiv="refresh" content="3; Doctor1.html">
<%! String driverName = "com.mysql.jdbc.Driver";%>
<%! String url = "jdbc:mysql://localhost/patient";%>
<%! String user = "root";%>
<%!String psw = "root";%>
<%
String UserId = request.getParameter("UserId");
String FirstName = request.getParameter("FirstName");
String LastName =request.getParameter("LastName");
String Age = request.getParameter("Age");
String Gender = request.getParameter("Gender");
String ContactNumber = request.getParameter("ContactNumber");
String Password = request.getParameter("Password");
String city = request.getParameter("city");
String state = request.getParameter("state");
String EmailAddress = request.getParameter("EmailAddress");






if(UserId != null)
{
Connection con= null;
PreparedStatement ps = null;

try
{
Class.forName(driverName);
con = DriverManager.getConnection(url,user,psw);
String sql="Update patient_reg set FirstName=?,LastName=?,Age=?,Gender=?,ContactNumber=?,EmailAddress=?,city=?,state=?,Password=? where UserId='"+request.getParameter("UserId")+"'";   
ps = con.prepareStatement(sql);
//Making use of prepared statements here to insert bunch of data
// ps.setString(1, UserId);
ps.setString(1, FirstName);
ps.setString(2, LastName);
ps.setString(3, Age);
ps.setString(4, Gender);
ps.setString(5, ContactNumber);
ps.setString(6, EmailAddress);
ps.setString(7, city);
ps.setString(8, state);
ps.setString(9, Password);

int i = ps.executeUpdate();
if(i > 0)
{
out.print("Record Updated Successfully");
}
else
{
out.print("There is a problem in updating Record.");
} 
}
catch(SQLException sql)
{
request.setAttribute("error", sql);
out.println(sql);
}
}
%>

