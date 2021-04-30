import static org.junit.Assert.assertTrue;

import java.util.Set;

import dk.dtu.management.model.Accounts;
import dk.dtu.management.model.Client;
import dk.dtu.management.model.LogisticCompany;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddClientStepDefinition {

	String name;
	String email;
	String password;
	String referencePerson;
	String address;
	int id;
	LogisticCompany company = new LogisticCompany("admin","admin");
	Client client;
	Boolean success;
	
	Set<Client> filteredClients;
	Accounts users = new Accounts();
	
	//ADD client
	
	@Given("a name {string}")
	public void a_name(String string) {
	    this.name = name;
	}

	@Given("an email {string}")
	public void an_email(String string) {
		this.email = email;
	}

	@Given("a password {string}")
	public void a_password(String string) {
		 this.password = password;
	}

	@Given("a reference person {string}")
	public void a_reference_person(String string) {
		this.referencePerson = referencePerson;
	}

	@Given("an address {string}")
	public void an_address(String string) {
		 this.address = address;
	}

	@Given("a logistic company")
	public void a_logistic_company() {
		company = new LogisticCompany("email","password");
	}

	@When("add client")
	public void add_client() {
		client = new Client(name,email,referencePerson,password,address);
	    success = company.addClient(client);
	   
	}

	@Then("client list has new client")
	public void client_list_has_new_client() {
		assertTrue(success);
	    assertTrue(company.getClients().contains(client));
	}

	


}
