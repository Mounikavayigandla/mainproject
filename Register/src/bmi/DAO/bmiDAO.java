package bmi.DAO;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import bmiBean.bmi;
import bmi.DAO.bmiconnection;
public class bmiDAO {

		
		public bmi registerUser(bmi bmiBean)
		 {
			int Height=bmiBean.getHeight();
			double Weight=bmiBean.getWeight();
			
		 double height=Height*0.01;
			double BMIRate=Weight/(Math.pow(height,2));
			bmiBean.setBMI(BMIRate);

		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 
		 String u=bmiBean.getUserId();
		
		 Connection con1 = null;
         ResultSet resultSet = null;
         
int p=0;
String name="";
		 try
         {
                         con1 = bmiconnection.createConnection(); 
                         PreparedStatement sta = con1.prepareStatement("select Patient_Id,FirstName from patient_reg where userId = ?");    
                         sta.setString(1, u);    
                          resultSet = sta.executeQuery();
                         while(resultSet.next()) 
                         {
                                     p=resultSet.getInt("Patient_Id");
                                     bmiBean.setPatient_Id(p);
                                          name=resultSet.getString("FirstName");
                                          
                         }
         }
		 
                         catch(SQLException e)
                         {
                                         e.printStackTrace();
                         }
		
try
{
con = bmiconnection.createConnection();
String query = "insert into bmi values(?,?,?,?,?)"; //Insert user details into the table 'USERS'
preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
preparedStatement.setInt(1, p);
preparedStatement.setString(2, name);
preparedStatement.setInt(3,Height);
preparedStatement.setDouble(4, Weight);
preparedStatement.setDouble(5, BMIRate);
int i= preparedStatement.executeUpdate();
if (i!=0)
	return bmiBean;
//return "SUCCESS";
}
catch(SQLException e)
{
e.printStackTrace();
}
		 return bmiBean=null;
		  //return "Oops.. Something went wrong there..!"; // On failure, send a message from here.
		 }
	}
