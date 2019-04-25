package glucose.Controller;


	import java.io.*;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import glucose.Bean.glucoseBean;
	import glucose.DAO.glucoseDAO;
	public class glucoseController extends HttpServlet {

		 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //Copying all the input parameters in to local variables
		 Double bGlucose =Double.parseDouble((String)request.getParameter("bGlucose"));

		 
		 glucoseBean glucoseBean = new glucoseBean();
		 String p=(String) request.getSession(false).getAttribute("UserId");
		 //Using Java Beans - An easiest way to play with group of related data
		glucoseBean.setbGlucose(bGlucose);
		glucoseBean.setUserId(p);
		 
		 
		glucoseDAO glucoseDao = new glucoseDAO();
		 
		 //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
		 String userRegistered = glucoseDao.registerUser(glucoseBean);
		 
		 if(userRegistered.equals("SUCCESS")) //On success, you can display a message to user on Home page
		 {
		 request.getRequestDispatcher("/BloodCount.jsp").forward(request, response);
		 }
		 else //On Failure, display a meaningful message to the User.
		 {
		 request.setAttribute("errMessage", userRegistered);
		 request.getRequestDispatcher("/Glucose.jsp").forward(request, response);
		 }
		 }
	}
