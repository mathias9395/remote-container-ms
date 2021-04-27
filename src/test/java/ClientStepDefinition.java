import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import dk.dtu.management.model.Accounts;
import dk.dtu.management.model.Client;
import dk.dtu.management.model.LogisticCompany;
import dk.dtu.management.model.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClientStepDefinition {
	String name;
	String email;
	String password;
	String referencePerson;
	String address;
	int id;
	LogisticCompany company;
	Client client;
	Boolean success;
	
	
	Set<Client> filteredClients;
	Accounts users = new Accounts();
	
	//SHARED CLIENT STUFF
	Client client2;
	
	
	
	@Given("a name {string}")
	public void a_name(String name) {
	    this.name = name;
	}

	@Given("an email {string}")
	public void an_email(String email) {
	    this.email = email;
	}

	@Given("a password {string}")
	public void a_password(String password) {
	    this.password = password;
	}

	@Given("a reference person {string}")
	public void a_reference_person(String referencePerson) {
	    this.referencePerson = referencePerson;
	}

	@Given("an address {string}")
	public void an_address(String address) {
	    this.address = address;
	}

	@Given("a logistic company")
	public void a_logistic_company() {
	    company = new LogisticCompany("email","password");
	}
	
	@Given("all user profiles containg a user with email {string} and password {string}")
	public void all_user_profiles(String email, String password) {
		client = new Client("name",email,"referencePerson",password,"Address");
		users.addUser(client);
	}

	@When("I login")
	public void i_login() {
	    success = users.login(email, password);
	}

	@Then("login was successful")
	public void login_was_successful() {
	    assertTrue(success);
	}
	
	@Then("login was unsuccessful")
	public void login_was_unsuccessful() {
	    assertFalse(success);
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
	
	@Given("a logistic company containing client with email {string}")
	public void a_logistic_company_containing_client_with_email(String email) {
	    Client c = new Client("name", email,"referencePerson","password", "address");
	    company = new LogisticCompany("email","password");
	    success = company.addClient(c);
	}

	@Then("client not added")
	public void client_not_added() {
		assertFalse(company.getClients().contains(client));
	    assertFalse(success);
	}
	
	@Given("a client in a logistic company client set")
	public void a_client_in_a_logistic_company_client_set() {
	    client = new Client("name","email","referencePerson","password","address");
	    company = new LogisticCompany("email","password");
	    company.addClient(client);
	}

	@When("client updated")
	public void client_updated() {
	    success = client.update(name, email, referencePerson, address);
	}

	@Then("client contains updated information")
	public void client_contains_updated_information() {
	    assertTrue(success);
	}
	
	@Given("company set containing client with email {string}")
	public void company_set_containing_client_with_email(String email) {
	    Client c = new Client("name",email,"referencePerson","password","address");
	    company.addClient(c);
	}

	@Then("client information not updated")
	public void client_information_not_updated() {
	    assertFalse(success);
	}
	
	
	@When("client is deleted")
	public void client_is_deleted() {
		company.removeClient(client);
	}

	@Then("client list does not contain client")
	public void client_list_does_not_contain_client() {
	    assertTrue(!company.getClients().contains(client));
	}
	
	@Given("client with name {string} with {string} with {string} with {string} with {string}")
	public void client_with_name_with_with_with_with(String name, String email, String referencePerson, String password, String address) {
	    client = new Client(name,email,referencePerson,password,address);
	}

	@Given("a logistic company with client set contains client")
	public void a_logistic_company_with_client_set_contains_client() {
	    company = new LogisticCompany("email","password");
	    company.addClient(client);
	}

	@When("search by name {string}")
	public void search_by_name(String name) {
	    filteredClients = company.filterClientsName(name);
	}

	@Then("filtered client set contains client")
	public void filtered_client_set_contains_client() {
	    assertTrue(filteredClients.contains(client));
	}
	
	@When("search by email {string}")
	public void search_by_email(String email) {
	    filteredClients = company.filterClientsEmail(email);
	}
	
	
	
	
	
	//SHARE DATA
	
	@Given("a client to share")
	public void a_client_to_share() {
		client = new Client("name","email","referencePerson","password","address");
	}
	@Given("a client2 that is in logistic company")
	public void a_client2_that_is_in_logistic_company() {
	    client2 = new Client("Name", "email", "referencePerson", "password", "address");
	    company = new LogisticCompany("email","password");
	    company.addClient(client2);
	}

	@When("client2 exists")
	public void client2_exists() {
		assertTrue(company.getClients().contains(client2));
	}

//	@Then("show client2 the information of client1")
//	public void show_client2_the_information_of_client1() {
//		client.addShareClients(client2);
//		company.shareData(client);
//		assertTrue((client.toString()+"\n").equals(client2.getSharedData()));
//	}
	
	@Given("a client2 that is not in logistic company")
	public void a_client2_that_is_not_in_logistic_company() {
	    client2 = new Client("Name", "email", "referencePerson", "password", "address");
	    company = new LogisticCompany("email","password");
	}

	@When("client2 does not exist")
	public void client2_does_not_exist() {
		assertFalse(company.getClients().contains(client2));
	}

//	@Then("do not show client2 the information of client1")
//	public void do_not_show_client2_the_information_of_client1() {
//		client.addShareClients(client2);
//		company.shareData(client);
//		assertTrue("" == client2.getSharedData());
//	}
	
	@When("client exists")
	public void client_exists() {
		company.addClient(client);
	    assertTrue(company.getClients().contains(client));
	}
	
	@Then("show clients data to manager")
	public void show_clients_data_to_manager() {
		assertTrue(company.getClients().contains(client));
	}
	
	@When("client doesnt exist")
	public void client_doesnt_exist() {
		assertFalse(company.getClients().contains(client));
	}
	
	@Then("do not show clients data to manager")
	public void do_not_show_clients_data_to_manager() {
		assertFalse(client.toString().equals(""));
	}
	
	@Given("a client with the email {string} and the ID {int}")
	public void a_client_with_the_email_and_the_ID(String email, Integer id) {
	    client = new Client("name",email,"reference person","password","address");
	    client.setId(id);
	}

	@Given("another client with the email {string} and the ID {int}")
	public void another_client_with_the_email_and_the_ID(String email, Integer id) {
	    client2 = new Client("name",email,"reference person","password","address");
	    client2.setId(id);
	}

	@When("I check if they are equal")
	public void i_check_if_they_are_equal() {
	    success = client.equals(client2);
	}

	@Then("the equality is true")
	public void the_equality_is_true() {
	    assertTrue(success);
	}
	
	@Then("the equality is not true")
	public void the_equality_is_not_true() {
	    assertFalse(success);
	}
	
	

	
	
}
