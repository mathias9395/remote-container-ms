package dk.dtu.management.controller;

import dk.dtu.management.model.Container;
import dk.dtu.management.model.LogisticCompany;
import dk.dtu.management.view.AddContainerView;

public class AddContainerController {
	private LogisticCompany company;
	private AddContainerView view;
	private ApplicationController application;
	
	public AddContainerController(ApplicationController application, LogisticCompany company) {
		this.application = application;
		this.company = company;
		this.view = new AddContainerView(this);
	}
	
	public void display() {
		view.setVisible(true);
	}

	public void addContainer() {
		String location = view.getLocationField();
		if (location.isEmpty()) {
			view.showError();
		} else {
			company.addContainer(new Container(location));
			returnDashboard();
		}
	}

	public void returnDashboard() {
		view.setVisible(false);
		application.adminDashboard();
	}

}
