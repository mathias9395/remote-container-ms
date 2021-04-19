package dk.dtu.management.controller;

import dk.dtu.management.dao.ClientDao;
import dk.dtu.management.model.Client;
import dk.dtu.management.model.LogisticCompany;
import dk.dtu.management.view.AddClientView;

public class AddClientController {
	private LogisticCompany company;
	private AddClientView view;
	private ApplicationController application;
	
	public AddClientController(ApplicationController application, LogisticCompany company) {
		this.application = application;
		this.company = company;
		this.view = new AddClientView(this);
	}
	
	public void addClient() {
		String name = view.getNameField();
		String email = view.getEmailField();
		String referencePerson = view.getReferencePersonField();
		String password = view.getPasswordField();
		String address = view.getAddressField();
		if (name.isEmpty() || email.isEmpty() || referencePerson.isEmpty() || password.isEmpty() || address.isEmpty()) {
			view.showError();
		} else {
			Boolean success = company.addClient(new Client(name,email,referencePerson,password,address));
			if (!success) {
				view.showEmailError();
			} else {
				returnDashboard();
			}
		}
		
	}
	public void returnDashboard() {
		view.setVisible(false);
		application.adminDashboard();
	}
	
	public void display() {
		view.setVisible(true);
	}
	
	
}
