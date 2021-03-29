import static org.junit.Assert.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClientStepDefinition {
	
	Client client;
	LogisticCompany company = new LogisticCompany();
	Client search;
	
	String name;
	String email;
	String password;
	String referencePerson;
	String address;

	//add client
	
	@Given("a name {string}")
	public void a_name(String name) {
	    this.name = name;
	}

	@Given("an email {string}")
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
	    company.addClient(client);
	}

	@Then("client list has new client")
	public void client_list_has_new_client() {
	    assertTrue(company.getClients().containsKey(this.name));
	    Client newClient = company.getClients().get(this.name);
	    assertTrue(client == newClient);
	}

	@Then("client list contains client")
	public void client_list_contains_client() {
		company.addClient(client);
		assertTrue(company.getClients().containsKey(client));
	}
// Should probably have some message 
//	@Then("display message client already exists")
//	public void display_message_client_already_exists() {
//		assertEquals(response.getErrorMessage(),"Client already exists");
//	}
	
	// find client
	
	@Given("a name {string}")
	public void a_name_with_an_email(String name) {
	    search = company.findClient(name);
	}

	@When("client is found")
	public void client_is_found() {
	    assertEquals(this.name,search.getName());
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
	
	// update client
	@Given("a client {Client}")
	public void a_client(Client client) {
		this.client = client;
	}
	
	@When("update reference person")
	public void update_reference_person() {
	   client.setReferencePerson(referencePerson);
	}
	
	@When("update email")
	public void update_email() {
		client.setEmail(email);
	   
	}
	
	
	//remove client
	
	@Given("a name {string}")
	public void a_name1(String name) {
	    search = company.findClient(name);
	}

	@When("client is found")
	public void client_is_found1() {
	    assertEquals(this.name,search.getName());
	}

	@And("client to be deleted is selected {Client}")
	public void client_to_be_deleted_is_selected(Client client) {
	    this.client = client;
	}

	@Then("client is deleted")
	public Client deleteClient(Client client) {
	    return company.deleteClient(client);
	}
	public LogisticCompany return_new() {
	    return company;
	}
	
	// Should probably have some message 
//		@Then("display message client is deleted")
//		public void display_message_client_is_deleted() {
//			assertEquals(response.getErrorMessage(),"Client is deleted");
//		}
	
	
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
