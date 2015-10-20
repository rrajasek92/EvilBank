package EvilBank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Simple Java Program to connect Oracle database by using Oracle JDBC thin driver
 * Make sure you have Oracle JDBC thin driver in your classpath before running this program
 * @author
 */
public class transactionDB {

   
        public static void sendToDatabase(String a, Float b, String c,String d,Integer i){
    	//URL of Oracle database server
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
		PreparedStatement preStatement1 = null;
        
        String sql1 ="insert into Transaction VALUES('"+a+"', "+b+", '"+c+"',DATE '"+d+"',"+i+")";

        //creating PreparedStatement object to execute query
        try {
			 preStatement1 = conn.prepareStatement(sql1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
        try {
			ResultSet result1 = preStatement1.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
//        while(result.next()){
//            System.out.println("Current Date from Oracle : " +         result.getString("account_no"));
//        }
        System.out.println("done");
        }
      
    
}