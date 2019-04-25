package glucose.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import glucose.Bean.*;
import glucose.DAO.*;;

public class glucoseDAO {

		
		public String registerUser(glucoseBean glucosebean)
		 {
			double bGlucose=glucosebean.getbGlucose();
		 Connection con = null;
		 Statement statement = null;
		 ResultSet resultSet = null;
		 String FirstName="";
		 PreparedStatement preparedStatement = null;
		 
		 String u=glucosebean.getUserId();

			Connection con1 = null;
			ResultSet resultSet2 = null;
			ResultSet resultSet1 = null;
			int p=0;
			int q=0;
			int c=0;
			String name="";
			String glucose="";
			String glucose1="";
			String finalglucoseId="";
			
			
			try
			{
				con = glucoseConnection.createConnection();
					PreparedStatement sta = con.prepareStatement("select Patient_Id,FirstName from patient_reg where userId = ?");    
					sta.setString(1, u);    
				resultSet2 = sta.executeQuery();
				while(resultSet2.next()) 
				{
					p=resultSet2.getInt("Patient_Id");
					name=resultSet2.getString("FirstName");
				}
				
			}
			
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			
			try
			{
				con1 = glucoseConnection.createConnection();
				PreparedStatement sta1 = con1.prepareStatement("select MAX(glucose_Id) from glucosereading where Patient_Id = ?");    
				sta1.setInt(1, p);    
				resultSet1 = sta1.executeQuery();
				while(resultSet1.next()) 
				{
					glucose=resultSet1.getString("MAX(glucose_Id)");
				}
			}

			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			
			if(glucose==(null))
			{
				String p1=Integer.toString(p);
				glucose1="001";
				finalglucoseId=p1.concat(glucose1);
				
			}
			else
			{
				int lenc=glucose.length();
				glucose1=glucose.substring((lenc-3),(lenc));
				 q=Integer.parseInt(glucose1);
				 c=q+1;
				String p1=Integer.toString(p);
				if(c<10)
				finalglucoseId=p1+"00"+(Integer.toString(c));
				else if(c>10 && c<100)
				finalglucoseId=p1+"0"+(Integer.toString(c));
				else if(c>=100)
				finalglucoseId=p1+(Integer.toString(c));
			}
		 
		 try
		 {
		 con = glucoseConnection.createConnection();
		 statement = con.createStatement(); 
		 String query = "insert into glucosereading values(?,?,?,CURRENT_TIMESTAMP,?)"; //Insert user details into the table 'USERS'
		 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		 preparedStatement.setInt(1, p);
		 preparedStatement.setString(2, finalglucoseId);
		 preparedStatement.setString(3, name);
		 preparedStatement.setDouble(4, bGlucose);
		// ResultSet rs=preparedStatement.executeQuery();
        /* if(rs.next()){
                   System.out.println("UserId  available");
            
             }
         else{
            
             System.out.println("UserName is not available");
           
         }
         rs.close();*/
       
      
		 
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