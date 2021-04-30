
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import dk.dtu.management.model.Client;
import dk.dtu.management.model.Journey;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RemoveJourneyStepDefinition {
	
	Client client;
	Journey journey;
	
	@Given("a client1")
	public void a_client1() {
		
	    client = new Client();
	}

	@Given("a journey list of the client1")
	public void a_journey_list_of_the_client1() {
		journey = new Journey();
		client.addJourney(journey);
		assertFalse(client.getJourneySet().isEmpty());
	}

	@When("a journey is deleted")
	public void a_journey_is_deleted() {
		
	    client.getJourneySet().remove(journey);
	}

	@Then("journey is no longer in the journey list")
	public void journey_is_no_longer_in_the_journey_list() {
	    assertFalse(client.getJourneySet().contains(journey));
	}


}
