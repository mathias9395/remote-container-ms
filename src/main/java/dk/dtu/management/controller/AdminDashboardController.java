package dk.dtu.management.controller;

import java.util.Set;

import javax.swing.JOptionPane;

import dk.dtu.management.model.Client;
import dk.dtu.management.model.LogisticCompany;
import dk.dtu.management.view.AdminDashboardView;

public class AdminDashboardController {
	
	private LogisticCompany company;
	private AdminDashboardView view;
	//private AddClientController addClientController;
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
		Client c = company.getClientById((int) data[0]);
		view.setVisible(false);
		application.adminClientDashboard(c);
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
			view.addTableRow(new Object[] {c.getId(),c.getName(),c.getEmail(),c.getReferencePerson(),c.getAddress(),false});
			//view.addTableRow(new Object[] {c.getId(),c.getName(),c.getEmail(),c.getReferencePerson(),c.getAddress()});
		}
	}
	
	public void deleteClient(int id) {
		
		
//		Object[] data = view.getTableRow(row);
		Client c = company.getClientById(id);
		company.removeClient(c);
	}
	
	public void display() {
		view.setVisible(true);
	}
	
	public void addContainer() {
		view.setVisible(false);
		application.addContainer();
	}
	
	
}
