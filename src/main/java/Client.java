
public class Client {
	
	private String name;
	private String address;
	private String referencePerson;
	private String email;
	private String password;
	
	public Client(String name, String email, String referencePerson, String password, String address) {
		this.name = name;
		this.email = email;
		this.referencePerson = referencePerson;
		this.password = password;
		this.address = address;
	}
	
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReferencePerson() {
		return referencePerson;
	}

	public void setReferencePerson(String referencePerson) {
		this.referencePerson = referencePerson;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Name: "+ name + ". Email:" + email;
	}
	
	

}
