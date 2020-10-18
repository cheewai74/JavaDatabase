package NorthwindProductTable;

import java.math.BigDecimal;

public class TestProduct01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String supplier_ids="6"; 
		int id=100;
		String product_code="NWTCO-100";
		String product_name="Northwind Traders Gravy"; 
		String description="(NULL)";
		BigDecimal standard_cost=BigDecimal.valueOf(7.5000);
		BigDecimal list_price=BigDecimal.valueOf(10.0000);
		int reorder_level=25; 
		int target_level=100;
		String quantity_per_unit="100";
		byte discontinued=0;
		int minimum_reorder_quantity=25;
		String category ="soups";
		byte attachments=0;
		

		Products product = new Products(supplier_ids, id, product_code, product_name, 
				  						description, standard_cost, list_price, reorder_level, 
				  						target_level, quantity_per_unit, discontinued, 
				  						minimum_reorder_quantity, category, attachments);
		
		boolean result = product.create();
		if(result) {
			System.out.println("Product registered successfully");
		}
		else {
			System.out.println("Product not registered successfully");
		}
			
	}

}
