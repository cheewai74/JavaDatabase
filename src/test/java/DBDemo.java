import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection conn= null;
		Statement stmt=null;
		
		try {
			
			// Load the driver class
			Class.forName("org.mariadb.jdbc.Driver");
			
			// Connecting to a database
			System.out.println("Connecting to a database");
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1", "root", "password");
			System.out.println("Connecting to a database successfully");
			
			// Execute a query
			stmt = conn.createStatement();
			
		    String sql = "CREATE TABLE REGISTRATION "
                    + "(id INTEGER not NULL, "
                    + " first VARCHAR(255), "
                    + " last VARCHAR(255), "
                    + " age INTEGER, "
                    + " PRIMARY KEY ( id ))";
		    
		    stmt.executeUpdate(sql);
			System.out.println("Created a table in given database...");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(stmt!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	};

}
