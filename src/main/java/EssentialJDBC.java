import java.sql.*;

public class EssentialJDBC {

	Connection connection;
	Statement statement;
	String sourceURL = new String("jdbc:mariadb://127.0.0.1/nation");
	String queryIDAndName = 
			"SELECT country_id, name, region_id FROM countries";
	String queryWildCard = "SELECT * FROM countries";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EssentialJDBC SQLExample  = new EssentialJDBC();
		SQLExample.getResultsByColumnName();
		SQLExample.getResultsByColumnPosition();
		SQLExample.getAllColumns();
		SQLExample.closeConnection();
	}

	public EssentialJDBC() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(sourceURL,"root","root");
			statement = connection.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	void getResultsByColumnName() {
		// Execute wildcard query and output selected columns...
		try {
			ResultSet countriesResults = statement.executeQuery(queryWildCard);
			int row = 0;
			
			while(countriesResults.next()) {
				System.out.println("Row " + (++row) +") "
						+ countriesResults.getString("country_id")
						+ " "
						+ countriesResults.getString("name")
						+ " "
						+ countriesResults.getString("region_id"));			
			}
			countriesResults.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("\nSQLException.................\n");
			System.out.println("SQLState : "+ e.getSQLState());
			System.out.println("Message : "+e.getMessage());
		}
	}
	
	void getResultsByColumnPosition() {
		
		try {
			ResultSet countriesResults = statement.executeQuery(queryIDAndName);
			
			int row = 0;
			while(countriesResults.next()) {
				System.out.println("\nRow "+ (++row) +")" );
				for(int i =1; i <= 3; i++) {
					System.out.print((i>1?", ": " ")
				            +countriesResults.getString(i));
				}
			}
			countriesResults.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("\nSQLException.................\n");
			System.out.println("SQLState : "+ e.getSQLState());
			System.out.println("Message : "+e.getMessage());
		}
		
	}
	
	void getAllColumns() {
		
		// Execute wildcard query and output all columns...
		
		try {
			ResultSet countriesResults = statement.executeQuery(queryWildCard);
			
			ResultSetMetaData metadata = countriesResults.getMetaData();
			int columns = metadata.getColumnCount(); // Column count
			
			int row = 0;
			while(countriesResults.next()) {
				System.out.println("\nRow "+ (++row) +")" );
				for(int i =1; i <= columns; i++) {
					System.out.print((i>1?", ": " ")
							            +countriesResults.getString(i));
				}
			}
			countriesResults.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("\nSQLException.................\n");
			System.out.println("SQLState : "+ e.getSQLState());
			System.out.println("Message : "+e.getMessage());
		}
	}
	
	// Close Connection
	void closeConnection() {
		try {
			connection.close();
			connection = null;		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("\nSQLException.................\n");
			System.out.println("SQLState : "+ e.getSQLState());
			System.out.println("Message : "+e.getMessage());
		}
	}
	
	
}
