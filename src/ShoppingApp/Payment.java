package ShoppingApp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Payment {
	static double price = 0;
    
	public static void calculatePrice(Product product, int quantity, Customer customer) {
		Date d = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
	    int date = Integer.parseInt(sdf.format(d));
	    double money = 0;
	    
		if(customer.getType().getName().equals("Normal") && (date - customer.getDate() >= 2)){
				customer.getType().setDiscount(5);
		}
		money += product.getPrice() * (100 - customer.getType().getDiscount()) * quantity / 100;
		price += money;
		
	}

	public static<T1 extends Product> Product findProduct(String name, List<T1> productList) {
		for(Product list : productList) {
			if(list.getName().equals(name))
			return list;
		}
		return null;		
	}
	
	public static void showPrice() {
		System.out.println(price);
	}

}
