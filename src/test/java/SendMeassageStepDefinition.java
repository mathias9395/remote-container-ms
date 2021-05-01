import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import dk.dtu.management.model.Client;
import dk.dtu.management.model.LogisticCompany;
import dk.dtu.management.model.Message;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SendMeassageStepDefinition {
	
	private Client client;
	private LogisticCompany company;
	private boolean sender;
	private Message message;
	private String a_message;
	private String content;
	
	
	
	@Given("a client that wants to send a message")
	public void a_client_that_wants_to_send_a_message() {
		client = new Client();
		client = new Client("name","email","referencePerson","password","address");
		
	
	}
	@Given("a meassage {string} to send")
	public void a_meassage_to_send(String a_message) {
		message = new Message();
		this.a_message = a_message;
		message = new Message(client, true, a_message);
		message.setClient(client);
		message.setSender(true);
		message.setContent(a_message);
		
		assertEquals(message.getClient(),client);
		assertEquals(message.getContent(), a_message);
		assertTrue(message.getSender());
		
	}

	
	@When("the message is sent as a client")
	public void the_message_is_sent_as_a_client() {
		
	    client.addMessage(message);
	    
	}
	

	@Then("client sent message contains message")
	public void client_sent_message_contains_message() {
		
		assertFalse(client.getMessages().isEmpty());
		
	}

	@Given("a client for messaging")
	public void a_client_for_messaging() {
		
	    client = new Client();
	    client = new Client("name","email","referencePerson","password","address");
	    
	}

	@Given("a message {string} to send")
	public void a_message_to_send(String a_message) {
		
		message = new Message();
		this.a_message = a_message;
		message = new Message(client, false, a_message);
		// getters and setters have the same function as the initialization method above.
		// they are showcased for coverage, but also for displaying their functionality
		message.setClient(client);
		message.setSender(false);
		message.setContent(a_message);
		
		assertEquals(message.getClient(),client);
		assertEquals(message.getContent(), a_message);
		assertFalse(message.getSender());
		
		
	}

	@When("the message is sent to the client")
	public void the_message_is_sent_to_the_client() {
		assertFalse(message.getSender());
		client.addMessage(message);
		assertFalse(client.getMessages().isEmpty());
		
	}

	@Then("client recived message contains message")
	public void client_recived_message_contains_message() {
		assertTrue(message.getClient().equals(client));

	}



}
