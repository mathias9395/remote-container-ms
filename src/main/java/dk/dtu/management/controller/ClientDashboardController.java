package dk.dtu.management.controller;

import dk.dtu.management.model.Client;
import dk.dtu.management.view.ClientDashboardView;

public class ClientDashboardController {
	private ClientDashboardView view;
	private ApplicationController application;
	private Client client;
	
	public ClientDashboardController(ApplicationController application, Client client) {
		this.application = application;
		this.client = client;
		this.view = new ClientDashboardView(this);
	}
	
	public void display() {
		view.setVisible(true);
	}
	
	public String getUser() {
		return client.getName();
	}
}
