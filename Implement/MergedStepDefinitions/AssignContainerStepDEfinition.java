import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import dk.dtu.management.model.Client;
import dk.dtu.management.model.Container;
import dk.dtu.management.model.Journey;
import dk.dtu.management.model.LogisticCompany;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AssignContainerStepDEfinition {
	
//	private Container container;
//	private LogisticCompany company;
//	private Client client;
//	private String email;
//	private Journey journey;
//	private int ID;
//	private String location;
//	@Given("a specified container with location {string}")
//	public void a_specified_container_with_location(String location) {
//		this.location = location;
//	    container = new Container();
//	    container = new Container(location);
//	    assertEquals(location,container.getLocation());
//	    
//	}
//
//	@Given("the logistics company")
//	public void a_logistics_company() {
//	    company = new LogisticCompany();
//	    container.setCompany(company);
//	    assertEquals(company,container.getCompany());
//	}
//
//	@Given("a client specified by email {string} with at least one journey")
//	public void a_client_with_at_least_one_journey(String email) {
//	    client = new Client();
//	    this.email = email;
//	    client.setEmail(email);
//	    journey = new Journey();
//	    client.addJourney(journey);
//	    // the rest is assessed in addClient feature
//	}
//
//	@When("the user adds the container to a journey")
//	public void the_user_adds_the_container_to_a_journey() {
//	    container.setClient(client);
//	    container.setJourney(journey);
//	    journey.setContainer(container);
//	    assertEquals(container.getClient(),client);
//    
//	}
//
//	@Then("the container gets assigned to the journey")
//	public void the_container_gets_assigned_to_the_journey() {
//		assertTrue(container.getJourney().equals(journey));
//	    assertEquals(journey.getContainer(), container);
//	}
}
