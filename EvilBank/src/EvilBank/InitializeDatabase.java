package EvilBank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class InitializeDatabase {
	public static void initDB(){

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
			String sql ="drop table Account;"+
"create table Account ("+ 
"ssn varchar(9) not null,"+
"first_name varchar(50) not null,"+
"last_name varchar(50) not null,"+
"account_no varchar(50) not null PRIMARY KEY,"+
"balance FLOAT not null"+ 
");"+
"drop table Transaction;"+
"create table Transaction ("+
"account_no varchar(50) not null,"+
"transation_amount FLOAT not null,"+
"trans_type varchar(50) not null,"+
"dates date not null,"+
"ROW_NO INTEGER not null PRIMARY KEY"+ 
");";
System.out.println(sql);
			        //creating PreparedStatement object to execute query
			        
					try {
						preStatement = conn.prepareStatement(sql);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    
			        try {
						ResultSet result = preStatement.executeQuery();
						System.out.println();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        
			        System.out.println("Initialized DB");      
			

		
	}
}
