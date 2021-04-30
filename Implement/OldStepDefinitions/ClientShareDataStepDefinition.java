import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import dk.dtu.management.model.Client;
import dk.dtu.management.model.LogisticCompany;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClientShareDataStepDefinition {
	Client client;
	Client client2;
	LogisticCompany company = new LogisticCompany("admin","admin");
	
	//ClientsShareData
	@Given("a client")
	public void a_client() {
		client = new Client("name","email","referencePerson","password","address");
		company.addClient(client);
	}
	
	@Given("a client2 that is selected")
	public void a_client2_that_is_selected() {
	    client2 = new Client("Name", "email", "referencePerson", "password", "address");
	    company.addClient(client2);
	}
	
	@Then("share data with client2")
	public void share_data_with_client2() {
		client.addSharedWithClients(client2);
		client2.addSharedData(client);
	}
	
	//ClientViewSharedData
	@Given("a client2 that has shared data with client")
	public void a_client2_that_has_shared_data_with_client() {
		client2 = new Client("Name", "email", "referencePerson", "password", "address");
		company.addClient(client2);
		client2.addSharedWithClients(client);
	}
	
	@Then("client can access data of client2")
	public void client_can_access_data_of_client2() {
		client.addSharedData(client2);
	}
	
	//ClientStopSharingData
	@Given("a client2 that client has shared data with")
	public void a_client2_that_client_has_shared_data_with() {
		client2 = new Client("Name", "email", "referencePerson", "password", "address");
		company.addClient(client2);
		client.addSharedWithClients(client2);
		client2.addSharedData(client);
	}

	@When("client2 is removed")
	public void client2_is_removed() {
	    client.removeSharedWithClients(client2);
	}

	@Then("stop sharing data of client to client2")
	public void stop_sharing_data_of_client_to_client2() {
	    client2.removeSharedData(client);
	}
	
	//RemoveSharedData
	@Given("a client2 that has shared data with client that is deleted")
	public void a_client2_that_has_shared_data_with_client_that_is_deleted() {
		client2 = new Client("Name", "email", "referencePerson", "password", "address");
		company.addClient(client2);
		client2.addSharedWithClients(client);
	}

	@Then("delete data of client2")
	public void delete_data_of_client2() {
		client.removeSharedData(client2);
	}
	
}
	
