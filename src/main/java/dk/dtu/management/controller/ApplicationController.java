package dk.dtu.management.controller;

import java.util.Set;

import dk.dtu.management.dao.LogisticCompanyDao;
import dk.dtu.management.model.Client;
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
	
	// NEW
//	public void addStatus() {
//		AddStatus addStatus = new AddStatus();
//	}
//	public void add() {
//		Add add = new Add();
//	}
//	public void Admin_clientDash() {
//		Admin_clientDashboardView addStatus = new Admin_clientDashboardView();
//	}
//	public void clientDashboard() {
//		ClientDashboard clientDashboard = new ClientDashboard();
//	}
//	public void clientDestination() {
//		ClientDestination clientDestination = new ClientDestination();
//	}
//	public void update() {
//		Update update = new Update();
//	}
//	public void updateClientInfo() {
//		updateClientInfo update = new updateClientInfo();
//	}
	
	
	public static void main(String[] args) {
		ApplicationController app = new ApplicationController();
		company = new LogisticCompany().getInstance();
		
		
		

		//company = companyDao.getById(1);
		//company = new LogisticCompany("bbb","bbb");
//		Set<LogisticCompany> companies = (Set<LogisticCompany>) companyDao.getAll();
//		for (LogisticCompany c : companies) {
//			System.out.println(c.getId() + " " + c.getEmail());
//		}

//		Client client = new Client("Name","Email","rwefwefw","password","address");
//		Client client2 = new Client("Mathias","mathias@gmail.com","Nima","password","123 address");
//		company.addClient(client);
//		company.addClient(client2);
		
		
		
		app.login();
		
		//NEW
		//app.addStatus();

	}

}
