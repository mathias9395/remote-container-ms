package dk.dtu.management.controller;

import dk.dtu.management.dao.LogisticCompanyDao;
import dk.dtu.management.model.Client;
import dk.dtu.management.model.LogisticCompany;

public class ApplicationController {

	private AdminDashboardController adminDashboardController;
	private static LogisticCompany company;
	private static LogisticCompanyDao companyDao;
	private LoginController loginController;
	private AddClientController addClientController;
	private ClientDashboardController clientDashboardController;
	
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
	
	public static void main(String[] args) {
		ApplicationController app = new ApplicationController();
		companyDao = new LogisticCompanyDao();
		company = companyDao.getById(1);
//		Client client = new Client("Name","Email","rwefwefw","password","address");
//		Client client2 = new Client("Mathias","mathias@gmail.com","Nima","password","123 address");
//		company.addClient(client);
//		company.addClient(client2);
		app.login();

	}

}
