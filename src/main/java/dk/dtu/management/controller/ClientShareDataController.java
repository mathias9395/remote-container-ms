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
	//private AddClientController addClientController;
	private ApplicationController application;
	
	public ClientShareDataController(ApplicationController application, Client client) {
		this.application = application;
		this.client = client;
		this.company = client.getCompany();
		this.view = new ClientShareDataView(this);
		displayTableAll(company.getClients());
	}
	
	public void setView(ClientShareDataView view) {
		this.view = view;
	}
	
	// Should add to sharedWith table
	public void selectClient(int row) {
		Object[] data = view.getTableRow(row);
		Client c = company.getClientById((int) data[0]);
		view.setVisible(false);
		application.adminClientDashboard(c);
	}
	
	public void clientSearch() {
		Set<Client> filteredName = company.filterClientsName(view.getTxtNameSearch());
		Set<Client> filteredEmail = company.filterClientsEmail(view.getTxtEmailSearch());
		filteredName.retainAll(filteredEmail);
		displayTableAll(filteredName);
	}
	
	public void displayTableAll(Set<Client> clients) {
		view.resetTable();
		for (Client c : clients) {
			view.addTableRow(new Object[] {c.getId(),c.getName(),c.getEmail(),c.getReferencePerson(),c.getAddress(),false});
			//view.addTableRow(new Object[] {c.getId(),c.getName(),c.getEmail(),c.getReferencePerson(),c.getAddress()});
		}
	}
	

	public void removeSharedClient(int id,String email) {
//		Object[] data = view.getTableRow(row);
		Client c = new Client(id, email);
		client.removeSharedWithClients(c);
	}
	
	public void display() {
		view.setVisible(true);
	}
}


