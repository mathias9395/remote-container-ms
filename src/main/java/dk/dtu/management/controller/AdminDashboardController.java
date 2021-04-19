package dk.dtu.management.controller;

import java.util.Set;

import javax.swing.JOptionPane;

import dk.dtu.management.model.Client;
import dk.dtu.management.model.LogisticCompany;
import dk.dtu.management.view.AdminDashboardView;

public class AdminDashboardController {
	
	private LogisticCompany company;
	private AdminDashboardView view;
	private AddClientController addClientController;
	private ApplicationController application;
	
	public AdminDashboardController(ApplicationController application, LogisticCompany company) {
		this.application = application;
		this.company = company;
		this.view = new AdminDashboardView(this);
		displayTable(company.getClients());
	}
	
	public void addClient() {
		view.setVisible(false);
		application.addClient();
		
	}
	
	public void logout() {
		view.setVisible(false);
		application.login();
	}
	
	public void setView(AdminDashboardView view) {
		this.view = view;
	}
	
	public void selectClient(int row) {
		Object[] data = view.getTableRow(row);
		Client c = new Client((Integer) data[0], data[1].toString());
		view.setVisible(false);
	}
	
	public void clientSearch() {
		Set<Client> filteredName = company.filterClientsName(view.getTxtNameSearch());
		Set<Client> filteredEmail = company.filterClientsEmail(view.getTxtEmailSearch());
		filteredName.retainAll(filteredEmail);
		displayTable(filteredName);
	}
	
	public void displayTable(Set<Client> clients) {
		view.resetTable();
		for (Client c : clients) {
			view.addTableRow(new Object[] {c.getId(),c.getName(),c.getEmail(),c.getReferencePerson(),c.getAddress()});
		}
	}
	
	public void deleteClient(int row) {
		Object[] data = view.getTableRow(row);
		Client c = new Client((Integer) data[0], data[1].toString());
		company.removeClient(c);
 		clientSearch();
	}
	
	public void display() {
		view.setVisible(true);
	}
}
