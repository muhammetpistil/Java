package Users;

import java.util.Scanner;

public abstract class User {
	private String name;
	private String password;
	private long phone;
	private String email;
	
	Scanner input = new Scanner(System.in);
	
	public User(String name, String password, long phone, String email) {
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}		
	public abstract void updateInfo();
}

