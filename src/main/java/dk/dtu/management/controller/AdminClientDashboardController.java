package dk.dtu.management.controller;

import java.util.HashSet;
import java.util.Set;

import dk.dtu.management.model.Client;
import dk.dtu.management.model.Journey;
import dk.dtu.management.view.AdminClientDashboardView;



public class AdminClientDashboardController {
	
	private AdminClientDashboardView view;
	private ApplicationController application;
	private Client client;
	private Journey journey;
	private boolean allSelected;
	private boolean newSelected;
	
	public AdminClientDashboardController(ApplicationController application, Client client) {
		this.application = application;
		this.client = client;
		this.view = new AdminClientDashboardView(this);
		allJourneys(false);
	}
	
	public void logout() {
		view.setVisible(false);
		application.login();
	}
	
	public void back() {
		view.setVisible(false);
		application.adminDashboard();
	}
	
	public Set<Journey> journeySearch() {
		
		Set<Journey> filteredContent = client.filterJourneysContent(view.getEnterContent());
		Set<Journey> filteredOrigin = client.filterJourneysOrigin(view.getEnterOrigin());
		Set<Journey> filteredDestination = client.filterJourneyDestination(view.getEnterDestination());
		filteredContent.retainAll(filteredOrigin);
		filteredDestination.retainAll(filteredContent);
		if(!allSelected) {
			filteredDestination.removeAll(client.getCompletedJourneys());
		}
		if(newSelected) {
			Set<Journey> newJourneys = client.getNewJourneys();
			filteredDestination.retainAll(newJourneys);
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
	public String getEmail() {
		return client.getEmail();
	}
	public int getId() {
		return client.getId();
	}
	public String getReferencePerson() {
		return client.getReferencePerson();
	}
	public String getAddress() {
		return client.getAddress();
	}
	
	public void displayTable(Set<Journey> journeys) {
		view.resetTable();
		for (Journey j : journeys) {
			view.addTableRow(new Object[] {j.getId(),j.getOrigin(),j.getDestination(),j.getContentType(),j.getCompany()});
		}
	}
	
	public void addJourney() {
		view.setVisible(false);
		application.addJourney(client);
	}


	
	public void message() {
		view.setVisible(false);
		application.adminMessage(client);
	}

	public void clientSettings() {
		view.setVisible(false);
		application.clientSettings(client);
		
	}

	public String getName() {
		return client.getName();
	}

	public void selectJourney(int row) {
		int id = view.getTableRow(row);
		Journey j = client.getJourneyById(id);
		if (j.isCompleted()) {
			view.showCompleted();
		} else if (j.isOnJourney()) {
			view.setVisible(false);
			application.addStatus(j);
		} else {
			view.setVisible(false);
			application.assignContainer(j);
		}
		
	}


	public void newContainers(boolean selected) {
		this.newSelected = selected;
		if (selected) {
			this.allSelected = false;
			view.setAllSelected(false);
			
		}
		journeySearch();
		
	}

	public void allJourneys(boolean selected) {
		this.allSelected = selected;
		if (selected) {
			this.newSelected = false;
			view.setNewSelected(false);
		}
		journeySearch();
		
	}
	
}






