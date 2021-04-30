import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import dk.dtu.management.model.Client;
import dk.dtu.management.model.Journey;
import dk.dtu.management.model.LogisticCompany;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddjounreyStepDefinition {
	
	String origin;
	String destination;
	String contentType;
	String company;
	Journey journey;
	Client client;
	Boolean success;
	Set<Journey> filteredJourneys;
	
	@Given("a client")
	public void a_client() {
	    client = new Client("name","email","referencePerson","password","address");
	}

	@Given("an origin {string}")
	public void an_origin(String origin) {
	    this.origin = origin;
	}

	@Given("a destination {string}")
	public void a_destination(String destination) {
	    this.destination = destination;
	}

	@Given("a content type {string}")
	public void a_content_type(String contentType) {
	    this.contentType = contentType;
	}

	@Given("a company {string}")
	public void a_company(String company) {
	    this.company = company;
	}

	@When("add journey to client journey set")
	public void add_journey_to_client_journey_set() {
	    journey = new Journey(origin,destination,contentType,company);
	    client.addJourney(journey);
	}

	@Then("journey list has new journey")
	public void journey_list_has_new_journey() {
		assertTrue(client.getJourneySet().contains(journey));
	}

}
