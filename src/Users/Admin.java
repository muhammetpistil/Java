package Users;

public class Admin extends User{
	private int storeID;
	
	public Admin(String name, String password, long phone, String email, int storeID) {
		super(name, password, phone, email);
		this.storeID = storeID;
	}

	public int getStoreID() {
		return storeID;
	}

	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	
	@Override
	public void updateInfo() {
		System.out.println("Please select what you want to change info");
		System.out.println("1-Name  2-Password  3-StoreID");
		int choose = input.nextInt();
		switch (choose) {
		case 1: 
			input.nextLine();
			String name = input.nextLine();
			setName(name);
			break;
		case 2: 
			input.nextLine();
			String password = input.nextLine();
			setPassword(password);
			break;	
		case 3: 
			int id = input.nextInt();
			setStoreID(id);
			break;	
		default:
			throw new IllegalArgumentException("Unexpected value: " + choose);
		}
		System.out.println("Your info successfully updated:");
		System.out.println("Name: " + getName() + " Password: " + getPassword() + " StoreID: " + getStoreID());
	}
}

