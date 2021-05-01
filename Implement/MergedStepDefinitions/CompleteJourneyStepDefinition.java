import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import dk.dtu.management.model.Client;
import dk.dtu.management.model.Container;
import dk.dtu.management.model.Journey;


public class CompleteJourneyStepDefinition {
	
//	Client client;
//	Journey journey;
//	private Container container;
//	
//	
//@Given("a client with a journey")
//public void a_client_with_a_journey() {
//    client = new Client();
//    journey = new Journey("origin", "destination", "content", "company");
//    container = new Container("Copenhagen");
//    journey.setContainer(container);
//    client.addJourney(journey);
//}
//
//@When("journey is completed")
//public void journey_is_completed() {
//
//    journey.complete();
//}
//
//@Then("journey is removed from current Journey list and added in the completed journey list")
//public void journey_is_in_the_completed_journey_list() {
//    assertFalse(client.getCurrentJourneys().contains(journey));
//    assertTrue(client.getCompletedJourneys().contains(journey));
//}
}
