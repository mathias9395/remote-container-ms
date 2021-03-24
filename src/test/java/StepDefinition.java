import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	
	Client client;
	LogisticCompany company = new LogisticCompany();
	ResponseObject response;
	Client search;
	
	String name;
	String email;
	String password;
	String referencePerson;
	String address;

	@Given("a name {string}")
	public void a_name(String name) {
	    this.name = name;
	}

	@Given("a email {string}")
	public void a_email(String email) {
	    this.email = email;
	}

	@Given("a password {string}")
	public void a_password(String password) {
	    this.password = password;
	}
	
	@Given("an address {string}")
	public void an_address(String address) {
		this.address = address;
	}
	@Given("a reference person {string}")
	public void a_reference_person(String referencePerson) {
		this.referencePerson = referencePerson;
	}

	@When("add client")
	public void add_client() {
		client = new Client(name, email, referencePerson, password, address);
	    response = company.addClient(client);
	}

	@Then("client list has new client")
	public void client_list_has_new_client() {
	    assertTrue(company.getClients().contains(client));
	}

	@Then("display message client was created")
	public void display_message_client_was_created() {
		assertEquals(response.getErrorMessage(),"Client successfuly created");
	    
	}
	@Then("client list contains client")
	public void client_list_contains_client() {
		response = company.addClient(client);
		assertTrue(company.getClients().contains(client));
	}

	@Then("display message client already exists")
	public void display_message_client_already_exists() {
		assertEquals(response.getErrorMessage(),"Client already exists");
	}
	
	
	
	
	
	
	

	@Given("a name {string} with an email {string}")
	public void a_name_with_an_email(String name, String email) {
	    search = company.findClient(name,email);
	}

	@When("client is found")
	public void client_is_found() {
	    assertEquals(client,search);
	}

	@Then("return client")
	public Client return_client() {
	    return client;
	}
	
	@When("client is not found")
	public void client_is_not_found() {
		assertEquals(null,search);
	}

	@Then("return null")
	public Client return_null() {
	    return null;
	}
	
	
	
	
	
//	
//	@Given("a client {email} with {name}")
//	public void a_client(String email, String name) {
//	    client = company.findClient(name, email);
//	}
//
//	@When("update client information")
//	public void update_client_information() {
//	    response = new ResponseObject("Update successful");
//	}
//
//	@Then("display successfully updated")
//	public void display_successfully_updated() {
//	    assertEquals(response, "Update successful");
//	}
	
	
}
