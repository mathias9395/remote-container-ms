import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


public class Client {
	private static int idCount = 1;
	private int id;
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
		this.id = idCount;
		idCount++;
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
	public int getID() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Name: "+ name + ". Email:" + email;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Client) {
			Client compare = (Client) obj;
			return name.equals(compare.name) && email.equals(compare.email);
		}
		return false;
	}
	
	public int hashCode() {
		return new HashCodeBuilder(17,37).append(name).append(email).append(referencePerson).append(password).append(address).append(id).toHashCode();
	}
	
	

}
