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
public class OracleJdbcExample {

    public static void main(String args[]) throws SQLException {
        //URL of Oracle database server
        String url = "jdbc:oracle:thin:system/password@localhost"; 
      
        //properties for creating connection to Oracle database
        Properties props = new Properties();
        props.setProperty("user", "TestUserDB");
        props.setProperty("password", "password");
      
        //creating connection to Oracle database using JDBC
        Connection conn = DriverManager.getConnection(url,props);

        String sql ="insert into Account VALUES('110909', 'roshan', 'rajasekharan',1111,1000)";

        //creating PreparedStatement object to execute query
        PreparedStatement preStatement = conn.prepareStatement(sql);
    
        ResultSet result = preStatement.executeQuery();
        
        String sql1 ="insert into Transaction VALUES('1234', 10, 'Check',DATE '2008-11-11',1)";

        //creating PreparedStatement object to execute query
        PreparedStatement preStatement1 = conn.prepareStatement(sql1);
    
        ResultSet result1 = preStatement.executeQuery();
      
//        while(result.next()){
//            System.out.println("Current Date from Oracle : " +         result.getString("account_no"));
//        }
        System.out.println("done");
      
    }
}