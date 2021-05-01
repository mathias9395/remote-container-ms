import static org.junit.Assert.assertTrue;

import dk.dtu.management.model.Container;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddContainerStepDefinition {

	private String location;
	private Container container;
	
@Given("a location {string}")
public void a_location(String location) {
    this.location = location;
}

@When("the user chooses to add container")
public void the_user_chooses_to_add_container() {
    container = new Container();
    container = new Container(location);
}

@Then("a new container with id {int} is added to the container list")
public void a_new_container_with_id_is_added_to_the_container_list(Integer ID) {
	
	this.ID = ID;
	container.setId(ID);
	assertEquals(container.getId(), ID);
    assertTrue(container.isAvailable());
    
    }
}









