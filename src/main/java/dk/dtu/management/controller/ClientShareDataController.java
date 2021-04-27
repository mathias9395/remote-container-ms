package dk.dtu.management.controller;

import java.util.Set;

import dk.dtu.management.controller.ApplicationController;
import dk.dtu.management.model.Client;
import dk.dtu.management.model.LogisticCompany;
import dk.dtu.management.view.ClientShareDataView;

public class ClientShareDataController {
	private LogisticCompany company;
	private Client client;
	private ClientShareDataView view;
	private ApplicationController application;
	
	public ClientShareDataController(ApplicationController application, Client client) {
		this.application = application;
		this.client = client;
		this.company = client.getCompany();
		this.view = new ClientShareDataView(this);
		displayTableAll(company.getClients());
		displayTableShared(client.getSharedWithClients());
	}
	
	public void setView(ClientShareDataView view) {
		this.view = view;
	}
	
	public void selectClient(int row) {
		Object[] data = view.getAllTableRow(row);
		client.addSharedWithClients(company.getClientById((int) data[0]));
		company.getClientById((int) data[0]).addSharedData(client);
		displayTableShared(client.getSharedWithClients());
	}
	
	public void clientSearch() {
		Set<Client> filteredName = company.filterClientsName(view.getTxtNameSearch());
		Set<Client> filteredEmail = company.filterClientsEmail(view.getTxtEmailSearch());
		filteredName.retainAll(filteredEmail);
		displayTableAll(filteredName);
	}
	
	public void displayTableAll(Set<Client> clients) {
		view.resetAllTable();
		for (Client c : clients) {
			if(!c.equals(client)) {
			view.addAllTableRow(new Object[] {c.getId(),c.getName(),c.getEmail(),c.getReferencePerson(),c.getAddress(),false});
			}
		}
	}
	
// Shared With table
	
	public void removeSharedClient(int id,String email) {
		Client c = new Client(id, email);
		client.removeSharedWithClients(c);
		company.getClientById(id).removeSharedData(client);
		displayTableShared(client.getSharedWithClients());
	}
	
	public void displayTableShared(Set<Client> clients) {
		view.resetSharedTable();
		for (Client c : clients) {
			view.addSharedTableRow(new Object[] {c.getId(),c.getName(),c.getEmail(),c.getReferencePerson(),c.getAddress(),false});
		}
	}
	
	public void display() {
		view.setVisible(true);
	}
	
	public void back() {
		view.setVisible(false);
		application.clientDashboard(client);
	}
}


