import static org.junit.Assert.assertTrue;

import java.util.Set;

import dk.dtu.management.model.Client;
import dk.dtu.management.model.Journey;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FindJourneyStepDefinition {
//	String origin;
//	String destination;
//	String content;
//	Journey journey;
//	Client client;
//	Set<Journey> filteredSetJourney;
//
//	@Given("a journey with content {string}")
//	public void a_journey_with_content(String string) {
//		content = string;
//	    journey = new Journey("default","default",content,"default");
//	}
//
//	@Given("a client with journey set containing journey")
//	public void a_client_with_journey_set_containing_journey() {
//	    client = new Client();
//	    client.addJourney(journey);
//	}
//
//	@When("search by content {string}")
//	public void search_by_content(String string) {
//	    filteredSetJourney = client.filterJourneysContent(string);
//	}
//
//	@Then("filtered journey set that contains content {string}")
//	public void filtered_journey_set_that_contains_content(String string) {
//	    for(Journey j : filteredSetJourney ) {
//	    	assertTrue(j.getContentType().equals(string));
//	    }
//		   
//	}
//
//	@Given("a journey with origin {string}")
//	public void a_journey_with_origin(String string) {
//	   origin = string;
//	   journey = new Journey(origin,"default","default","default");
//	}
//
//
//	@When("search by origin {string}")
//	public void search_by_origin(String string) {
//	   filteredSetJourney = client.filterJourneysOrigin(string);
//	}
//
//	@Then("filtered journey list that contains origin {string}")
//	public void filtered_journey_list_that_contains_origin(String string) {
//		 for(Journey j : filteredSetJourney ) {
//		    	assertTrue(j.getOrigin().equals(string));
//		    }
//	}
//
//	@Given("a journey with destination {string}")
//	public void a_journey_with_destination(String string) {
//	    destination = string;
//	    journey = new Journey("default",destination,"default","default");
//	    
//	}
//
//	@When("search by destination {string}")
//	public void search_by_destination(String string) {
//		filteredSetJourney = client.filterJourneyDestination(string);
//	}
//	
//	@Then("filtered journey list that contains destination {string}")
//	public void filtered_journey_list_that_contains_destination(String string) {
//		for(Journey j : filteredSetJourney ) {
//	    	assertTrue(j.getDestination().equals(string));
//	    }
//	}
}
