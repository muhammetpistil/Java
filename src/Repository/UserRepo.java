package Repository;

import Cards.Normal;
import Cards.Silver;
import Users.Customer;

public class UserRepo {
	
	public Customer customer1 = new Customer("Muhammet", "123", 507111, "muhammed@gmail.com", "Pendik", 13012020, new Normal(0));
	public Customer customer2 = new Customer("Anýl", "321", 537222, "anil@gmail.com", "Maltepe", 13012020, new Silver());

}
