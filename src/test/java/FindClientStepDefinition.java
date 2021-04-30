import static org.junit.Assert.assertTrue;

import java.util.Set;

import dk.dtu.management.model.Client;
import dk.dtu.management.model.LogisticCompany;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FindClientStepDefinition {
	LogisticCompany company;
	Client client;
	String name;
	String email;
	String refPerson;
	String password;
	String address;
	Set<Client> filteredSetClient;
	
	
	@Given("client with name {string} with {string} with {string} with {string} with {string}")
	public void client_with_name_with_with_with_with(String string, String string2, String string3, String string4, String string5) {
	    name = string;
	    email = string2;
	    refPerson = string3;
	    password = string4;
	    address = string5;
		client = new Client(name,email,refPerson,password,address);
	}

	@Given("a logistic company with client set contains client")
	public void a_logistic_company_with_client_set_contains_client() {
	    company = new LogisticCompany("admin","admin");
	    company.addClient(client);
	}

	@When("search by name {string}")
	public void search_by_name(String string) {
	    filteredSetClient = company.filterClientsName(string);
	}

	@Then("filtered client set contains client")
	public void filtered_client_set_contains_client() {
	    assertTrue(filteredSetClient.contains(client));
	}

	@When("search by email {string}")
	public void search_by_email(String string) {
	   filteredSetClient = company.filterClientsEmail(string);
	}

}
