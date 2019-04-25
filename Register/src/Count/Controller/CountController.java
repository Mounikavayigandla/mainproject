package Count.Controller;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Count.Bean.*;
import Count.DAO.*;
public class CountController extends HttpServlet {
	

	


		 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //Copying all the input parameters in to local variables
		 int RBC =Integer.parseInt((String)request.getParameter("RBC"));
		 int WBC =Integer.parseInt((String)request.getParameter("WBC"));
		 int Platelet=Integer.parseInt((String)request.getParameter("Platelet"));

		 
		 Count countBean = new Count();
		 String p=(String) request.getSession(false).getAttribute("UserId");
		 //Using Java Beans - An easiest way to play with group of related data
		countBean.setRBC(RBC);
		countBean.setWBC(WBC);
		countBean.setPlatelet(Platelet);
		countBean.setUserId(p);
		 
		 
		CountDAO CountDao = new CountDAO();
		 
		 //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
		 String userRegistered =  CountDao.registerUser(countBean);
		 
		 if(userRegistered.equals("SUCCESS")) //On success, you can display a message to user on Home page
		 {
		 request.getRequestDispatcher("/Between.html").forward(request, response);
		 }
		 else //On Failure, display a meaningful message to the User.
		 {
		 request.setAttribute("errMessage", userRegistered);
		 request.getRequestDispatcher("/BloodCount.jsp").forward(request, response);
		 }
		 }
	}

