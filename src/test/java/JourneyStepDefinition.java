import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import dk.dtu.management.model.Client;
import dk.dtu.management.model.Container;
import dk.dtu.management.model.ContainerStatus;
import dk.dtu.management.model.Journey;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JourneyStepDefinition {
	
	//CompleteJourney, GetCurrentJourney, RemoveJourney, UpdateJourney
	private Client client;

	private Journey journey;
	private ContainerStatus status;
	private Container container;
	
	private String origin;

	private String destination;

	private String content;

	private String company;

	
	//ADD JOURNEY;
	@Given("client")
	public void client() {
		client = new Client();
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
	    this.content = content;
	}

	@Given("a company {string}")
	public void a_company(String company) {
	    this.company = company;
	}

	@When("add journey to client journey set")
	public void add_journey_to_client_journey_set() {
	    journey = new Journey(origin,destination,content,company);
	    client.addJourney(journey);
	}

	@Then("journey set has new journey")
	public void journey_set_has_new_journey() {
		assertTrue(client.getJourneySet().contains(journey));
	}
	
	
	//CompleteJourney
	
	@When("journey is completed")
	public void journey_is_completed() {

		journey.complete();
	}
	
	@Then("journey is removed from current journey set and added in the completed journey set")
	public void journey_is_removed_from_current_journey_set_and_added_in_the_completed_journey_set() {
	    assertFalse(client.getCurrentJourneys().contains(journey));
	    assertTrue(client.getCompletedJourneys().contains(journey));
	}
	
	//GetCurrentJourney
	@Given("a client with a journey")
	public void a_client_with_a_journey() {
		client = new Client("name","email","referencePerson","password","address");
		journey = new Journey("origin","destination","contentType","company");
		client.addJourney(journey);
	}
	
	@When("a journey is ongoing")
	public void a_journey_is_ongoing() {
		
		journey.setOnJourney(true);
	}
	
	@Then("the journey is in a set of current journeys")
	public void the_journey_is_in_a_set_of_current_journeys() {  
		assertTrue(client.getCurrentJourneys().contains(journey));
	}
	
    @When("a journey is not ongoing")
	public void a_journey_is_not_ongoing() {
    	journey.setCompleted(true);
	}
	
	@Then("the journey is not in a set of current journeys")
	public void the_journey_is_not_in_a_set_of_current_journeys() {  
		assertFalse(client.getCurrentJourneys().contains(journey));
	}

	//RemoveJourney
	@When("a journey is deleted")
	public void a_journey_is_deleted() {
	    client.getJourneySet().remove(journey);
	    client.removeJourney(journey);
	    journey.delete();
	}
	
	@Then("the journey is no longer in the journey set")
	public void the_journey_is_no_longer_in_the_journey_set() {
	    assertFalse(client.getJourneySet().contains(journey));
	}
	
	
	@Given("the journey has a container")
	public void the_journey_has_a_container() {
		container = new Container("location");
		journey.setContainer(container);
	}
	
	@Given("the container has at least one status")
	public void the_container_has_at_least_one_status() {
		status = new ContainerStatus(10,10,10);
		container.addStatus(status);
	}
	
	@Then("the journey contains completed container status")
	public void the_journey_contains_completed_container_status() {
		List<ContainerStatus> s = journey.getJourneyData();
		assertTrue(s.contains(status));
	}
	
}
