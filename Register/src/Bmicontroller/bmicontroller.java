package Bmicontroller;

/*import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bmi.DAO.bmiDAO;
import bmiBean.bmi;

public class bmicontroller {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //Copying all the input parameters in to local variables
	Integer Height = Integer.parseInt(request.getParameter("Height"));
		 Double Weight = Double.parseDouble(request.getParameter("Weight"));
		 
		 bmi bmiBean = new bmi();
		 //Using Java Beans - An easiest way to play with group of related data
		 bmiBean.setHeight(Height);
		bmiBean.setWeight(Weight);
		
		 
		 bmiDAO bmiDao = new bmiDAO();
		 
		 //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
		 String userRegistered = bmiDao.registerUser(bmiBean);
		 
		 if(userRegistered.equals("SUCCESS")) //On success, you can display a message to user on Home page
		 {
		 request.getRequestDispatcher("/home.jsp").forward(request, response);
		 }
		 else //On Failure, display a meaningful message to the User.
		 {
		 request.setAttribute("errMessage", userRegistered);
		 request.getRequestDispatcher("/bmi.jsp").forward(request, response);
		 }
		 }
}*/
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import bmiBean.bmi;
import bmi.DAO.bmiDAO;
public class bmicontroller extends HttpServlet {

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 //Copying all the input parameters in to local variables
		 bmi registerBean = new bmi();
	 Integer Height =Integer.parseInt((String)request.getParameter("Height"));
	 Double Weight =Double.parseDouble((String)request.getParameter("Weight"));
	 
	 String p=(String) request.getSession(false).getAttribute("UserId");
	
	 //Using Java Beans - An easiest way to play with group of related data
	 registerBean.setHeight(Height);
	 registerBean.setWeight(Weight);
	 registerBean.setUserId(p);
	 
	 bmiDAO registerDao = new bmiDAO();
	 HttpSession session = request.getSession(true);
	 //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
	 bmi bmiBean = registerDao.registerUser(registerBean);
	 
	 if(bmiBean != null) //On success, you can display a message to user on Home page
	 {
		 session.setAttribute("bmiBean", bmiBean);
	 request.getRequestDispatcher("/BMIView.jsp").forward(request, response);
	 }
	 else //On Failure, display a meaningful message to the User.
	 {
	 request.setAttribute("errMessage", bmiBean);
	 request.getRequestDispatcher("/home.jsp").forward(request, response);
	 } 
}
}


