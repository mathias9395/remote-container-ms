import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
	Client client;
	Client client1;
	Journey journey;
	Journey journey1;
	ContainerStatus status;
	private Container container;
	
	private int ID;
	private String origin;
	private String origin1;
	private String destination;
	private String destination1;
	private String content;
	private String content1;
	private String company;
	private String company1;
	
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

	@Then("journey list has new journey")
	public void journey_list_has_new_journey() {
		assertTrue(client.getJourneySet().contains(journey));
	}
	
	
	//CompleteJourney
	@Given("a client with a journey")
	public void a_client_with_a_journey() {
	    client = new Client("Name","Email","RefPerson","Password","Address");
	    journey = new Journey("origin", "destination", "content", "company");
	    container = new Container("Copenhagen");
	    journey.setContainer(container);
	    client.addJourney(journey);
	}
	
	@When("journey is completed")
	public void journey_is_completed() {
	    journey.complete();
	}
	
	@Then("journey is removed from current Journey list and added in the completed journey list")
	public void journey_is_in_the_completed_journey_list() {
	    assertFalse(client.getCurrentJourneys().contains(journey));
	    assertTrue(client.getCompletedJourneys().contains(journey));
	}
	
	//GetCurrentJourney
	
	@Given("a journey and client")
	public void a_journey_and_client() {
		client = new Client();
		journey = new Journey();
	}
	
	@When("a journey is ongoing")
	public void a_journey_is_ongoing() {
		
		journey = new Journey("origin", "destination", "content type", "company") ;
		client.addJourney(journey);
	}
	
	@Then("the journey is in a set of current journeys")
	public void the_journey_is_in_a_set_of_current_journeys() {  
		assertFalse(client.getCurrentJourneys().isEmpty());
	}

	@Given("another journey and client")
	public void another_journey_and_client() {
		client1 = new Client();
		journey1 = new Journey();	
	}
	
    @When("a journey is not ongoing")
	public void a_journey_is_not_ongoing() {
    	journey1 = new Journey("origin", "destination", "content type", "company") ;
	    journey1.setContainer(container);
		journey1.complete();
		client1.addJourney(journey1);
	}
	
	@Then("the journey is not in a set of current journeys")
	public void the_journey_is_not_in_a_set_of_current_journeys() {  
		assertTrue(client1.getCurrentJourneys().isEmpty());
	}

	//RemoveJourney
	@When("a journey is deleted")
	public void a_journey_is_deleted() {
	    client.getJourneySet().remove(journey);
	    client.removeJourney(journey);
	    journey.delete();
	}
	
	@Then("the journey is no longer in the journey list")
	public void the_journey_is_no_longer_in_the_journey_list() {
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
