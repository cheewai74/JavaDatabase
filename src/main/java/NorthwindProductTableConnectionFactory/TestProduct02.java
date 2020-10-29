package NorthwindProductTableConnectionFactory;

import java.math.BigDecimal;

public class TestProduct02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String id="6"; 
		Products2 product = new Products2();
        Boolean result = product.findByPrimaryKey(id);
		if(result) {
			System.out.println("Product retrieve");
			System.out.println("Product details: \n"+product.toString());
		}
		else {
			System.out.println("Product not retrieve");
		}
			
	}

}
