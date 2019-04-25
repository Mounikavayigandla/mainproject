package Login.Controller;





       import java.io.*;

import javax.servlet.*;
       import javax.servlet.http.*;

       import Login.Bean.Login;
import Login.DAO.LoginDAO;
import register.bean.*;

public class LoginController extends HttpServlet {

    public LoginController() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
       //Here username and password are the names which I have given in the input box in Login.jsp page. Here I am retrieving the values entered by the user and keeping in instance variables for further use.
        
       String userName = request.getParameter("UserId");
        String password = request.getParameter("Password");
        HttpSession session = request.getSession(true);
         session.setAttribute("UserId", userName);
       Login loginBean = new Login(); //creating object for LoginBean class, which is a normal java class, contains just setters and getters. Bean classes are efficiently used in java to access user information wherever required in the application.
        
       loginBean.setUserId(userName); //setting the username and password through the loginBean object then only you can get it in future.
        loginBean.setPassword(password);
        
       LoginDAO loginDao = new LoginDAO(); //creating object for LoginDao. This class contains main logic of the application.
        
       String userValidate = loginDao.authenticateUser(loginBean); //Calling authenticateUser function
        
       if(userValidate.equals("SUCCESS")) //If function returns success string then user will be rooted to Home page
        {
        
        request.getRequestDispatcher("/New.html").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
        }
       else if(userValidate.equals("SUCCESS1"))
       {
              request.getRequestDispatcher("/Doctor1.html").forward(request, response);
       }
        else
        {
        request.setAttribute("errMessage", userValidate); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
        request.getRequestDispatcher("/Login.jsp").forward(request, response);//forwarding the request
        }
        }
        
       }


