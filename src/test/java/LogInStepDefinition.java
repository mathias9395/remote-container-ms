import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import com.mysql.cj.xdevapi.Client;

import dk.dtu.management.model.Accounts;
import dk.dtu.management.model.LogisticCompany;
import dk.dtu.management.model.User;
import io.cucumber.java.en.And;

public class LogInStepDefinition {
	
	String email;
	String password;
	Accounts accounts = new Accounts();
	User user;
	Client client;
	LogisticCompany company;

	@Given ("an email {string}")
	public void an_email(String email) {
	    this.email = email;
	}
	
	@And ("a password {string}")
	public void a_password(String password) {
		this.password = password;
	}

	
	@When("the accounts set contains a client with email {string} and password {string}")
	public void client_set_contains_a_client_with_email_and_password(String email, String password) {
		
		user = new User();
		user = new User(email,password);
		user.setEmail(email);
		user.setPassword(password);
		
		accounts.addUser(user);
		
		assertTrue(accounts.getUser(email).equals(user));

	}

	@Then("the log in is successfull")
	public void the_log_in_is_successfull() {
		assertTrue(accounts.login(email, password));	
	}
	
	@When("accounts set does not contain a client with password {string} and email {string}")
	public void accounts_set_does_not_contain_a_client_with_password_and_email(String email, String password) {
		user = new User();
		user.setEmail(email);
		user.setPassword(password);
		
		assertEquals(accounts.getUser(email),null);
	}
	
	@Then("the log in is unsuccessful")
	public void the_log_in_is_unsuccessful() {
	    assertFalse(accounts.login(email, password));
	}
	
}
