package dk.dtu.management.controller;

import java.util.Set;

import dk.dtu.management.model.Accounts;
import dk.dtu.management.model.Client;
import dk.dtu.management.model.LogisticCompany;
import dk.dtu.management.model.User;
import dk.dtu.management.view.LoginView;

public class LoginController {
	private ApplicationController application;
	private LoginView view;
	private Accounts accounts = new Accounts();
	
	public LoginController(ApplicationController application, LogisticCompany company) {
		this.application = application;
		this.view = new LoginView(this);
		for (Client c : company.getClients()) {
			accounts.addUser(c);;
		}
		accounts.addUser(company);
		
	}
	
	public void validateCredentials(String email, String password) {
		if (!email.isEmpty() && accounts.login(email, password)) {
			view.setVisible(false);
			User user = accounts.getUser(email);
			if (user instanceof LogisticCompany) {
				application.adminDashboard();
			} else {
				application.clientDashboard((Client) user);
			}
			
			
		} else {
			view.showError();
		}
		
	}
	
	public void display() {
		view.setVisible(true);
	}
}
