package dk.dtu.management.controller;

import dk.dtu.management.dao.ContainerStatusDao;
import dk.dtu.management.model.Client;
import dk.dtu.management.model.ContainerStatus;
import dk.dtu.management.model.LogisticCompany;
import dk.dtu.management.view.AddStatusView;
import dk.dtu.management.view.StatusView;
public class ClientViewStatusController {

	private ContainerStatus  ContainerStatus;
	private StatusView view;
	private ApplicationController application;
	

	
	public ClientViewStatusController(ApplicationController application, LogisticCompany company /*ContainerStatus container_status*/) {
		this.application = application;
		this.view = view; 
		this.view = new StatusView(this);
	}
	
	
	
	

	public Double getTemperature() {
		return ContainerStatus.getTemperature();
	}
	
	public  Double getHumidity() {
		return ContainerStatus.getHumidity();
	}
	
	public Double getPressure() {
		return ContainerStatus.getPressure();
	}
	

	

public void returnDashboard() {
	view.setVisible(false);
	application.adminDashboard();
}
	
	public void display() {
		view.setVisible(true);
	}
	
	
}


