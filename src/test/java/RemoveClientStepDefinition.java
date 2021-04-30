import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import dk.dtu.management.model.LogisticCompany;
import dk.dtu.management.model.Client;

public class RemoveClientStepDefinition {
	
	boolean success;
	LogisticCompany company = new LogisticCompany("admin", "admin");
	Client client;
	
	
	@Given("a client in a logistic company client set")
	public void a_client_in_a_logistic_company_client_set() {
		client = new Client();
		success = company.addClient(client);
	}

	@When("client is deleted")
	public void client_is_deleted() {
	    assertTrue(company.removeClient(client));
	}

	@Then("client list does not contain client")
	public void client_list_does_not_contain_client() {
	    assertFalse(company.getClients().contains(client));
	}
}
