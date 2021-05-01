import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import dk.dtu.management.model.Client;
import dk.dtu.management.model.Journey;
import dk.dtu.management.model.LogisticCompany;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClientStepDefinition {
	
	
	// UpdateClient, ClientsShareData, ClientViewSharedData, ClientStopSharingData
	// RemoveSharedData, FindJourney, GetNewJourneys
	LogisticCompany company = new LogisticCompany("admin","admin");
	Client client;
	Client client2;
	String name;
	String email;
	String refPerson;
	String address;

	Boolean success; 
	
	String origin;
	String destination;
	String content;
	Journey journey;
	Set<Journey> filteredSetJourney;
	
	
	//UpdateClient
	@Given("a client")
	public void a_client() {
		client = new Client("name","email","referencePerson","password","address");
		company.addClient(client);
	}
	
	@Given("a new name {string}")
	public void a_new_name(String name) {
	    this.name = name;
	}

	@Given("a new email {string}")
	public void a_new_email(String email) {
	    this.email = email;
	}

	@Given("a new reference person {string}")
	public void a_new_reference_person(String refPerson) {
	    this.refPerson = refPerson;
	}

	@Given("a new address {string}")
	public void a_new_address(String address) {
	    this.address = address;
	}

	@When("client updated")
	public void client_updated() {
	    success = client.update(name, email, refPerson, address);
	}

	@Then("client contains updated information")
	public void client_contains_updated_information() {
		assertTrue(success);
		assertTrue(name.equals(client.getName()));
		assertTrue(email.equals(client.getEmail()));
		assertTrue(refPerson.equals(client.getReferencePerson()));
		assertTrue(address.equals(client.getAddress()));
	}


	@Given("client set containing client with email {string}")
	public void client_set_containing_client_with_email(String email) {
	    company.addClient(new Client("ugne", email, "Jonahtan", "password1", "321teerst"));
	}


	@Then("client information not updated")
	public void client_information_not_updated() {
		assertFalse(success);
		assertFalse(name.equals(client.getName()));
		assertFalse(email.equals(client.getEmail()));
		assertFalse(refPerson.equals(client.getReferencePerson()));
		assertFalse(address.equals(client.getAddress()));
	}
	
	//ClientsShareData
	@Given("a client2 that is selected")
	public void a_client2_that_is_selected() {
	    client2 = new Client("Name", "email", "referencePerson", "password", "address");
	    company.addClient(client2);
	}
	
	@Then("share data with client2")
	public void share_data_with_client2() {
		client.addSharedWithClients(client2);
		client2.addSharedData(client);
		assertTrue(client.getSharedWithClients().contains(client2));
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
		assertTrue(client.getSharedData().contains(client2));	
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
	    assertFalse(client.getSharedWithClients().contains(client2));
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
		assertFalse(client.getSharedData().contains(client2));
	}
	
	//Find Journey
	@Given("a journey with content {string}")
	public void a_journey_with_content(String string) {
		content = string;
	    journey = new Journey("default","default",content,"default");
	}

	@Given("a client with journey set containing journey")
	public void a_client_with_journey_set_containing_journey() {
	    client = new Client();
	    client.addJourney(journey);
	}

	@When("search by content {string}")
	public void search_by_content(String string) {
	    filteredSetJourney = client.filterJourneysContent(string);
	}

	@Then("filtered journey set that contains content {string}")
	public void filtered_journey_set_that_contains_content(String string) {
	    for(Journey j : filteredSetJourney ) {
	    	assertTrue(j.getContentType().equals(string));
	    }
		   
	}

	@Given("a journey with origin {string}")
	public void a_journey_with_origin(String string) {
	   origin = string;
	   journey = new Journey(origin,"default","default","default");
	}


	@When("search by origin {string}")
	public void search_by_origin(String string) {
	   filteredSetJourney = client.filterJourneysOrigin(string);
	}

	@Then("filtered journey set that contains origin {string}")
	public void filtered_journey_set_that_contains_origin(String string) {
		 for(Journey j : filteredSetJourney ) {
		    	assertTrue(j.getOrigin().equals(string));
		    }
	}

	@Given("a journey with destination {string}")
	public void a_journey_with_destination(String string) {
	    destination = string;
	    journey = new Journey("default",destination,"default","default");
	    
	}

	@When("search by destination {string}")
	public void search_by_destination(String string) {
		filteredSetJourney = client.filterJourneyDestination(string);
	}
	
	@Then("filtered journey set that contains destination {string}")
	public void filtered_journey_set_that_contains_destination(String string) {
		for(Journey j : filteredSetJourney ) {
	    	assertTrue(j.getDestination().equals(string));
	    }
	}
	
	@Given("a journey that is not on journey")
	public void a_journey_that_is_not_on_journey() {
		journey = new Journey("default","default","default","default");
		journey.setOnJourney(false);
	}

	@When("filter by on journey")
	public void filter_by_on_journey() {
	    filteredSetJourney = client.filterOnJourney();
	}

	@Then("filtered journey set that contains journey not on journey")
	public void filtered_journey_set_that_contains_journey_not_on_journey() {
		for(Journey j : filteredSetJourney ) {
	    	assertFalse(j.isOnJourney());
	    }
	}
	
	//GetNewJourneys
	@Given("a client that has at least one journey")
	public void a_client_that_has_at_least_one_journey() {
	client = new Client();
	journey = new Journey("origin", "destination", "content type", "company");
	client.addJourney(journey);
	}
	
	@When("there are existing new journeys")
	public void there_are_existing_new_journeys() {
	assertFalse(journey.isOnJourney());
	}

	@When("the the user chooses to search for a new journey")
	public void the_the_user_chooses_to_search_for_a_new_journey() {
    	client.getNewJourneys();
	}

	@Then("new journeys are found and located in the new journey set")
	public void new_journeys_are_found_and_located_in_the_new_journey_set() {
    	assertFalse(client.getNewJourneys().isEmpty());
	}

	@When("there are no existing new journeys")
	public void there_are_no_existing_new_journeys() {
		journey.setOnJourney(true);
		assertTrue(journey.isOnJourney());
	}

	@Then("the new journey set is empty and no new journeys are found")
	public void the_new_journey_set_is_empty_and_no_new_journeys_are_found() {
		assertTrue(client.getNewJourneys().isEmpty());
	}
	
	
}
