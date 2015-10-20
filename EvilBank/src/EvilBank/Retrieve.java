package EvilBank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Retrieve {
	public static void retrieveDB(){
		 String url = "jdbc:oracle:thin:system/password@localhost"; 
	      
	        //properties for creating connection to Oracle database
	        Properties props = new Properties();
	        props.setProperty("user", "TestUserDB");
	        props.setProperty("password", "password");
	      
	        //creating connection to Oracle database using JDBC
	        Connection conn = null;
			try {
				conn = DriverManager.getConnection(url,props);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PreparedStatement preStatement = null;
	String sql ="select account_no,transation_amount,trans_type,dates from Transaction";

	        //creating PreparedStatement object to execute query
	        
			try {
				preStatement = conn.prepareStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	        try {
				ResultSet result = preStatement.executeQuery();
				while(result.next()){
		            System.out.println("Account Number : " +         result.getString("account_no"));
		            System.out.println("Transaction Amount : " +         result.getString("transation_amount"));
		            System.out.println("Transaction Type : " +         result.getString("trans_type"));
		            System.out.println("Date : " +         result.getString("dates"));
		            System.out.println();
		        }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        System.out.println("done");      
	}

}
