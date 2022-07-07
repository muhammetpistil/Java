package Manager;

import java.util.List;
import java.util.Scanner;

import Inventory.Product;

public class ProductManager {
	
	Scanner input = new Scanner(System.in);
	
	public<T1 extends Product> Product listProduct(List<T1> productList) {
		int i = 1;
		for(T1 lis: productList) {
			System.out.println(i + "- " + lis.getName() + ": " + "Price: " + lis.getPrice());
			i++;	
		}
		int choose = input.nextInt();
		for(T1 lis: productList) {
			if(productList.get(choose-1).getName().equals(lis.getName())) {
				return lis;
			}	
		}
		return null;
	}
	
	public void showProduct(List<Product> productList) {
		int i = 1;
		for(Product lis: productList) {
			System.out.println(i + "- " + lis.getName() + ": " + "Price: " + lis.getPrice());
			i++;	
		}
	}
	
	public void deleteProduct(List<Product> productList) {
		System.out.println("Select Product:");
		showProduct(productList);
		int index = input.nextInt();
		productList.remove(index-1);
	}
	
	public void updateProduct(List<Product> productList) {
		System.out.println("Select Product:");
		showProduct(productList);
		int index = input.nextInt();
		System.out.println("Select what you want: 1-Name  2-ID  3-Price");
		int sel = input.nextInt();
		switch (sel) {
		case 1:
			input.nextLine();
			String name = input.nextLine();
			productList.get(index-1).setName(name);
			break;
		case 2:
			int id = input.nextInt();
			productList.get(index-1).setId(id);
			break;
		case 3:
			double price = input.nextInt();
			productList.get(index-1).setPrice(price);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + sel);
		}
	}

}
