package dk.dtu.management.controller;

import dk.dtu.management.model.LogisticCompany;
import dk.dtu.management.view.AddStatusView;

public class AddStatusController {

	
	private AddStatusView view;
	private ApplicationController application;

	
	public AddStatusController(ApplicationController application, AddStatusView view) {
		this.application = application;
		this.view = view; 
		this.view = new AddStatusView(this);
	}
	
	public void addStatus() {
		String temperature = view.getTempField();
		String humidity = view.getHumidityField();
		String pressure = view.getpressureField();
		
		
	}
	

public void returnDashboard() {
	view.setVisible(false);
	application.adminDashboard();
}
	
	public void display() {
		view.setVisible(true);
	}
	
	
}

