import static org.junit.Assert.*;

import java.util.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClientStepDefinition {
	
	Client client;
	Client client2;
	LogisticCompany company = new LogisticCompany();
	Client search;
	
	String name;
	String email;
	String password;
	String referencePerson;
	String address;	
	Map<String, Client> clientList;
	Map<String, Client> filteredClients;
	
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

	@Given("a reference person {string}")
	public void a_reference_person(String referencePerson) {
	    this.referencePerson = referencePerson;
	}

	@Given("an address {string}")
	public void an_address(String address) {
	    this.address = address;
	}
	
	@Given("a client list")
	public void a_client_list() {
	    clientList = company.getClients();
	}

	@When("add client")
	public void add_client() {
		client = new Client(name,email,referencePerson,password,address);
	    company.addClient(client);
	}

	@Then("client list has new client")
	public void client_list_has_new_client() {
		assertTrue(company.getClients().containsKey(this.name));
	    Client newClient = company.getClients().get(this.name);
	    assertTrue(client == newClient);
	}
	
	@Given("client list containing client with name {string}")
	public void client_list_containing_client_with_name(String name) {
	    clientList = company.getClients();
	    clientList.put(name, client);
	}

	@Then("client list already contains client")
	public void client_list_already_contains_client() {
	    assertTrue(clientList.containsKey(this.name));
	}
	
	@Given("a client")
	public void a_client() {
	    client = new Client("Name", "email", "referencePerson", "password", "address");
	}

	@When("client updated")
	public void client_updated() {
	    client.update(this.name,this.email,this.referencePerson,this.address);
	}

	@Then("client contains updated information")
	public void client_contains_updated_information() {
	    assertTrue(client.getName() == this.name);
	    assertTrue(client.getEmail() == this.email);
	    assertTrue(client.getReferencePerson() == this.referencePerson);
	    assertTrue(client.getAddress() == this.address);
	}
	@When("client is deleted")
	public void client_is_deleted() {
		company.removeClient(this.name);
	}
	@Then("client list does not contain client")
	public void client_list_does_not_contain_client() {
		assertFalse(company.getClients().containsKey(name));
	}
	
	@Given("client with name {string} with {string} with {string} with {string} with {string}")
	public void client_with_name_with_with_with_with(String name, String email, String referencePerson, String password, String address) {
	    client = new Client(name,email,referencePerson,password,address);
	}

	@Given("a client list with client")
	public void a_client_list_with_client() {
	    company.addClient(client);
	}

	@When("search by name {string}")
	public void search_by_name(String name) {
	    filteredClients = company.filterClientsName(name);
	}

	@Then("filtered client list contains client")
	public void filtered_client_list_contains() {
	    assertTrue(filteredClients.containsValue(client));
	}
	
	@When("search by email {string}")
	public void search_by_email(String email) {
	    filteredClients = company.filterClientsEmail(email);
	}
	
	//Display data
	
	@When("client exists")
	public void client_exists() {
		company.addClient(client);
	    assertTrue(client.equals(company.findClient(client.getName())));
	}

	@Then("show clients data to manager")
	public void show_clients_data_to_manager() {
		assertTrue(company.findClient(client.getName()).toString().equals("Name: "+ client.getName() + ". Email:" + client.getEmail()));
	}
	
	@When("client doesnt exist")
	public void client_doesnt_exist() {
		assertFalse(client.equals(company.findClient(client.getName())));
	}

	@Then("do not show clients data to manager")
	public void do_not_show_clients_data_to_manager() {
		assertFalse(client.toString().equals(""));
	}
	
	//Sharing Data between Clients
	
	@Given("a client2 that is in logistic company")
	public void a_client2_that_is_in_logistic_company() {
	    client2 = new Client("Name", "email", "referencePerson", "password", "address");
	    company.addClient(client2);
	}

	@When("client2 exists")
	public void client2_exists() {
		assertTrue(client2.equals(company.findClient(client2.getName())));
	}

	@Then("show client2 the information of client1")
	public void show_client2_the_information_of_client1() {
		client.addShareClients(client2.getName());
		company.shareData(client);
		assertTrue((client.toString()+"\n").equals(client2.getSharedData()));
	}
	
	@Given("a client2 that is not in logistic company")
	public void a_client2_that_is_not_in_logistic_company() {
	    client2 = new Client("Name", "email", "referencePerson", "password", "address");
	}

	@When("client2 does not exist")
	public void client2_does_not_exist() {
		assertFalse(client2.equals(company.findClient(client2.getName())));
	}

	@Then("do not show client2 the information of client1")
	public void do_not_show_client2_the_information_of_client1() {
		client.addShareClients(client2.getName());
		company.shareData(client);
		assertTrue("" == client2.getSharedData());
	}

	
}
