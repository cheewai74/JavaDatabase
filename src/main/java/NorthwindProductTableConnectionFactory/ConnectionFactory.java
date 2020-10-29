package NorthwindProductTableConnectionFactory;
import java.sql.*;

public class ConnectionFactory {
	
	private static ConnectionFactory ref = new ConnectionFactory();
	
	private ConnectionFactory() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: Exception loading driver class");
		}
	}
	
	public static Connection getConnection() throws SQLException {
		String sourceURL = "jdbc:mariadb://127.0.0.1/northwind"; 
		return DriverManager.getConnection(sourceURL, "root", "root");
		
	}
	
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			// Do Nothing
		}
	}
	
	public static void close(Statement stat) {
		try {
			stat.close();
		} catch (SQLException e) {
			// Do Nothing
		}
	}
	
	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// Do Nothing
		}
	}


}
