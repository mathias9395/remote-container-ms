import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import dk.dtu.management.model.Client;
import dk.dtu.management.model.Container;
import dk.dtu.management.model.LogisticCompany;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogisticCompanyStepDefinition {

	//FindClient, RemoveClient
	LogisticCompany company = new LogisticCompany("admin","admin");
	Client client;
	Container container;
	String name;
	String email;
	String refPerson;
	String password;
	String address;
	Boolean success;
	Set<Container> containers;
	Set<Client> filteredSetClient;
	
	
	//Find Client
	@Given("client with name {string} with {string} with {string} with {string} with {string}")
	public void client_with_name_with_with_with_with(String string, String string2, String string3, String string4, String string5) {
	    name = string;
	    email = string2;
	    refPerson = string3;
	    password = string4;
	    address = string5;
		client = new Client(name,email,refPerson,password,address);
	}
	
	@Given("a logistic company that contains client")
	public void a_logistic_company_with_client_set_contains_client() {
	    company.addClient(client);
	}
	
	@When("search by name {string}")
	public void search_by_name(String string) {
	    filteredSetClient = company.filterClientsName(string);
	}

	@Then("filtered client set contains client")
	public void filtered_client_set_contains_client() {
	    assertTrue(filteredSetClient.contains(client));
	}

	@When("search by email {string}")
	public void search_by_email(String string) {
	   filteredSetClient = company.filterClientsEmail(string);
	}
	
	//Remove Client
	@Given("a client in a logistic company client set")
	public void a_client_in_a_logistic_company_client_set() {
		client = new Client();
		success = company.addClient(client);
	}

	@When("client is deleted")
	public void client_is_deleted() {
	    assertTrue(company.removeClient(client));
	}

	@Then("client set does not contain client")
	public void client_set_does_not_contain_client() {
	    assertFalse(company.getClients().contains(client));
	}
	
	@Given("a logistic company")
	public void a_logistic_company() {
	    company = new LogisticCompany("admin","admin");
	}
	
	@Given("a client with ID {int}")
	public void a_client_with_ID(Integer id) {
	    client = new Client("name","email","reference","password","address");
	}

	@When("the logistic company contains the client")
	public void the_logistic_company_contains_the_client() {
	    company.addClient(client);
	}

	@Then("the logistic company gets client with ID {int}")
	public void the_logistic_company_gets_client_with_ID(Integer id) {
	    Client c = company.getClientById(client.getId());
	    assertEquals(c, client);
	}

	@Given("a set of containers")
	public void a_set_of_containers() {
	    containers = new HashSet<Container>();
	    Container container1 = new Container("Copenhagen");
	    Container container2 = new Container("Singapore");
	    
	    containers.add(container1);
	    containers.add(container2);
	}

	@When("the logstic company wants to view all the containers")
	public void the_logstic_company_wants_to_view_all_the_containers() {
		company.setContainers(containers);
	}

	@Then("the logstic company should contain all the containers")
	public void the_logstic_company_should_contain_all_the_containers() {
	    for (Container c: company.getContainers()) {
	    	assertTrue(containers.contains(c));
	    }
	}
	
	@When("the logstic company does not contain the client")
	public void the_logstic_company_does_not_contain_the_client() {
	    assertFalse(company.getClients().contains(client));
	}

	@Then("the logistic company does not get client with ID {int}")
	public void the_logistic_company_does_not_get_client_with_ID(Integer id) {
	    assertNull(company.getClientById(-1));
	}
	
	@Given("a container with ID {int}")
	public void a_container_with_ID(Integer int1) {
	    container = new Container("location");
	}

	@When("the logistic company has the container")
	public void the_logistic_company_has_the_container() {
	    company.addContainer(container);
	}

	@Then("the logistic company gets container with ID {int}")
	public void the_logistic_company_gets_container_with_ID(Integer int1) {
	    assertEquals(company.getContainerById(container.getId()),container);
	}
	
	@When("the logistic company does not contain the container")
	public void the_logistic_company_does_not_contain_the_container() {
		assertFalse(company.getContainers().contains(container));
	}

	@Then("the logistic company does not get container with ID {int}")
	public void the_logistic_company_does_not_get_container_with_ID(Integer id) {
		assertNull(company.getClientById(-1));
	}

	  
	//Add client 
	@Given("the name {string}")
	public void the_name(String string) {
		this.name = string;
	}

	@Given("the email {string}")
	public void the_email(String string) {
		this.email = string;
	}

	@Given("the password {string}")
	public void the_password(String string) {
		this.password = string;
	}

	@Given("the reference person {string}")
	public void the_reference_person(String string) {
		this.refPerson = string;
	}

	@Given("the address {string}")
	public void the_address(String string) {
		this.address = string;
	}

	@When("add client")
	public void add_client() {
		client = new Client(name,email,refPerson,password,address);
		success = company.addClient(client);   
	}

	@Then("the new client is added to the company")
	public void the_new_client_is_added_to_the_company() {
		assertTrue(success);
		assertTrue(company.getClients().contains(client));
		assertTrue(client.getCompany().equals(company));
	}
		
	@Given("a logistic company containing client with email {string}")
	public void a_logistic_company_containing_client_with_email(String string) {
		company = new LogisticCompany("admin","admin");
		company.addClient(new Client("default",string,"default","default","default"));
	}

	@Then("client is not added to the company")
	public void client_not_added() {
	    success = company.addClient(client);
	    assertFalse(success);
	    assertFalse(company.getClients().contains(client));
	    assertNull(client.getCompany());
	}
	    
}
	
	


