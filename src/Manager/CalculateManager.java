package Manager;

import java.text.SimpleDateFormat;
import java.util.Date;

import Inventory.Product;
import Users.Customer;

public class CalculateManager {
	private double price = 0;

	public void calculatePrice(Product product, int quantity, Customer customer) {
		Date d = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
	    int date = Integer.parseInt(sdf.format(d));
	    double money = 0;
	    
		if(customer.getType().getName().equals("Normal") && (date - customer.getDate() >= 2)){
				customer.getType().setDiscount(5);
		}
		money += product.getPrice() * (100 - customer.getType().getDiscount()) * quantity / 100;
		this.price += money;
	}
	
	public void showPrice() {
		int dis = (int)(this.price / 200);
		this.price= this.price -(dis * 5);
		System.out.println(this.price);
	}
}
