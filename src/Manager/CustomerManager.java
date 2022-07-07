package Manager;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Users.Customer;

public class CustomerManager {
	
	Scanner input = new Scanner(System.in);
	
	public void showCustomer(List<Customer> customerList) {
		int i = 1;
		for(Customer lis: customerList) {
			System.out.println(i + "-" + lis.getName() + "  " + "Password: " + lis.getPassword() + " Phone: " + lis.getPhone());
			i++;
		}
	}
	
	public void deleteCustomer(List<Customer> customerList) {
		System.out.println("Select Customer:");
		showCustomer(customerList);
		int index = input.nextInt();
		customerList.remove(index-1);
	}
	
	public Customer findCustomer(String name, List<Customer> customers) {
		Iterator<Customer> iterator = customers.iterator();
			 while (iterator.hasNext()) {
			     Customer customer = iterator.next();
			        if (customer.getName().equals(name)) {
			            return customer;
			        }
			    }
		return null;
	}

}
