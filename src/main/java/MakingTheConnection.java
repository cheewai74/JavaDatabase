import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MakingTheConnection {

	public static void main(String[] args) {
		
		// Load The Driver
		try {
			
			// Load the driver class
			Class.forName("org.mariadb.jdbc.Driver");
			
			// Defining the datasource for the driver
			//String sourceURL = "jdbc:mariadb://127.0.0.1/nation";
			String sourceURL = "jdbc:mariadb://127.0.0.1/northwind";
			
			// Create a connection through hte DriverManager
			Connection databaseConnection =
					DriverManager.getConnection(sourceURL,"root", "root");
			
			// We made it!
			System.out.println("Connection Established Successfully!");
			
			// close connection
			databaseConnection.close();
		}
		catch(ClassNotFoundException e) {
			System.err.println(e);
		}
		catch(SQLException e) {
			System.out.println(e);
		}
	}

}
