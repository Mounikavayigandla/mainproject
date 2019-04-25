package com.Register.Controller;


	import java.io.*;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import register.bean.*;
	import register.DAO.RegisterDAO;
	public class DController extends HttpServlet {

		 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //Copying all the input parameters in to local variables
		 String FirstName = request.getParameter("FirstName");
		 String LastName = request.getParameter("LastName");
		 Integer Age =Integer.parseInt((String)request.getParameter("Age"));

		 String Gender = request.getParameter("Gender");
		 long ContactNumber = Long.parseLong((String)request.getParameter("ContactNumber"));
		 
		 String city = request.getParameter("city");
		 String state = request.getParameter("state");
		 String EmailAddress = request.getParameter("EmailAddress");
		 String UserId = request.getParameter("UserId");
		 String Password = request.getParameter("Password");
		 
		 DoctorBean DoctorBean = new DoctorBean();
		 //Using Java Beans - An easiest way to play with group of related data
		 DoctorBean.setFirstName(FirstName);
		 DoctorBean.setLastName(LastName);
		 DoctorBean.setAge(Age);
		 DoctorBean.setGender(Gender);
		 DoctorBean.setContactNumber(ContactNumber);
		 DoctorBean.setCity(city);
		 DoctorBean.setState(state);
		 DoctorBean.setEmailAddress(EmailAddress);
		 DoctorBean.setUserId(UserId);
		 DoctorBean.setPassword(Password); 
		 
		 RegisterDAO registerDao = new RegisterDAO();
		 
		 //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
		 String userRegistered = registerDao.Doctor(DoctorBean);
		 
		 if(userRegistered.equals("SUCCESS")) //On success, you can display a message to user on Home page
		 {
		 request.getRequestDispatcher("/home.jsp").forward(request, response);
		 }
		 else //On Failure, display a meaningful message to the User.
		 {
		 request.setAttribute("errMessage", userRegistered);
		 request.getRequestDispatcher("/patient.jsp").forward(request, response);
		 }
		 }
	}

