package Count.DAO;
import java.sql.*;
import Count.Bean.*;
import Count.DAO.*;
import bmi.DAO.bmiconnection;
public class CountDAO {
	public String registerUser(Count countBean)
	{

		int RBC = countBean.getRBC();
		int WBC = countBean.getWBC();
		int Platelet = countBean.getPlatelet();
		Connection con = null;
		PreparedStatement preparedStatement = null;

		String u=countBean.getUserId();

		Connection con1 = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		int p=0;
		int q=0;
		int c=0;
		String name="";
		String count="";
		String count1="";
		String finalcountId="";
		
		
		try
		{
			con = CountConnection.createConnection();
			PreparedStatement sta = con.prepareStatement("select Patient_Id,FirstName from patient_reg where userId = ?");    
			sta.setString(1, u);    
			resultSet = sta.executeQuery();
			while(resultSet.next()) 
			{
				p=resultSet.getInt("Patient_Id");
				name=resultSet.getString("FirstName");
			}
			
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println(p);
		try
		{
			con1 = CountConnection.createConnection();
			PreparedStatement sta1 = con1.prepareStatement("select MAX(count_Id) from bcount where Patient_Id = ?");    
			sta1.setInt(1, p);    
			resultSet1 = sta1.executeQuery();
			while(resultSet1.next()) 
			{
				count=resultSet1.getString("MAX(count_Id)");
			}
		}

		catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println(count);
		if(count==(null))
		{
			String p1=Integer.toString(p);
			count1="001";
			finalcountId=p1.concat(count1);
			
		}
		else
		{
			int lenc=count.length();
			count1=count.substring((lenc-3),(lenc));
			 q=Integer.parseInt(count1);
			 c=q+1;
			String p1=Integer.toString(p);
			if(c<10)
			finalcountId=p1+"00"+(Integer.toString(c));
			else if(c>10 && c<100)
			finalcountId=p1+"0"+(Integer.toString(c));
			else if(c>=100)
			finalcountId=p1+(Integer.toString(c));
		}


		try
		{
			con = CountConnection.createConnection();
			String query = "insert into bcount values(?,?,?,?,?,?,CURRENT_TIMESTAMP)";
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setInt(1,p);
			preparedStatement.setString(2, finalcountId);
			preparedStatement.setString(3, name);
			preparedStatement.setInt(4, RBC);
			preparedStatement.setInt(5, WBC);
			preparedStatement.setInt(6, Platelet);
			

			



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
