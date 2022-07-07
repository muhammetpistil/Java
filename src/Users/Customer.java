package Users;

import Cards.Gold;
import Cards.Member;
import Cards.Normal;
import Cards.Silver;
import Cards.TypeMember;

public class Customer extends User{
	private String address;
	private int date;
	private TypeMember typeMem;
	
	public Customer(String name, String password, long phone, String email, String address, int date,
			TypeMember typeMem) {
		super(name, password, phone, email);
		this.address = address;
		this.date = date;
		this.typeMem = typeMem;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public TypeMember getType() {
		return typeMem;
	}

	public void setType(TypeMember typeMem) {
		this.typeMem = typeMem;
	}
	
	@Override
	public void updateInfo() {
		System.out.println("Please select what you want to change info");
		System.out.println("1-Name  2-Password  3-Mail  4-Phone  5-Address  6-Type Member");
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
			input.nextLine();
			String mail = input.nextLine();
			setEmail(mail);
			break;	
		case 4: 
			long phone = input.nextLong();
			setPhone(phone);
			break;
		case 5: 
			input.nextLine();
			String address = input.nextLine();
			setAddress(address);
			break;
		case 6: 
			System.out.println("Select Member Type: 1-Gold  2-Silver 3-Member 4-Normal");
			int typ = input.nextInt();
			switch (typ) {
			case 1:
				setType(new Gold());
				break;
			case 2:
				setType(new Silver());
				break;
			case 3:
				setType(new Member());
				break;
			case 4:
				setType(new Normal(0));
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + typ);
			}
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + choose);
		}
		System.out.println("Your info successfully updated:");
		System.out.println("Name: " + getName() + " Password: " + getPassword() + "Type Member" + getType() 
							+ "Email: " + getEmail() + "Phone: " + getPhone() + "Address: " + getAddress());
		
	}
}

