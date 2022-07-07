package App;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Cards.Gold;
import Cards.Member;
import Cards.Normal;
import Cards.Silver;
import Cards.TypeMember;
import Inventory.ListInventory;
import Inventory.Product;
import Manager.CalculateManager;
import Manager.CustomerManager;
import Manager.ProductManager;
import Users.Admin;
import Users.Customer;
import Users.ListUser;

public class App {
	private Customer customer;
	private Admin admin;
	private TypeMember typeMem;
	private Product product;
	private int quantity;

	Scanner input = new Scanner(System.in);
	ProductManager productManager = new ProductManager();
	CustomerManager customerManager = new CustomerManager();
	ListInventory listInventory = new ListInventory();
	ListUser listUser = new ListUser();
	CalculateManager calculateManager = new CalculateManager();
	
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public TypeMember getTypeMem() {
		return typeMem;
	}

	public void setTypeMem(TypeMember typeMem) {
		this.typeMem = typeMem;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	{
		createProduct();
		createUser();
	}
	
	public void createProduct() {			
		listInventory.create();
	}
	
	public void createUser() {
		setAdmin(new Admin("admin", "1234", 1, "2", 3));
		listUser.create();
	}
	
	public void start()
	{
		boolean select = true;
		while(select) {
			System.out.println("Please Select:");
			System.out.println("1- Login");
			System.out.println("2- Register");
			int entry = 0;
			try {
				entry = input.nextInt();
			}catch(Exception e) {
				System.out.println("Please enter a valid value");
				input.next();
			}
			switch (entry) {
			case 1:
				select = false;
				login();
				break;
			case 2:
				select = false;
				register();
				break;
			default:
				System.out.println("Invalid select, please try again");
				break;
			}
		}
	}
	
	public void register() {  
		Date d = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
	    int date = Integer.parseInt(sdf.format(d));
	    System.out.println(date);
		System.out.println("Name:");
		input.nextLine();
		String name = input.nextLine();
		System.out.println("Password:");
		String password = input.nextLine();
		System.out.println("Phone number:");
		long phone = input.nextLong();
		System.out.println("Email:");
		input.nextLine();
		String email = input.nextLine();
		System.out.println("Address::");
		String address = input.nextLine();
		
		boolean select = true;
		while(select) {
			System.out.println("___Select Member Type___\n 1-Gold  2-Silver 3-Member 4-Normal");
			int selectCard = 0;
			try {
				selectCard = input.nextInt();
			}catch(Exception e) {
				System.out.println("Please enter a valid value");
				input.next();
			}
			switch (selectCard) {
			case 1: 
				select = false;
				setTypeMem(new Gold());
				break;
			case 2: 
				select = false;
				setTypeMem(new Silver());
				break;
			case 3: 
				select = false;
				setTypeMem(new Member());
				break;
			case 4: 
				select = false;
				setTypeMem(new Normal(0));
				break;
			default:
				System.out.println("Invalid select, please try again");
				break;
			}
		}
		setCustomer(new Customer(name, password, phone, email, address, date, getTypeMem()));
		listUser.getCustomerList().add(getCustomer());
		System.out.println(getCustomer().getName() +" "+getCustomer().getPassword()+" "+getCustomer().getPhone()+" "+getCustomer().getEmail()+" "
				+ getCustomer().getAddress()+" "+getCustomer().getDate()+" "+getCustomer().getType().getName());
		System.out.println("Registered successfully, please login");
		start();
	}
	
	public void login() {
		System.out.println("*********LOGIN**********");
		System.out.println("Name:");
		input.nextLine();
		String name = input.nextLine();
		System.out.println("Password:");
		String password = input.nextLine();
		boolean isList = true;
		for(Customer list : listUser.getCustomerList()) {
			if(customerManager.findCustomer(list.getName(), listUser.getCustomerList()).getPassword().equals(password) &&
					customerManager.findCustomer(list.getName(), listUser.getCustomerList()).getName().equals(name)) {
				System.out.println("**********Login Successfully**********");
				isList= false;
				customerMenu(list);
				break;
			}
		}
		if(getAdmin().getName().equals(name) && getAdmin().getPassword().equals(password)) {
			System.out.println("**********Login Successfully**********");
			isList= false;
			adminMenu(getAdmin());
		}
		if(isList) {
			System.out.println("###Wrong name or password, please try again!###");
			start();
		}
	}

	public void customerMenu(Customer liveCustomer) {
		boolean exit = true;
		while(exit) {
			System.out.println("Select process:\n1-Shopping  2-Update Info");
			int sel = 0;
			try {
				sel = input.nextInt();
			}catch(Exception e) {
				System.out.println("###Please enter a valid value###");
				input.next();
			}
			switch (sel) {
			case 1:
				exit = false;
				selectProduct(liveCustomer);
				break;
			case 2: 
				exit = false;
				liveCustomer.updateInfo();
				login();
				break;	
			default:
				System.out.println("###Invalid select, please try again###");
				break;
			}
		}
		
	}
	public void adminMenu(Admin liveAdmin) {
		boolean exit = true;
		while(exit) {
			System.out.println("___Select Process___\n1-Update Info\n2-Show Customer\n3-Delete Customer"
								+ "\n4-Show Product\n5-Delete Product\n6-Update Product\n7-Exit");
			int selProcess = 0;
			try {
				selProcess = input.nextInt();
			}catch(Exception e) {
				System.out.println("###Please enter a valid value###");
				input.next();
			}
			switch (selProcess) {
			case 1: 
				liveAdmin.updateInfo();
				break;
			case 2: 
				customerManager.showCustomer(listUser.getCustomerList());
				break;
			case 3: 
				customerManager.deleteCustomer(listUser.getCustomerList());
				break;
			case 4: 
				productManager.showProduct(listInventory.getProList());
				break;
			case 5: 
				productManager.deleteProduct(listInventory.getProList());
				break;
			case 6: 
				productManager.updateProduct(listInventory.getProList());
				break;
			case 7: 
				start();
				break;
			default:
				System.out.println("###Invalid select, please try again###");
				break;
			}
			System.out.println("**************************\n1-Keep 2-Exit");
			int keep = input.nextInt();
			if(keep == 2) {
				System.out.println("Thank you :)");
				exit = false;
			}			
		}
		start();
	}
	
	
	public void productMenu() {
		System.out.println("___Select Category___\n1-Electronic  2-Grocery  3-Beverage");
		int sel = 0;
		int selCategory = input.nextInt();
		System.out.println("Please choose product from list:");
		switch (selCategory) {
		case 1:
			System.out.println("1-Phone 2-Laptop");
		    sel = input.nextInt();
			switch (sel) {
			case 1: 
				setProduct(chooseProduct(listInventory.getPhoneList()));
				break;
			case 2:
				setProduct(chooseProduct(listInventory.getLaptopList()));
				break;
			default:
				System.out.println("###Invalid select, please try again###");
				break;
			}
			break;
		case 2:
			System.out.println("1-Apple 2-Banana");
			sel = input.nextInt();
			switch (sel) {
			case 1:
				setProduct(chooseProduct(listInventory.getAppleList()));
				break;
			case 2:
				setProduct(chooseProduct(listInventory.getBananaList()));
				break;
			default:
				System.out.println("Invalid select, please try again");
				break;
			}
			break;
		case 3:
			System.out.println("1-Water 2-Milk");
			sel = input.nextInt();
			switch (sel) {
			case 1:
				setProduct(chooseProduct(listInventory.getWaterList()));
				break;
			case 2:
				setProduct(chooseProduct(listInventory.getMilkList()));
				break;
			default:
				System.out.println("Invalid select, please try again");
				break;
			}
			break;
		default:
			System.out.println("Invalid select, please try again");
			break;
		}
		
	}
	
	public void selectProduct(Customer liveCustomer) {
		boolean exit = true;
		while(exit) {
			productMenu();
			calculateManager.calculatePrice(getProduct(), getQuantity(), liveCustomer);
			System.out.println("**********\n1-Keep Shopping  2-Exit");
			int shop = input.nextInt();
			if(shop == 2) {
				System.out.println("We hope you come again, GoodBye :)");
				exit = false;
			}				
		}
		calculateManager.showPrice();
	}

	public<T1 extends Product> Product chooseProduct(List<T1> productList) {
		setProduct(productManager.listProduct(productList));
		System.out.println("Enter Quantity:");
		setQuantity(input.nextInt());
		return getProduct();
	}
	
}

