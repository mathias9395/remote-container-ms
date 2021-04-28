package dk.dtu.management.controller;

import java.util.Set;

import dk.dtu.management.model.Client;
import dk.dtu.management.model.Journey;
import dk.dtu.management.view.ClientClientsDataView;

public class ClientClientsDataController {
	private ClientClientsDataView view;
	private ApplicationController application;
	private Client clientData;
	private Client clientOG;
	
	public ClientClientsDataController(ApplicationController application, Client clientData, Client clientOG) {
		this.application = application;
		this.clientData = clientData;
		this.clientOG = clientOG;
		this.view = new ClientClientsDataView(this);
		displayTable(clientData.getJourneySet());
	}
	
	public void back() {
		view.setVisible(false);
		application.clientViewSharedData(clientOG);
	}
	public void journeySearch() {
		Set<Journey> filteredContent = clientData.filterJourneysContent(view.getEnterContent());
		Set<Journey> filteredOrigin = clientData.filterJourneysOrigin(view.getEnterOrigin());
		Set<Journey> filteredDestination = clientData.filterJourneyDestination(view.getEnterDestination());
		filteredContent.retainAll(filteredOrigin);
		filteredDestination.retainAll(filteredContent);
		displayTable(filteredDestination);
	}
	
	public void display() {
		view.setVisible(true);
	}
		
	public void displayTable(Set<Journey> journeys) {
		view.resetTable();
		for (Journey j : journeys) {
			view.addTableRow(new Object[] {j.getId(),j.getOrigin(),j.getDestination(),j.getContentType()});
		}
	}

	public String getName() {
		return clientData.getName();
	}
	
	public String getEmail() {
		return clientData.getEmail();
	}
	public int getId() {
		return clientData.getId();
	}
	public String getReferencePerson() {
		return clientData.getReferencePerson();
	}
	public String getAddress() {
		return clientData.getAddress();
	}
	
}