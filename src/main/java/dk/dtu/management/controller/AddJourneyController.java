package dk.dtu.management.controller;

import dk.dtu.management.model.Client;
import dk.dtu.management.model.Journey;
import dk.dtu.management.view.AddJourneyView;

public class AddJourneyController {
	
	private Client client;
	private AddJourneyView view;
	private ApplicationController application;
	
	public AddJourneyController(ApplicationController application, Client client) {
		this.application = application;
		this.client = client;
		this.view = new AddJourneyView(this);
	}
	
	public void display() {
		view.setVisible(true);
	}
	
	public void returnDashboard() {
		view.setVisible(false);
		application.clientDashboard(client);
	}
	
	public void addJourney() {
		String origin = view.getOrigin();
		String destination = view.getDestination();
		String content = view.getContent();
		String company = view.getCompany();
		
		if (origin.isEmpty() || destination.isEmpty() || content.isEmpty() || company.isEmpty()) {
			view.showError();
		} else {
			client.addJourney(new Journey(origin,destination,content,company));
			returnDashboard();
		}
	}
}
