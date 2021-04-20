package dk.dtu.management.controller;

import dk.dtu.management.model.Client;
import dk.dtu.management.view.ClientSettingsView;

public class ClientSettingsController {
	
	private Client client;
	private ClientSettingsView view;
	private ApplicationController application;
	
	
	public ClientSettingsController(ApplicationController application, Client client) {
		this.application = application;
		this.client = client;
		this.view = new ClientSettingsView(this);
	}
	
	public void display() {
		view.setVisible(true);
	}

	public String getName() {
		return client.getName();
	}
	
	public String getEmail() {
		return client.getEmail();
	}
	
	public String getReferencePerson() {
		return client.getReferencePerson();
	}
	
	public String getAddress() {
		return client.getAddress();
	}

	public void returnDashboard() {
		view.setVisible(false);
		application.clientDashboard(client);
		
	}

	public void updateClient(String name, String email, String referencePerson, String address) {
		if (name.isEmpty() || referencePerson.isEmpty() || email.isEmpty() || address.isEmpty()) {
			view.showEmptyError();
		} else if (!client.update(name, email, referencePerson, address)) {
			view.showEmailError();
		} else {
			returnDashboard();
		}
	}
}
