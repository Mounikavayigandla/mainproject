package glucose.DAO;
import java.sql.*;
public class glucoseConnection {
	public static Connection createConnection()
	{
	Connection con=null;
	try
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
        {
                        e.printStackTrace();
        } 
        con= DriverManager.
getConnection("jdbc:mysql://localhost/patient?","root","root");
        System.out.println("Printing connection object "+con);
} 
catch (Exception e) 
{
        e.printStackTrace();
}
return con; 
}
}


