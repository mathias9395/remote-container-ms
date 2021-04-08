import static org.junit.Assert.*;

import java.util.Set;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JourneyStepDefinition {
	LogisticCompany logisticCompany = new LogisticCompany();
	Client client = new Client("name","email","referencePerson","password","address",logisticCompany);
	String company;
	String origin;
	String destination;
	String content;
	Journey journey;
	Set<Journey>journeyList;
	Set<Journey> searchedJourneyList;
	
	@Given("an origin {string}")
	public void an_origin(String origin) {
	    this.origin = origin;
	}

	@Given("a destination {string}")
	public void a_destination(String destination) {
	    this.destination = destination;
	}

	@Given("a content type {string}")
	public void a_content_type(String content) {
	    this.content = content;
	}

	@Given("a company {string}")
	public void a_company(String company) {
	    this.company = company;
	}

	@When("add journey")
	public void add_journey() {
	    journey = new Journey(origin,destination,content,company);
	    client.registerJourney(journey);
	}

	@Then("journey list has new journey")
	public void journey_list_has_new_journey() {
	    assertTrue(client.getJourneyList().contains(journey));
	}
	
	@Given("a journey")
	public void a_journey() {
	    journey = new Journey("origin","destination","content type","company");
	}

	@When("update journey")
	public void update_jourconney() {
	    journey.update(origin,destination,content,company);
	}

	@Then("journey contains updated information")
	public void journey_contains_updated_information() {
	    assertTrue(journey.getOrigin() == this.origin);
	    assertTrue(journey.getDestination() == this.destination);
	    assertTrue(journey.getContentType() == this.content);
	    assertTrue(journey.getCompany() == this.company);
	}
	
	@Given("a journey with content {string}")
	public void a_client_that_has_journey_with_content(String content) {
	    journey = new Journey("origin","destination",content,"company");
	}

	@Given("a client containing journey")
	public void a_journey_list_with_journey() {
		client.registerJourney(journey);
	}

	@When("search by content {string}")
	public void search_by_content(String content) {
	    searchedJourneyList = client.filterJourneysContent(content);
	}

	@Then("filtered journey list that contains content {string}")
	public void filtered_journey_list_that_contains_content(String content) {
	    for (Journey entry : searchedJourneyList) {
	    	assertTrue(entry.getContentType().toLowerCase().contains(content.toLowerCase()));
	    }
	}
	
	@Given("a journey with origin {string}")
	public void a_journey_with_origin(String origin) {
		journey = new Journey(origin,"destination","content","company");
	}

	@When("search by origin {string}")
	public void search_by_origin(String origin) {
		searchedJourneyList = client.filterJourneysOrigin(origin);
	}
	
	@Then("filtered journey list that contains origin {string}")
	public void filtered_journey_list_that_contains_origin(String origin) {
	    for (Journey entry : searchedJourneyList) {
	    	assertTrue(entry.getOrigin().toLowerCase().contains(origin.toLowerCase()));
	    }
	}

}