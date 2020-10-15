import java.sql.*;

public class MakingAStatement {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
			
		// Load the driver 
		try {
			
			// Load the driver class
			Class.forName("org.mariadb.jdbc.Driver");
			
			// This defines the datasource for the driver
			String sourceURL =
					new String("jdbc:mariadb://127.0.0.1/nation");
			
			// Create connection throught the DriverManager
			Connection databaseConnection = 
					DriverManager.getConnection(sourceURL,"root","root");
			
			Statement statement = databaseConnection.createStatement();
			
			ResultSet countryNames = 
					statement.executeQuery("SELECT country_id, name " +
			                               "FROM countries");
			
			// Output the resultset data
			while (countryNames.next()) {
				System.out.println(countryNames.getInt("country_id") + " "
						           + countryNames.getString("name"));
			}
			
			//close connection
			databaseConnection.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
