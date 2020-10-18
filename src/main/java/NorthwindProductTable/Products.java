/**
 * 
 *  @Database: Northwind
 *  
 * 	INSERT INTO PRODUCTS (supplier_ids, id, product_code, product_name, 
 * 							description, standard_cost, list_price, reorder_level, 
 * 							target_level, quantity_per_unit, discontinued, minimum_reorder_quantity, 
 * 							category, attachments)
 * 		VALUES supplier_ids, id product_code, product_name, 
 * 				description, standard_cost, list_price, reorder_leverl, 
 *             target_level, quantity_per_unit, discontinued, 
 *             minimum_reorder_quantity, category, attachments
 * 
 */
package NorthwindProductTable;

import java.math.BigDecimal;
import java.sql.*;

import javax.swing.JOptionPane;

public class Products {
	
	String supplier_ids=""; 
	int id;
	String product_code="";
	String product_name=""; 
	String description="";
	BigDecimal standard_cost;
	BigDecimal list_price;
	int reorder_level; 
	int target_level;
	String quantity_per_unit="";
	byte discontinued;
	int minimum_reorder_quantity;
	String category;
	byte attachments;
	
	
	public Products() {
		
	}
	
	public Products(
			String products_supplier_ids,
			int products_id,
			String products_product_code,
			String products_product_name,
			String products_description,
			BigDecimal products_standard_cost,
			BigDecimal products_list_price,
			int products_reorder_level, 
			int products_target_level,
			String products_quantity_per_unit,
			byte products_discontinued,
			int products_minimum_reorder_quantity,
			String products_category,
			byte products_attachments
	) {
		
		supplier_ids=products_supplier_ids; 
		id = products_id;
		product_code=products_product_code;
		product_name=products_product_name; 
		description=products_description;
		standard_cost=products_standard_cost;
		list_price=products_list_price;
		reorder_level=products_reorder_level; 
		target_level=products_target_level;
		quantity_per_unit=products_quantity_per_unit;
		discontinued=products_discontinued;
		minimum_reorder_quantity=products_minimum_reorder_quantity;
		category=products_category;
		attachments = products_attachments;
		
	}
	
	/**
	 * Create an entry in the database for this object.
	 */
	public boolean create() {
		int result = 0;
		Connection conn = null;
		Statement stat = null;
		
		// Load the driver class file, and create an instance of the class

		try {
			
			// Creating an instance causes the driver to register with the DriverManager
			Class.forName("org.mariadb.jdbc.Driver");
			
			// Create a url for the database and ...
			String sourceURL = "jdbc:mariadb://127.0.0.1/northwind";
			
			conn = DriverManager.getConnection(sourceURL,"root","root");
			stat = conn.createStatement();
			
			String sql = "INSERT INTO PRODUCTS " +
					     "(supplier_ids, id, product_code, product_name, "
					     + "description, standard_cost, list_price, "
					     + "reorder_level, target_level, quantity_per_unit, "
					     + "discontinued, minimum_reorder_quantity, category, "
					     + "attachments) VALUES ('"
					     +  getSupplier_ids() +"', '" 
					     +  getId()+"', "+ "'" 
					     +  getProduct_code()+"', "+"'"
					     +  getProduct_name()+"', "+"'"
					     +  getDescription()+"', " +"'"
					     +  getStandard_cost()+"', "+"'"
					     +  getList_price()+"', "+"'"
					     +  getReorder_level()+"', "+"'"
					     +  getTarget_level()+"', "+"'"
					     +  getQuantity_per_unit()+"', "+"'"
					     +  getDiscontinued()+"', "+"'"
					     +  getMinimum_reorder_quantity()+"', "+"'"
					     +  getCategory()+"', "+"'"
					     +  getAttachments()
					     +  "')";
			
			//JOptionPane.showMessageDialog(null, sql, "SQL Command",JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sql);
			result = stat.executeUpdate(sql);
						
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
			 if(stat != null) {
				 stat.close();
			 }
			 if(conn != null) {
				 conn.close();
			 }
			}
			catch(SQLException e) {
				e.printStackTrace();		
			}
		}
		
				
		return (result==1);
	}


	public String getSupplier_ids() {
		return supplier_ids;
	}

	public void setSupplier_ids(String supplier_ids) {
		this.supplier_ids = supplier_ids;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getStandard_cost() {
		return standard_cost;
	}

	public void setStandard_cost(BigDecimal standard_cost) {
		this.standard_cost = standard_cost;
	}

	public BigDecimal getList_price() {
		return list_price;
	}

	public void setList_price(BigDecimal list_price) {
		this.list_price = list_price;
	}

	public int getReorder_level() {
		return reorder_level;
	}

	public void setReorder_level(int reorder_level) {
		this.reorder_level = reorder_level;
	}

	public int getTarget_level() {
		return target_level;
	}

	public void setTarget_level(int target_level) {
		this.target_level = target_level;
	}

	public String getQuantity_per_unit() {
		return quantity_per_unit;
	}

	public void setQuantity_per_unit(String quantity_per_unit) {
		this.quantity_per_unit = quantity_per_unit;
	}

	public byte getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(byte discontinued) {
		this.discontinued = discontinued;
	}

	public int getMinimum_reorder_quantity() {
		return minimum_reorder_quantity;
	}

	public void setMinimum_reorder_quantity(int minimum_reorder_quantity) {
		this.minimum_reorder_quantity = minimum_reorder_quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public byte getAttachments() {
		return attachments;
	}

	public void setAttachments(byte attachments) {
		this.attachments = attachments;
	}
	
}
