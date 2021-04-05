import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContainerStatusStepDefinition {
	Client client;
	String location;
	Container container;
	double temperature;
	double humidity;
	double pressure;
	
	
	
	@Given("a client with name {string} with email {string} with reference person {string} with address {string} with password {string}")
	public void a_client_with_name_with_email_with_reference_person_with_address_with_password(String name, String email, String referencePerson, String address, String password) {
	    client = new Client(name,email,referencePerson,address,password);
	}

	@Given("a location {string}")
	public void a_location(String location) {
	    this.location = location;
	}

	@When("add new container")
	public void add_new_container() {
	    container = new Container(client,location);
	    client.addContainer(container);
	}

	@Then("client container list contains container")
	public void client_container_list_contains_container() {
	    assertTrue(client.getContainerList().contains(container));
	}
	
	@Given("a container with client with location {string}")
	public void a_container_with_client_with_location(String location) {
	    client = new Client("client","email","reference person", "address", "password");
	    this.location = location;
	    container = new Container(client,location);
	}

	@Given("temperature {double}")
	public void temperature(double temperature) {
	    this.temperature = temperature;
	}

	@Given("humidity {double}")
	public void humidity(double humidity) {
	    this.humidity = humidity;
	}

	@Given("atmospheric pressure {double}")
	public void atmospheric_pressure(double pressure) {
	    this.pressure = pressure;
	}

	@When("add new status entry to container")
	public void add_new_status_entry_to_container() {
	    container.addStatusEntry(temperature, humidity, pressure);
	}

	@Then("check if container contains new status")
	public void check_if_container_contains_new_status() {
	    assertTrue(temperature == container.getCurrentTemp());
	    assertTrue(humidity == container.getCurrentHumidity());
	    assertTrue(pressure == container.getCurrentPressure());
	    
	}


}
