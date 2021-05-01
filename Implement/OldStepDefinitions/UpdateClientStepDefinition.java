import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import dk.dtu.management.model.Client;
import dk.dtu.management.model.LogisticCompany;

public class UpdateClientStepDefinition {
	
	LogisticCompany company;
	Client client;
	String name;
	String email;
	String refPerson;
	String address;
	Boolean success;
	
	
	
	@Given("a client")
	public void a_client3() {
	    client = new Client("Nima", "n.gmail.com", "Nick", "password","street123");
	    company = new LogisticCompany("Admin", "Admin");
	    company.addClient(client);
	}

	@Given("a name {string}")
	public void a_name3(String name) {
	    this.name = name;
	}

	@Given("an email {string}")
	public void an_email3(String email) {
	    this.email = email;
	}

	@Given("a reference person {string}")
	public void a_reference_person3(String refPerson) {
	    this.refPerson = refPerson;
	}

	@Given("an address {string}")
	public void an_address3(String address) {
	    this.address = address;
	}

	@When("client updated")
	public void client_updated3() {
	    success = client.update(name, email, refPerson, address);
	}

	@Then("client contains updated information")
	public void client_contains_updated_information3() {
		assertTrue(success);
	  
	}

	
	
	
	
	

	@Given("client list containing client with email {string}")
	public void client_list_containing_client_with_email3(String email) {
	    company.addClient(new Client("ugne", email, "Jonahtan", "password1", "321teerst"));
	}



	@Then("client information not updated")
	public void client_information_not_updated3() {
		assertFalse(success);
	}


	
	

//	@Given("client list containing client with name {string}")
//	public void client_list_containing_client_with_name(String string) {
//		company.getClients().contains(string);
//	}




}
