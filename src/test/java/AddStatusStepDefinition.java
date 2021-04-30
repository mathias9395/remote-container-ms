import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import dk.dtu.management.model.Container;
import dk.dtu.management.model.ContainerStatus;
import dk.dtu.management.model.Journey;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class AddStatusStepDefinition {
	
	Container container ;
	ContainerStatus status ;
	Double temperature;
	Double humidity;
	Double pressure;
	String location;
	
	

	@Given("a container")
	public void a_container() {
		
		container = new Container();
    
	}

	@Given("temperature {double}")
	public void temperature(Double temperature) {
		
		this.temperature = temperature;
		
    }


	@Given("pressure {double}")

	public void pressure(Double pressure) {
    
		this.pressure = pressure;

	}


	@Given("humidity {double}")

	public void humidity(Double humidity) {
    
		this.humidity = humidity;

	}
	
	
	
	@And("location {string}")
	public void location(String location) {
		
	    this.location = location;
	    
	}



	@When("add new status to container")
	public void add_new_status_to_container() {
		status = new ContainerStatus(temperature, humidity, pressure);
		container.setLocation(location);
		container.addStatus(status);
	}

	@Then("container contains updated information")
	public void container_contains_updated_information() {
	    
		assertTrue(container.getStatusSet().contains(status));
		
	}

}

















