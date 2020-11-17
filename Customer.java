package customer;

public class Customer {
	private String username;
	private String password;
	private String email;
	private String name;
	private String address;
	private String phoneNumber;
	private float balance;
	
	Customer(String username, String password, String email){
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	//setter function for username
	public void setUsername(String username) {
		this.username = username;
	}
	
	//setter function for password
	public String getUsername() {
		return this.username;
	}
	
	//setter function for password
	public void setPassword(String s) {
		this.password = s;
	}
	
	//getter function for password
	public String getPassword() {
		return this.password;
	}
	
	//setter function for email
	public void setEmail(String s) {
		this.email = s;
	}
				
	//getter function for email
	public String getEmail() {
		return this.email;
	}
	
	//setter function for name
	public void setName(String s) {
		this.name = s;
	}
	
	//getter function for name
	public String getName() {
		return this.name;
	}
	
	//setter function for address
	public void setAddress(String s) {
		this.address = s;
	}
	
	//getter function for address
	public String getAddress() {
		return this.address;
	}
	
	//setter function for phoneNumber
	public void setPhoneNumber(String s) {
		this.phoneNumber = s;
	}
		
	//getter function for confirmPassword
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	//setter function for balance
	public void setBalance(float f) {
		this.balance = f;
	}
			
	//getter function for balance
	public float getBalance() {
		return this.balance;
	}

}
