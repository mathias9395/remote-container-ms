import static org.junit.Assert.assertTrue;

import dk.dtu.management.model.Client;
import dk.dtu.management.model.LogisticCompany;
import dk.dtu.management.model.Message;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MessagingStepDefinition {
	
	LogisticCompany company;
	Client client;
	String content;
	Message message;
	
	
	@Given("a client with a logistic company")
	public void a_client_with_a_logistic_company() {
	    company = new LogisticCompany();
	    client = new Client();
	}
	
	@Given("a logistic company for messaging")
	public void a_logistic_company() {
		company = new LogisticCompany();
	}

	@Given("a the message {string} to send")
	public void a_the_message_to_send(String content) {
	    this.content = content;
	}

	@When("the message is sent as a client")
	public void the_message_is_sent_as_a_client() {
		message = new Message(client,true,content);
	    client.addMessage(message);
	}
	@When("the message is sent as a company")
	public void the_message_is_sent_a_vompany() {
		message = new Message(client,false,content);
	    client.addMessage(message);
	}

	@Then("client sent messages contains message")
	public void client_sent_messages_contains_message() {
	    assertTrue(client.getMessages().contains(message));
	    assertTrue(message.getSender());
	}
	
	@Given("a client in the logistic company client set")
	public void a_client_in_the_logistic_company_client_set() {
	    client = new Client();
	    company.addClient(client);
	}

	@Then("client received messages contains message")
	public void client_received_messages_contains_message() {
	    assertTrue(client.getMessages().contains(message));
	    assertTrue(!message.getSender());
	}
}
