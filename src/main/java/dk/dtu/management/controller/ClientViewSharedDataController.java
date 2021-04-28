package dk.dtu.management.controller;

import java.util.Set;

import dk.dtu.management.model.Client;
import dk.dtu.management.model.LogisticCompany;
import dk.dtu.management.view.ClientViewSharedDataView;

public class ClientViewSharedDataController {
	private LogisticCompany company;
	private Client client;
	private ClientViewSharedDataView view;
	private ApplicationController application;
	
	public ClientViewSharedDataController(ApplicationController application, Client client) {
		this.application = application;
		this.client = client;
		this.company = client.getCompany();
		this.view = new ClientViewSharedDataView(this);
		displayTable(client.getSharedData());
	}
	
	public void setView(ClientViewSharedDataView view) {
		this.view = view;
	}
	
	public void selectClient(int row) {
		Object[] data = view.getTableRow(row);
		Client c = company.getClientById((int) data[0]);
		view.setVisible(false);
		application.clientClientsData(c,client);
	}
	
	public void clientSearch() {
		Set<Client> filteredName = company.filterClientsName(view.getTxtNameSearch());
		Set<Client> filteredEmail = company.filterClientsEmail(view.getTxtEmailSearch());
		filteredName.retainAll(filteredEmail);
		filteredName.retainAll(client.sharedData);
		displayTable(filteredName);
	}
	
	public void displayTable(Set<Client> clients) {
		view.resetTable();
		for (Client c : clients) {
			view.addTableRow(new Object[] {c.getId(),c.getName(),c.getEmail(),c.getReferencePerson(),c.getAddress(),false});
		}
	}
	
	public void deleteClient(int id,String email) {
		Client c = new Client(id, email);
		client.removeSharedData(c);
	}
	
	public void display() {
		view.setVisible(true);
	}
	
	public void back() {
		view.setVisible(false);
		application.clientDashboard(client);
	}
	
	
}


