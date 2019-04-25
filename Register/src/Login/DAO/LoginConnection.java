package Login.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
public class LoginConnection {
	

	                public static Connection createConnection()
	                {
	                                Connection con = null;
	                                try 
	                                {
	                                                try 
	                                                {
	                                                                Class.forName("com.mysql.jdbc.Driver"); 
	                                                } 
	                                                catch (ClassNotFoundException e)
	                                                {
	                                                                System.out.println(e);
	                                                } 
	                                                con= DriverManager.
	                    getConnection("jdbc:mysql://localhost/patient?useSSL=false","root","root");
	                                                System.out.println("Printing connection object "+con);
	                                } 
	                                catch (Exception e) 
	                                {
	                                                e.printStackTrace();
	                                }
	                                return con; 
	                }

}
