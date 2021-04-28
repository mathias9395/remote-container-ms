package dk.dtu.management.controller;

import java.util.Set;

import dk.dtu.management.model.Client;
import dk.dtu.management.model.Journey;
import dk.dtu.management.view.ClientDashboardView;

public class ClientDashboardController {
	
	private ClientDashboardView view;
	private ApplicationController application;
	private Client client;
	
	public ClientDashboardController(ApplicationController application, Client client) {
		this.application = application;
		this.client = client;
		this.view = new ClientDashboardView(this);
		displayTable(client.getJourneySet());
	}
	
	public void logout() {
		view.setVisible(false);
		application.login();
	}
	

	public void journeySearch() {
		Set<Journey> filteredContent = client.filterJourneysContent(view.getEnterContent());
		Set<Journey> filteredOrigin = client.filterJourneysOrigin(view.getEnterOrigin());
		Set<Journey> filteredDestination = client.filterJourneyDestination(view.getEnterDestination());
		filteredContent.retainAll(filteredOrigin);
		filteredDestination.retainAll(filteredContent);
		displayTable(filteredDestination);
	}
	
	public void display() {
		view.setVisible(true);
	}
	
	public String getUser() {
		return client.getName();
	}
	
	public void displayTable(Set<Journey> journeys) {
		view.resetTable();
		for (Journey j : journeys) {
			view.addTableRow(new Object[] {j.getId(),j.getOrigin(),j.getDestination(),j.getContentType(), false});
		}
	}
	
	public void addJourney() {
		view.setVisible(false);
		application.addJourney(client);
	}

	public void removeJourney(int id) {
		Journey j = new Journey(id);
		client.removeJourney(j);
	}
	
	public void selectJourney(int row) {
		int id = view.getTableRow(row);
		Journey j = client.getJourneyById(id);
		view.setVisible(false);
		application.viewStatus(j);
		
	}

	public void clientSettings() {
		view.setVisible(false);
		application.clientSettings(client);
		
	}

	public void sendMessage() {
		view.setVisible(false);
		application.clientMessage(client);
		
	}
	
	public void viewSharedData() {
		view.setVisible(false);
		application.clientViewSharedData(client);
	}
	
	public void clientShareData() {
		view.setVisible(false);
		application.clientShareData(client);
	}
}
