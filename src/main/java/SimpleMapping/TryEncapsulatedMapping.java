package SimpleMapping;

import java.math.BigDecimal;
import java.sql.*;

public class TryEncapsulatedMapping {
	
	Connection databaseConnection;
	String driverName;
	String sourceURL;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TryEncapsulatedMapping sqlToExample;
		
		try {
			sqlToExample = new TryEncapsulatedMapping();
			sqlToExample.listOrderDetails();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public TryEncapsulatedMapping() {
		driverName = "org.mariadb.jdbc.Driver";
		sourceURL = "jdbc:mariadb://127.0.0.1/northwind";
		try {
			Class.forName(driverName);
			databaseConnection = DriverManager.getConnection(sourceURL,"root","root");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void listOrderDetails() throws SQLException {
		order_details orderdetails;
		String query = "SELECT id, order_id, product_id, "
				+ "quantity, unit_price, discount, status_id, "
				+ "date_allocated, purchase_order_id, inventory_id "
				+ "from order_details";
		
		Statement statement = databaseConnection.createStatement();
		ResultSet orderingdetails = statement.executeQuery(query);
		
		while(orderingdetails.next()) {
			int id = orderingdetails.getInt(1);
			int order_id = orderingdetails.getInt(2);
			int product_id = orderingdetails.getInt(3);
			BigDecimal quantity = orderingdetails.getBigDecimal(4);
		    BigDecimal unit_price = orderingdetails.getBigDecimal(5);
		    double discount = orderingdetails.getDouble(6);
		    int status_id=orderingdetails.getInt(7);
		    Date date_allocated=orderingdetails.getDate(8);
		    int purchase_order_id=orderingdetails.getInt(9);
		    int inventory_id=orderingdetails.getInt(10);
		    
		    orderdetails = new order_details(id, order_id, product_id, quantity,
		             						 unit_price, discount, status_id,
		             						 date_allocated, purchase_order_id, 
		             						 inventory_id);
		    
		    System.out.println("\n"+ orderingdetails);
		}
		
		orderingdetails.close();
		databaseConnection.close();
		
	}
	



}
