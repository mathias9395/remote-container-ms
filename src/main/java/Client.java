import java.util.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


public class Client {
	private static int idCount = 1;
	private int id;
	private String name;
	private String address;
	private String referencePerson;
	private String email;
	private String password;
	private Set<Container> containerList;
	private Set<Journey> journeyList;
	public Set<String> shareClients = new HashSet<String>();
	public Set<String> sharedData = new HashSet<String>();
	
	public Client(String name, String email, String referencePerson, String password, String address) {
		this.name = name;
		this.email = email;
		this.referencePerson = referencePerson;
		this.password = password;
		this.address = address;
		this.id = idCount;
		containerList = new HashSet<Container>();
		journeyList = new HashSet<Journey>();
		idCount++;
	}
	
	public void update(String name, String email, String referencePerson, String address) {
		this.name = name;
		this.email = email;
		this.referencePerson = referencePerson;
		this.address = address;
	}
	
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReferencePerson() {
		return referencePerson;
	}

	public void setReferencePerson(String referencePerson) {
		this.referencePerson = referencePerson;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public int getID() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Name: "+ name + ". Email:" + email;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Client) {
			Client compare = (Client) obj;
			return name.equals(compare.name) && email.equals(compare.email);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17,37).append(name).append(email).append(referencePerson).append(password).append(address).append(id).toHashCode();
	}

	public void addContainer(Container container) {
		containerList.add(container);
		
	}
	
	public Set<Container> getContainerList() {
		return containerList;
	}

	public void registerJourney(Journey journey) {
		journeyList.add(journey);
	}
	
	public Set<Journey> getJourneyList() {
		return journeyList;
	}
	
//	public Journey findJourney(String origin) {
//		return journeys.get(origin);
//		
//	}
	
	//Share Data Methods
	public void addShareClients(String name) {
		shareClients.add(name);
	}
	
	public Set<String> getShareClient() {
		return shareClients;
	}
	
	public void setSharedData(String data) {//to be used by Logistic Company
		sharedData.add(data);
	}
	
	public String getSharedData() {
	String data = "";
	for (String temp : sharedData) {
        data = data+temp+"\n";
	}
	return data;
	}
	
	public Set<Journey> filterJourneysContent(String content) {
		Set<Journey> filteredJourneys = new HashSet<>();
		for(Journey entry: journeyList) {
			if (entry.getContentType().toLowerCase().contains(content.toLowerCase())) {
				filteredJourneys.add(entry);
			}
		}

		return filteredJourneys;
		
	}

	public Set<Journey> filterJourneysOrigin(String origin) {
		Set<Journey> filteredJourneys = new HashSet<>();
		for(Journey entry: journeyList) {
			if (entry.getOrigin().toLowerCase().contains(origin.toLowerCase())) {
				filteredJourneys.add(entry);
			}
		}

		return filteredJourneys;
	}

}
