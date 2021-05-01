import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import dk.dtu.management.model.Client;
import dk.dtu.management.model.Container;
import dk.dtu.management.model.ContainerStatus;
import dk.dtu.management.model.Journey;
import dk.dtu.management.model.LogisticCompany;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContainerStepDefinition {

	
	//AddContainer, AssignContainer, AddStatus
	private Container container;
	private ContainerStatus status;
	private Double temperature;
	private Double humidity;
	private Double pressure;
	private String location;
	
	private Client client;
	private String email;
	
	private LogisticCompany company;
	
	private Journey journey;
	
	private int ID;
	
	
	//Add Container
	@Given("a location {string}")
	public void a_location(String location) {
	    this.location = location;
	}
	
	@When("the logistic company chooses to add container")
	public void the_logistic_company_chooses_to_add_container() {
		container = new Container(location);
	    company.addContainer(container);
	}

	@Then("container set contains the new container")
	public void container_set_contains_the_new_container() {
	    assertTrue(company.getContainers().contains(container));
	}
	
	//Assign Container
	@Given("a specific container with location {string}")
	public void a_specified_container_with_location(String location) {
		this.location = location;
	    container = new Container(location);
	    assertEquals(location,container.getLocation());
	    
	}

	@Given("the logistics company")
	public void the_logistics_company() {
	    company = new LogisticCompany("admin","admin");
	}

	@Given("a client specified by email {string} with at least one journey")
	public void a_client_with_at_least_one_journey(String email) {
	    client = new Client();
	    this.email = email;
	    client.setEmail(email);
	    journey = new Journey();
	    client.addJourney(journey);
	    // the rest is assessed in addClient feature
	}

	@When("the user adds the container to a journey")
	public void the_user_adds_the_container_to_a_journey() {
	    journey.setContainer(container);
	    assertEquals(container.getJourney(),journey);
    
	}

	@Then("the container gets assigned to the journey")
	public void the_container_gets_assigned_to_the_journey() {
	    assertEquals(journey.getContainer(), container);
	}
	
	//Add Status
	@Given("a container")
	public void a_container() {		
		container = new Container();
	}

	@Given("a temperature {double}")
	public void a_temperature(Double temperature) {
		this.temperature = temperature;			
    }


	@Given("a pressure {double}")
	public void a_pressure(Double pressure) {
		this.pressure = pressure;
	}

	@Given("a humidity {double}")
	public void a_humidity(Double humidity) {
		this.humidity = humidity;
	}

	@When("add new status to container")
	public void add_new_status_to_container() {
		status = new ContainerStatus(temperature, humidity, pressure);
		container.setLocation(location);
		//container.addStatus(status);
		status.setId(0);
		status.setTemperature(0);
		status.setHumidity(0);
		status.setPressure(0);
		status.setTime(null);
	}

	@Then("container contains updated information")	
	public void container_contains_updated_information() {
		status.getTemperature();
		status.getHumidity();
		status.getPressure();
		status.getTime();
		status.getId();
		status.getContainer();
		container.addStatus(status);    
		assertTrue(container.getStatusSet().contains(status));
	}

	@Given("a specified journey")
	public void a_specified_journey() {
		journey = new Journey();
		journey.setContainer(container);	
	}

	@Given("a client with email {string} that is associated with the container and journey")
	public void a_client_with_email_that_is_associated_with_the_container_and_journey(String email) {
	    client = new Client();
	    this.email = email;
	    client.setEmail(email);
	    client.addJourney(journey);
	    container.setClient(client);
	}

	@When("the journey has ended and the container has become inactive")
	public void the_journey_has_ended_and_the_container_has_become_inactive() {
		journey.complete();
	}

	@Then("reset the container")
	public void reset_the_container() {
		assertTrue(journey.isCompleted());
		
	}
}
