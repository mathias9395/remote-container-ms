package dk.dtu.management.controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;

import dk.dtu.management.model.Client;
import dk.dtu.management.model.Container;
import dk.dtu.management.model.ContainerStatus;
import dk.dtu.management.model.Journey;
import dk.dtu.management.view.ClientViewStatusView;
public class ClientViewStatusController {

	private ClientViewStatusView view;
	private ApplicationController application;
	private Journey journey;
	private Container container;


	
	public ClientViewStatusController(ApplicationController application, Journey journey) {
		this.application = application;
		this.journey = journey;
		if (this.journey.isOnJourney()) {
			this.container = journey.getContainer();
		}
		this.view = new ClientViewStatusView(this);
	}
	
	
	
	

	public String getTemperature() {
		ContainerStatus status;
		if (journey.isCompleted()) {
			status = journey.getJourneyData().get(journey.getJourneyData().size()-1);
		}
		else if (!journey.isOnJourney() || container.getStatusSet().isEmpty()) {
			return "n/a";
		} else {
			status = container.getStatusSet().get(container.getStatusSet().size()-1);
			
		}
		Double recentTemp = status.getTemperature();
		return recentTemp.toString();
	}
	
	public  String getHumidity() {
		ContainerStatus status;
		if (journey.isCompleted()) {
			status = journey.getJourneyData().get(journey.getJourneyData().size()-1);
		}
		else if (!journey.isOnJourney() || container.getStatusSet().isEmpty()) {
			return "n/a";
		} else {
			status = container.getStatusSet().get(container.getStatusSet().size()-1);
			
		}
		Double recentHumidity = status.getHumidity();
		return recentHumidity.toString();
		
	}
	
	public String getPressure() {
		ContainerStatus status;
		if (journey.isCompleted()) {
			status = journey.getJourneyData().get(journey.getJourneyData().size()-1);
		}
		else if (!journey.isOnJourney() || container.getStatusSet().isEmpty()) {
			return "n/a";
		} else {
			status = container.getStatusSet().get(container.getStatusSet().size()-1);
			
		}
		Double recentPressure = status.getPressure();
		return recentPressure.toString();
	}
	
	public String getTime() {
		ContainerStatus status;
		if (journey.isCompleted()) {
			status = journey.getJourneyData().get(journey.getJourneyData().size()-1);
		}
		else if (!journey.isOnJourney() || container.getStatusSet().isEmpty()) {
			return "n/a";
		} else {
			status = container.getStatusSet().get(container.getStatusSet().size()-1);
			
		}
		int recentTime = status.getTime();
		return String.valueOf(recentTime);
	}

	
	
	public double[] timeList() {
		List<ContainerStatus> statusList;
		if (journey.isCompleted()) {
			statusList = journey.getJourneyData();
		} else if (!journey.isOnJourney()) {
			statusList = new ArrayList<ContainerStatus>();
		}
		
		else {
			statusList = container.getStatusSet();
		}
		double[] times = new double[statusList.size()];
		int counter = 0;
		for (ContainerStatus s : statusList) {
			times[counter] = counter;
			counter++;
		}
		return times;
	}
	
	public double[] pressureList() {
		List<ContainerStatus> statusList;
		if (journey.isCompleted()) {
			statusList = journey.getJourneyData();
		}else if (!journey.isOnJourney()) {
			statusList = new ArrayList<ContainerStatus>();
		} else {
			statusList = container.getStatusSet();
		}
		double[] pressures = new double[statusList.size()];
		int counter = 0;
		for (ContainerStatus s : statusList) {
			pressures[counter] = s.getPressure();
			counter++;
		}
		return pressures;
	}
	
	public double[] tempList() {
		List<ContainerStatus> statusList;
		if (journey.isCompleted()) {
			statusList = journey.getJourneyData();
		} else if (!journey.isOnJourney()) {
			statusList = new ArrayList<ContainerStatus>();
		} else {
			statusList = container.getStatusSet();
		}
		double[] temps = new double[statusList.size()];
		int counter = 0;
		for (ContainerStatus s : statusList) {
			temps[counter] = s.getTemperature();
			counter++;
		}
		return temps;
	}
	public double[] humidityList() {
		List<ContainerStatus> statusList;
		if (journey.isCompleted()) {
			statusList = journey.getJourneyData();
		} else if (!journey.isOnJourney()) {
			statusList = new ArrayList<ContainerStatus>();
		} else {
			statusList = container.getStatusSet();
		}
		double[] humidities = new double[statusList.size()];
		int counter = 0;
		for (ContainerStatus s : statusList) {
			humidities[counter] = s.getPressure();
			counter++;
		}
		return humidities;
	}
	

	public void returnDashboard() {
		
		view.setVisible(false);
		application.clientDashboard(journey.getClient());
	}
		
	public void display() {
		view.setVisible(true);
	}

	public String getLocation() {
		if (journey.isCompleted()) {
			return journey.getDestination();
		} else if (!journey.isOnJourney()) {
			return journey.getOrigin();
		} else {
			return container.getLocation();
		}
		
	}





	public String getStatus() {
		if (journey.isCompleted()) {
			return "Completed";
		} else if (journey.isOnJourney()) {
			return "On journey";
		} else {
			return "Waiting for approval";
		}
	}
	
}


