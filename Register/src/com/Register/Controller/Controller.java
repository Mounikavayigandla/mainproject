package com.Register.Controller;


	import java.io.*;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import register.bean.RegisterBean;
	import register.DAO.RegisterDAO;
	public class Controller extends HttpServlet {

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
		 
		 RegisterBean registerBean = new RegisterBean();
		 //Using Java Beans - An easiest way to play with group of related data
		 registerBean.setFirstName(FirstName);
		 registerBean.setLastName(LastName);
		 registerBean.setAge(Age);
		 registerBean.setGender(Gender);
		 registerBean.setContactNumber(ContactNumber);
		 registerBean.setCity(city);
		 registerBean.setState(state);
		 registerBean.setEmailAddress(EmailAddress);
		 registerBean.setUserId(UserId);
		 registerBean.setPassword(Password); 
		 
		 RegisterDAO registerDao = new RegisterDAO();
		 
		 //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
		 String userRegistered = registerDao.registerUser(registerBean);
		 
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

