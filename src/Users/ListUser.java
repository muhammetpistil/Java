package Users;

import java.util.ArrayList;
import java.util.List;

import Repository.UserRepo;

public class ListUser {
	
	private List<Customer> customerList = new ArrayList<>();
	UserRepo userRepo = new UserRepo();
	
	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	
	public void create() {
		getCustomerList().add(userRepo.customer1);
		getCustomerList().add(userRepo.customer2);
	}
}
