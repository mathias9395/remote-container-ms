import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import dk.dtu.management.model.Client;
import dk.dtu.management.model.Journey;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JourneyStepDefinition {
	
	String origin;
	String destination;
	String contentType;
	String company;
	Journey journey;
	Client client;
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
	
	@Given("a journey")
	public void a_journey() {
	    journey = new Journey("origin","destination","contentType","company");
	}

	@When("update journey")
	public void update_journey() {
	    journey.update(origin, destination, contentType, company);
	}

	@Then("journey contains updated information")
	public void journey_contains_updated_information() {
	    assertTrue(journey.getOrigin() == this.origin);
	    assertTrue(journey.getDestination() == this.destination);
	    assertTrue(journey.getContentType() == this.contentType);
	    assertTrue(journey.getCompany() == this.company);
	}
	
	@Given("a journey with content {string}")
	public void a_journey_with_content(String contentType) {
	    journey = new Journey("origin","destination",contentType,"company");
	}

	@Given("a client with journey set containing journey")
	public void a_client_with_journey_set_containing_journey() {
	    client = new Client("name","email","referencePerson","password","address");
	    client.addJourney(journey);
	}

	@When("search by content {string}")
	public void search_by_content(String contentType) {
	    filteredJourneys = client.filterJourneysContent(contentType);
	}

	@Then("filtered journey set that contains content {string}")
	public void filtered_journey_set_that_contains_content(String contentType) {
	    for (Journey j : filteredJourneys) {
	    	assertTrue(j.getContentType().toLowerCase().contains(contentType.toLowerCase()));
	    }
	}
	
	@Given("a journey with origin {string}")
	public void a_journey_with_origin(String origin) {
	    journey = new Journey(origin,"destination","contentType","company");
	}

	@When("search by origin {string}")
	public void search_by_origin(String origin) {
	    filteredJourneys = client.filterJourneysOrigin(origin);
	}

	@Then("filtered journey list that contains origin {string}")
	public void filtered_journey_list_that_contains_origin(String origin) {
		for (Journey j : filteredJourneys) {
	    	assertTrue(j.getOrigin().toLowerCase().contains(origin.toLowerCase()));
	    }
	}
}
