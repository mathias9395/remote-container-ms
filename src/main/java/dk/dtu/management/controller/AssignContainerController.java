package dk.dtu.management.controller;

import java.util.Set;

import dk.dtu.management.model.Container;
import dk.dtu.management.model.Journey;
import dk.dtu.management.model.LogisticCompany;
import dk.dtu.management.view.AssignContainerView;

public class AssignContainerController {
	private ApplicationController controller;
	private LogisticCompany company;
	private Journey journey;
	private AssignContainerView view;

	public AssignContainerController(ApplicationController controller, LogisticCompany company,
			Journey journey) {
		this.controller = controller;
		this.company = company;
		this.journey = journey;
		this.view = new AssignContainerView(this);
		displayTable(company.getContainers());
	}
	
	public void display() {
		view.setVisible(true);
	}
	
	public void displayTable(Set<Container> containers) {
		view.resetTable();
		for (Container c : containers) {
			if (c.isAvailable()) {
				view.addTableRow(new Object[] {c.getId(),c.getLocation()});
			}
		}
	}

	public void back() {
		view.setVisible(false);
		controller.adminClientDashboard(journey.getClient());	
	}

	public void selectedContainer(int row) {
		int id = view.getTableRow(row);
		Container c = company.getContainerById(id);
		if (!c.getLocation().toLowerCase().equals(journey.getOrigin().toLowerCase())) {
			view.showError();
		} else {
			journey.setContainer(c);
			
			back();
		}
		
	}

}
