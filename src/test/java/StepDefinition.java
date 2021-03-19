import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	
	Client client;
	ClientDB clients;
	
	
	@Given("a username {string}")
	public void a_username(String username) {
	    client = new Client(username);
	}

	@Given("a name {string}")
	public void a_name(String name) {
	    client.setName(name);
	}

	@Given("a phone number {string}")
	public void a_phone_number(String phoneNumber) {
	    client.setPhoneNumber(phoneNumber);
	}

	@Given("a email {string}")
	public void a_email(String email) {
	    client.setEmail(email);
	}

	@Given("a password {string}")
	public void a_password(String password) {
	    client.setPassword(password);
	}

	@When("add client")
	public void add_client() {
	    clients.addClient(client);
	}

	@Then("client list has new client")
	public void client_list_has_new_client() {
	    assertTrue(clients.contains(client));
	}

	@Then("display new client")
	public void display_new_client() {
		
	    
	}

	@Given("I want to write a step with precondition")
	public void i_want_to_write_a_step_with_precondition() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("some other precondition")
	public void some_other_precondition() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I complete action")
	public void i_complete_action() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("some other action")
	public void some_other_action() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("yet another action")
	public void yet_another_action() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("check more outcomes")
	public void check_more_outcomes() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
