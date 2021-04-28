package dk.dtu.management.controller;

import dk.dtu.management.dao.ContainerStatusDao;
import dk.dtu.management.model.Client;
import dk.dtu.management.model.Container;
import dk.dtu.management.model.ContainerStatus;
import dk.dtu.management.model.Journey;
import dk.dtu.management.model.LogisticCompany;
import dk.dtu.management.view.AddStatusView;

public class AddStatusController {

	
	private LogisticCompany company;
	private AddStatusView view;
	private ApplicationController application;
	private Journey journey;
	

	
	public AddStatusController(ApplicationController application, Journey journey) {
		this.application = application;
		this.view = view; 
		this.journey = journey;
		this.view = new AddStatusView(this);
	}
	
	public void addStatus() {
		String temperature = view.getTempField();
		String humidity = view.getHumidityField();
		String pressure = view.getpressureField();
		String location = view.getLocationField();
		
		if (temperature.isEmpty() || humidity.isEmpty() || pressure.isEmpty()) {
			view.showError();
		} else {
			Container c = journey.getContainer();
			c.addStatus(new ContainerStatus(Double.parseDouble(temperature),Double.parseDouble(humidity),Double.parseDouble(pressure)));
			if (!location.isEmpty()) {
				journey.getContainer().setLocation(location);
				if (location.toLowerCase().equals(journey.getDestination().toLowerCase())) {
					journey.complete();
				}	
			}
			returnDashboard();
			
		}
		
		
	}
	

	public void returnDashboard() {
		view.setVisible(false);
		application.adminClientDashboard(journey.getClient());
	}
	
	public void display() {
		view.setVisible(true);
	}
	
	
}

