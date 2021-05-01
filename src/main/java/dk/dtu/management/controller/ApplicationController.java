package dk.dtu.management.controller;

import java.util.Set;

import dk.dtu.management.dao.LogisticCompanyDao;
import dk.dtu.management.model.Client;
import dk.dtu.management.model.Journey;
import dk.dtu.management.model.LogisticCompany;
import dk.dtu.management.view.*;

public class ApplicationController {

	private AdminDashboardController adminDashboardController;
	private static LogisticCompany company;
	private LoginController loginController;
	private AddClientController addClientController;
	private ClientDashboardController clientDashboardController;
	private AddJourneyController addJourneyController;
	private ClientSettingsController clientSettingsController;
	private AdminClientDashboardController adminClientDashboardController;
	private ClientMessageController clientMessageController;
	private AdminMessageController adminMessageController;
	private AddStatusController addStatusController;
	private ClientViewStatusController clientViewStatusController;
	
	private ClientShareDataController clientShareDataController;
	private ClientViewSharedDataController clientViewSharedDataController;
	private ClientClientsDataController clientClientsDataController;
	private AddContainerController addContainerController;
	private AssignContainerController assignContainerController;

	
	public void adminDashboard() {
		adminDashboardController = new AdminDashboardController(this,company);
		adminDashboardController.display();
	}
	
	public void clientDashboard(Client client) {
		clientDashboardController = new ClientDashboardController(this,client);
		clientDashboardController.display();
	}
	
	public void login() {
		loginController = new LoginController(this,company);
		loginController.display();
	}
	
	public void addClient() {
		addClientController = new AddClientController(this,company);
		addClientController.display();
	}
	
	public void addJourney(Client client) {
		addJourneyController = new AddJourneyController(this,client);
		addJourneyController.display();
	}
	
	public void clientSettings(Client client) {
		clientSettingsController = new ClientSettingsController(this,client);
		clientSettingsController.display();
	}
	
	public void adminClientDashboard(Client client) {
		adminClientDashboardController = new AdminClientDashboardController(this, client);
		adminClientDashboardController.display();
	}
	
	
	public void clientMessage(Client client) {
		clientMessageController = new ClientMessageController(this,client);
		clientMessageController.display();
		
	}
	public void adminMessage(Client client) {
		adminMessageController = new AdminMessageController(this,client);
		adminMessageController.display();
		
	}
	public void addStatus(Journey journey) {
		addStatusController = new AddStatusController(this,journey);
		addStatusController.display();
	}
	
	public void clientShareData(Client client) {
		clientShareDataController = new ClientShareDataController(this,client);
		clientShareDataController.display();
	}
	
	public void clientViewSharedData(Client client) {
		clientViewSharedDataController = new ClientViewSharedDataController(this,client);
		clientViewSharedDataController.display();
	}
	
	public void clientClientsData(Client clientData, Client clientOG) {
		clientClientsDataController = new ClientClientsDataController(this, clientData, clientOG);
		clientClientsDataController.display();
	}
	
	public void addContainer() {
		addContainerController = new AddContainerController(this,company);
		addContainerController.display();
		
	}
	
	public void assignContainer(Journey journey) {
		assignContainerController = new AssignContainerController(this,company,journey);
		assignContainerController.display();
		
	}
	
	public void viewStatus(Journey journey) {
		clientViewStatusController = new ClientViewStatusController(this,journey);
		clientViewStatusController.display();
		
	}
	
	
	public static void main(String[] args) {
		ApplicationController app = new ApplicationController();
		company = new LogisticCompany().getInstance();
		
		app.login();

	}

}
