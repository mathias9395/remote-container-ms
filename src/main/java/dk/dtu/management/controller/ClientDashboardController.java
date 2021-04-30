package dk.dtu.management.controller;

import java.util.HashSet;
import java.util.Set;

import dk.dtu.management.model.Client;
import dk.dtu.management.model.Journey;
import dk.dtu.management.view.ClientDashboardView;

public class ClientDashboardController {
	
	private ClientDashboardView view;
	private ApplicationController application;
	private Client client;
	private boolean selected;
	
	public ClientDashboardController(ApplicationController application, Client client) {
		this.application = application;
		this.client = client;
		this.view = new ClientDashboardView(this);
		displayTable(client.getCurrentJourneys());
	}
	
	public void logout() {
		view.setVisible(false);
		application.login();
	}
	

	public Set<Journey> journeySearch() {
		Set<Journey> filteredContent = client.filterJourneysContent(view.getEnterContent());
		Set<Journey> filteredOrigin = client.filterJourneysOrigin(view.getEnterOrigin());
		Set<Journey> filteredDestination = client.filterJourneyDestination(view.getEnterDestination());
		filteredContent.retainAll(filteredOrigin);
		filteredDestination.retainAll(filteredContent);
		if (!selected) {
			filteredDestination.removeAll(client.getCompletedJourneys());
			
		}
		displayTable(filteredDestination);
		
		return filteredDestination;
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
		Journey j = client.getJourneyById(id);
		if (j.isOnJourney()) {
			j.getContainer().reset();
		}
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

	public void displayAllJourneys(boolean selected) {
		this.selected = selected;
		journeySearch();
	}
}
