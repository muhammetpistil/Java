package ShoppingApp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class App {
	private Customer customer;
	private Admin admin;
	private TypeMember typeMem;
	private Product product;
	private int quantity;
	
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




	Scanner input = new Scanner(System.in);
	
	private List<Customer> customerList = new ArrayList<>();
	private List<Phone>    phoneList 	= new ArrayList<>();
	private List<Laptop>   laptopList   = new ArrayList<>();
	private List<Apple>    appleList    = new ArrayList<>();
	private List<Banana>   bananaList   = new ArrayList<>();
	private List<Water>    waterList    = new ArrayList<>();
	private List<Milk>     milkList     = new ArrayList<>();
	private List<Product>  proList      = new ArrayList<>();
	
	{
		createProduct();
		createUser();
	}
	public void createUser() {
		setAdmin(new Admin("admin", "1234", 1, "2", 3));
		setCustomer(new Customer("Muhammet", "123", 507111, 
				"muhammed@gmail.com", "Pendik", 13012020, new Normal(0)));
		customerList.add(getCustomer());
		setCustomer(new Customer("Anýl", "321", 537222, 
				"anil@gmail.com", "Maltepe", 13012020, new Silver()));
		customerList.add(getCustomer());
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
		customerList.add(getCustomer());
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
		for(Customer list : customerList) {
			if(findCustomer(list.getName(), customerList).getPassword().equals(password) &&
					findCustomer(list.getName(), customerList).getName().equals(name)) {
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
	
	public Admin findAdmin(String name, List<Admin> admin) {
		Iterator<Admin> iterator = admin.iterator();
			 while (iterator.hasNext()) {
			     Admin admin1 = iterator.next();
			        if (admin1.getName().equals(name)) {
			            return admin1;
			        }
			    }
		return null;
	}
	
	public void createProduct() {
		//Create Product           Name, ID, Price     			
		//Phones
		Phone samsung = new Phone("Samsung", 1122, 750);
		Phone iphone = new Phone("Iphone", 1133, 1200);
		phoneList.add(samsung); phoneList.add(iphone);
		//Laptops
		Laptop monster = new Laptop("Monster", 2211, 2000);
		Laptop asus = new Laptop("Asus", 3311, 2500);
		laptopList.add(monster); laptopList.add(asus);
		//Apples
		Apple redApple = new Apple("Red Apple", 2233, 15);
		Apple greenApple = new Apple("Green Apple", 3322, 25);
		appleList.add(greenApple); appleList.add(redApple);
		//Bananas
		Banana localBanana = new Banana("Local Banana", 1144, 45);
		Banana importedBanana = new Banana("Imported Banana", 4411, 65);
		bananaList.add(importedBanana); bananaList.add(localBanana);
		//Waters
		Water bottledWater = new Water("Bottled Water", 4422, 10);
		Water glassWater = new Water("Glass Water", 2244, 5);
		waterList.add(glassWater); waterList.add(bottledWater);
		//Milks
		Milk boxMilk = new Milk("Box Milk", 3344, 35);
		Milk dailyMilk = new Milk("Daily Milk", 4433, 55);
		milkList.add(dailyMilk); milkList.add(boxMilk);		
		
		proList.addAll(appleList);proList.addAll(bananaList);proList.addAll(laptopList);
		proList.addAll(milkList);proList.addAll(phoneList);proList.addAll(waterList);
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
				showCustomer(customerList);
				break;
			case 3: 
				deleteCustomer(customerList);
				break;
			case 4: 
				showProduct(proList);
				break;
			case 5: 
				deleteProduct(proList);
				break;
			case 6: 
				updateProduct(proList);
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
				setProduct(chooseProduct(phoneList));
				break;
			case 2:
				setProduct(chooseProduct(laptopList));
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
				setProduct(chooseProduct(appleList));
				break;
			case 2:
				setProduct(chooseProduct(bananaList));
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
				setProduct(chooseProduct(waterList));
				break;
			case 2:
				setProduct(chooseProduct(milkList));
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
			Payment.calculatePrice(getProduct(), getQuantity(), liveCustomer);
			System.out.println("**********\n1-Keep Shopping  2-Exit");
			int shop = input.nextInt();
			if(shop == 2) {
				System.out.println("We hope you come again, GoodBye :)");
				exit = false;
			}				
		}
		Payment.showPrice();
	}

	public<T1 extends Product> Product chooseProduct(List<T1> productList) {
		setProduct(listProduct(productList));
		System.out.println("Enter Quantity:");
		setQuantity(input.nextInt());
		return getProduct();
	}
	
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
	
	public<T1 extends Product> void showProduct(List<T1> productList) {
		int i = 1;
		for(T1 lis: productList) {
			System.out.println(i + "- " + lis.getName() + ": " + "Price: " + lis.getPrice());
			i++;	
		}
	}
	
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
		case 3:
			double price = input.nextInt();
			productList.get(index-1).setPrice(price);
		default:
			throw new IllegalArgumentException("Unexpected value: " + sel);
		}
	}
	
}

