package register.DAO;

	import java.sql.*;
	import java.util.*;
	import register.bean.*;
	import register.DAO.DBConnection;
	public class RegisterDAO {

		
		public String registerUser(RegisterBean registerBean)
		 {
		 String FirstName = registerBean.getFirstName();
		 String LastName = registerBean.getLastName();
		 int Age = registerBean.getAge();
		 String Gender = registerBean.getGender();
		 long ContactNumber = registerBean.getContactNumber();
		 String city = registerBean.getCity();
		 String state = registerBean.getState();
		 String EmailAddress = registerBean.getEmailAddress();
		 String UserId = registerBean.getUserId();
		 String Password = registerBean.getPassword();
		 
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 PreparedStatement preparedStatement1 = null;
		 try
		 {
		 con = DBConnection.createConnection();
		 String query = "insert into patient_reg(FirstName,LastName,Age,Gender,ContactNumber,EmailAddress,city,state,userId,Password) values (?,?,?,?,?,?,?,?,?,?)"; 
		 preparedStatement = con.prepareStatement(query);
		 //Making use of prepared statements here to insert bunch of data
		 preparedStatement.setString(1, FirstName);
		 preparedStatement.setString(2, LastName);
		 preparedStatement.setInt(3, Age);
		 preparedStatement.setString(4, Gender);
		 preparedStatement.setLong(5, ContactNumber);
		 preparedStatement.setString(6, EmailAddress);
		 preparedStatement.setString(7, city);
		 preparedStatement.setString(8, state);
		 preparedStatement.setString(9, UserId);
		 preparedStatement.setString(10, Password);
		 int i= preparedStatement.executeUpdate();
		 String query1 = "insert into register(FirstName,LastName,Age,Gender,ContactNumber,EmailAddress,city,state,userId,Password,role) values (?,?,?,?,?,?,?,?,?,?,?)";
		 preparedStatement1 = con.prepareStatement(query1);
		 preparedStatement1.setString(1, FirstName);
		 preparedStatement1.setString(2, LastName);
		 preparedStatement1.setInt(3, Age);
		 preparedStatement1.setString(4, Gender);
		 preparedStatement1.setLong(5, ContactNumber);
		 preparedStatement1.setString(6, EmailAddress);
		 preparedStatement1.setString(7, city);
		 preparedStatement1.setString(8, state);
		 preparedStatement1.setString(9, UserId);
		 preparedStatement1.setString(10, Password);
		 preparedStatement1.setString(11, "Patient");
		 int i1= preparedStatement1.executeUpdate();
		 
		 if (i!=0 && i1!=0) 
		 return "SUCCESS";
		 }
		 catch(SQLException e)
		 {
			 
			 e.printStackTrace();
		
		 }
		 
		  return "Oops.. Something went wrong there..!"; // On failure, send a message from here.
		 }
		
		
		
		public String Doctor(DoctorBean DoctorBean)
		 {
		 String FirstName = DoctorBean.getFirstName();
		 String LastName = DoctorBean.getLastName();
		 int Age = DoctorBean.getAge();
		 String Gender = DoctorBean.getGender();
		 long ContactNumber = DoctorBean.getContactNumber();
		 String city = DoctorBean.getCity();
		 String state = DoctorBean.getState();
		 String EmailAddress = DoctorBean.getEmailAddress();
		 String UserId = DoctorBean.getUserId();
		 String Password = DoctorBean.getPassword();
		 
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 
		 try
		 {
		 con = DBConnection.createConnection();
		 String query = "insert into register(FirstName,LastName,Age,Gender,ContactNumber,EmailAddress,city,state,userId,Password,role) values (?,?,?,?,?,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
		 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		 preparedStatement.setString(1, FirstName);
		 preparedStatement.setString(2, LastName);
		 preparedStatement.setInt(3, Age);
		 preparedStatement.setString(4, Gender);
		 preparedStatement.setLong(5, ContactNumber);
		 preparedStatement.setString(6, EmailAddress);
		 preparedStatement.setString(7, city);
		 preparedStatement.setString(8, state);
		 preparedStatement.setString(9, UserId);
		 preparedStatement.setString(10, Password);
		 preparedStatement.setString(11, "Doctor");
      
     
		 
		 int i= preparedStatement.executeUpdate();
		 
		 if (i!=0) 
		 return "SUCCESS";
		 }
		 catch(SQLException e)
		 {
			 
			 e.printStackTrace();
		
		 }
		 
		  return "Oops.. Something went wrong there..!"; // On failure, send a message from here.
		 }
		
		
	}



