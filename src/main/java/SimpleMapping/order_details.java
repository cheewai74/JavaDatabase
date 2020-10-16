package SimpleMapping;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * 
 * @author moses
 * @Database Northwind
 *
 */
public class order_details {
	
	int id;
	int order_id;
	int product_id;
	BigDecimal quantity;
    BigDecimal unit_price;
    double discount;
    int status_id;
    Date date_allocated; 
    int purchase_order_id;
    int inventory_id;

	public order_details(int id, int order_id, int product_id, BigDecimal quantity,
			             BigDecimal unit_price, double discount, int status_id,
			             Date date_allocated, int purchase_order_id, 
			             int inventory_id) {
		
		//this.id  = id;
		this.order_id = order_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.unit_price = unit_price;
		this.discount = discount;
		this.status_id = status_id;
		this.date_allocated = date_allocated; 
		this.purchase_order_id = purchase_order_id;
		this.inventory_id = inventory_id;
		
	}


	public int getId() {
		return id;
	}

	public int getOrderId() {
		return order_id;
	}
	
	
	public int getProductID() {
		return product_id;
	}
	
	public BigDecimal getQuantity() {
		return quantity;
	}
    
	public BigDecimal getUnit_price() {
		return unit_price;
	}
	
	public  double getDiscount() {
		return discount;
	}
	
	public int getStatus_id() {
		return status_id;
	}
	
	public Date getDate_allocated() {
		return date_allocated;
	}
	
	public int purchase_order_id() {
		return purchase_order_id;
	}
	
	public int inventory_id() {
		return inventory_id;
	}
	
	public String toString() {
		return new String(
				
				"id: " + Integer.toString(id) +
				"\n order_id: " + Integer.toString(order_id) +
				"\n product_id: " + Integer.toString(product_id) +
				"\n quantity: " +  quantity.toString() +
				"\n unit_price: " + unit_price.toString() +
				"\n discount: " +  Double.toString(discount) +
				"\n status_id: " +  Integer.toString(status_id) +
				"\n date_allocated: " +  date_allocated.toString()+
				"\n purchase_order_id: " +  Integer.toString(purchase_order_id) +
				"\n inventory_id: " + Integer.toString(inventory_id));
	}
	

}
