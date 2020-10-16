import java.io.*;
import java.sql.*;

public class LogTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
				DriverManager.println("User Message: LogWriter. This won't be seen");
				PrintWriter log =new PrintWriter(System.out, true);
				DriverManager.setLogWriter(log);
				DriverManager.println("User Message: LogWriter set");
				
				DriverManager.println("User Message: Loading Driver");		
				Class.forName("org.mariadb.jdbc.Driver");
				DriverManager.setLoginTimeout(60);
				
				DriverManager.println("User Message: Getting Connection");
				String sourceURL = "jdbc:mariadb://127.0.0.1/northwind";
				Connection conn = DriverManager.getConnection(sourceURL, "root", "root");
				
				DriverManager.println("User Message: Setting AutoCommit and Clossing");
				conn.setAutoCommit(false);
				conn.close();
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
