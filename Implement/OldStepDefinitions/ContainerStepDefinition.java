import static org.junit.Assert.assertTrue;

import dk.dtu.management.model.Client;
import dk.dtu.management.model.Container;
import dk.dtu.management.model.ContainerStatus;
import dk.dtu.management.model.Journey;
import dk.dtu.management.model.LogisticCompany;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContainerStepDefinition {
//	Client client;
//	LogisticCompany company;
//	String location;
//	Container container;
//	Journey journey;
//	double temperature;
//	double humidity;
//	double pressure;
//	ContainerStatus status;
//	
//	@Given("a client with name {string} with email {string} with reference person {string} with address {string} with password {string}")
//	public void a_client_with_name_with_email_with_reference_person_with_address_with_password(String name, String email, String referencePerson, String address, String password) {
//	    client = new Client(name,email,referencePerson,password,address);
//	}
//
//	@Given("a location {string}")
//	public void a_location(String location) {
//	    this.location = location;
//	}
//
//	@When("add new container")
//	public void add_new_container() {
//		container = new Container(location);
//	    company.addContainer(container);
//	}
//
//	@Then("client container set contains container")
//	public void client_container_set_contains_container() {
//	   assertTrue(client.getContainerSet().contains(container));
//	   
//	}
//	
//	@Given("a container with client with location {string}")
//	public void a_container_with_client_with_location(String location) {
//	    container = new Container(location);
//	}
//
//	@Given("temperature {double}")
//	public void temperature(Double temperature) {
//	    this.temperature = temperature;
//	}
//
//	@Given("humidity {double}")
//	public void humidity(Double humidity) {
//	    this.humidity = humidity;
//	}
//
//	@Given("atmospheric pressure {double}")
//	public void atmospheric_pressure(Double pressure) {
//	    this.pressure = pressure;
//	}
//
//	@When("add new status entry to container")
//	public void add_new_status_entry_to_container() {
//	    status = new ContainerStatus(temperature,humidity,pressure);
//	    container.addStatus(status);
//	}
//
//	@Then("check if container contains new status")
//	public void check_if_container_contains_new_status() {
//		assertTrue(container.getStatusSet().contains(status));
//	}
}
