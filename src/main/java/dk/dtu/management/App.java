package dk.dtu.management;

import java.util.Date;
import dk.dtu.management.dao.*;

import dk.dtu.management.model.*;

public class App {

	public static void main(String[] args) {
		
		Client client1 = new Client("name1","email1","reference person1","password1","address1");
		LogisticCompany company = new LogisticCompany("email","password");
		
		company.addClient(client1);
		
		Container container1 = new Container("location1");
		ContainerStatus status1 = new ContainerStatus(1.123,1.452,53.42);
		
		container1.addStatus(status1);
		
		client1.addContainer(container1);
		
		Journey journey1 = new Journey("origin1","destination1","contentType1","company1");
		
		client1.addJourney(journey1);
		
		
//		ClientDao clientDao = new ClientDao();
//		ContainerDao containerDao = new ContainerDao();
//		ContainerStatusDao statusDao = new ContainerStatusDao();
//		JourneyDao journeyDao = new JourneyDao();
//		LogisticCompanyDao companyDao = new LogisticCompanyDao();
//		
//		Client client1 = new Client("name1","email1","reference person1","password1","address1");
//		clientDao.save(client1);
//		
//		LogisticCompany company = new LogisticCompany("email","password");
//		companyDao.save(company);
//		
//		company.addClient(client1);
//		clientDao.update(client1);
//		companyDao.update(company);
//		
//		Container container1 = new Container("location1");
//		containerDao.save(container1);
//		
//		ContainerStatus status1 = new ContainerStatus(1.123,1.452,53.42,new Date().getMinutes());
//		statusDao.save(status1);
//		
//		container1.addStatus(status1);
//		statusDao.update(status1);
//		containerDao.update(container1);
//		
//		client1.addContainer(container1);
//		containerDao.update(container1);
//		clientDao.update(client1);
//		
//		Journey journey1 = new Journey("origin1","destination1","contentType1","company1");
//		journeyDao.save(journey1);
//		
//		
//		client1.addJourney(journey1);
//		journeyDao.update(journey1);
//		clientDao.update(client1);
		
	}

}
