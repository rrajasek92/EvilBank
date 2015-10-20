package EvilBank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class accountDB{
	public static void sendToDatabase(String a, String b, String c,String d,float i){
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
		PreparedStatement preStatement = null;
String sql ="insert into Account VALUES('"+a+"', '"+b+"', '"+c+"','"+d+"',"+i+")";

        //creating PreparedStatement object to execute query
        
		try {
			preStatement = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
        try {
			ResultSet result = preStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("done");
} 
}