package dk.dtu.management.model;
import java.util.*;

import dk.dtu.management.dao.ClientDao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "client")
public class Client extends User {
	@Transient
	private ClientDao clientDao = new ClientDao();
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "client_id", unique = true)
	private int id;
	@Column(name = "name", nullable = true)
	private String name;
	@Column(name = "address", nullable = true)
	private String address;
	@Column(name = "referencePerson", nullable = true)
	private String referencePerson;
	@Column(name = "email", nullable = true)
	private String email;
	@Column(name = "password", nullable = true)
	private String password;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_fk", referencedColumnName = "company_id")
	private LogisticCompany company;
	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
	private Set<Journey> journeySet = new HashSet<Journey>();
	
	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
	private List<Message> messages = new ArrayList<Message>();
	
	
	
	
	
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "shared_data", 
        joinColumns = { @JoinColumn(name = "shared") }, 
        inverseJoinColumns = { @JoinColumn(name = "received") }
    )
	public Set<Client> sharedData = new HashSet<>(); //NOT SAVED IN DATABASE
	
	@ManyToMany(mappedBy = "sharedData",fetch = FetchType.EAGER)
	public Set<Client> sharedWithClients = new HashSet<>(); //NOT SAVED IN DATABASE
	
	
	
	public Client() {
		super();
	};
	
	public Client(int id, String email) {
		this.id = id;
		this.email = email;
	}
	
	public Client(String name, String email, String referencePerson, String password, String address) {
		this.name = name;
		this.email = email;
		this.referencePerson = referencePerson;
		this.password = password;
		this.address = address;
		clientDao.save(this);
		
	}
	
	public void addJourney(Journey journey) {
		journey.setClient(this);
		journeySet.add(journey);
		clientDao.update(this);
		
	}
	
	
	public Set<Journey> getJourneySet() {
		return journeySet;
	}

	public void setJourneySet(Set<Journey> journeySet) {
		this.journeySet = journeySet;
		clientDao.update(this);
	}

	public Boolean update(String name, String email, String referencePerson, String address) {
		if (company != null && company.clientWithEmail(this,email)) {
			return false;
		}
		this.name = name;
		this.email = email;
		this.referencePerson = referencePerson;
		this.address = address;
		
		
		clientDao.update(this);
		return true;
	}
	public String getAddress() {
		return address;
	}


	public LogisticCompany getCompany() {
		return company;
	}

	public void setCompany(LogisticCompany company) {
		this.company = company;
		clientDao.update(this);
	}

	public void setAddress(String address) {
		this.address = address;
		clientDao.update(this);
	}

	public String getReferencePerson() {
		return referencePerson;
	}

	public void setReferencePerson(String referencePerson) {
		this.referencePerson = referencePerson;
		clientDao.update(this);
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		clientDao.update(this);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		clientDao.update(this);
	}
	
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
		clientDao.update(this);
	}

	public void setName(String name) {
		this.name = name;
		clientDao.update(this);
	}
	
	public String toString() {
		return "Name: "+ name + ". Email:" + email;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Client) {
			Client compare = (Client) obj;
			return (id == compare.id) && email.equals(compare.email);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17,37).append(id).append(email).toHashCode();
	}

	public Set<Journey> filterJourneysContent(String content) {
		Set<Journey> filteredJourneys = new HashSet<>();
		for(Journey entry: journeySet) {
			if (entry.getContentType().toLowerCase().contains(content.toLowerCase())) {
				filteredJourneys.add(entry);
			}
		}

		return filteredJourneys;
		
	}

	public Set<Journey> filterJourneysOrigin(String origin) {
		Set<Journey> filteredJourneys = new HashSet<>();
		for(Journey entry: journeySet) {
			if (entry.getOrigin().toLowerCase().contains(origin.toLowerCase())) {
				filteredJourneys.add(entry);
			}
		}

		return filteredJourneys;
	}
	
	public Set<Journey> filterJourneyDestination(String destination) {
		Set<Journey> filteredJourneys = new HashSet<>();
		for(Journey entry: journeySet) {
			if (entry.getDestination().toLowerCase().contains(destination.toLowerCase())) {
				filteredJourneys.add(entry);
			}
		}

		return filteredJourneys;
	}
	
	public void delete() {
		clientDao.delete(id);
	}	
	
	//SHARED DATA METHODS
	public void addSharedWithClients(Client c) {
		sharedWithClients.add(c);
		clientDao.update(this);
	}
	
	public void removeSharedWithClients(Client c) {
		sharedWithClients.remove(c);
		clientDao.update(this);
	}

	public Set<Client> getSharedWithClients() {
		return sharedWithClients;
	}
	
	public void addSharedData(Client c) {
		sharedData.add(c);
		clientDao.update(this);
	}
	
	public void removeSharedData(Client c) {
		sharedData.remove(c);
		clientDao.update(this);
	}
	
	public Set<Client> getSharedData(){
		return sharedData;
	}
	

	public void removeJourney(Journey journey) {
		if (journeySet.contains(journey)) {
			journey.delete();
			journeySet.remove(journey);
			clientDao.update(this);
		}
		
	}

	public void addMessage(Message message) {
		System.out.println(message.getSender());
		System.out.println(message.getContent());
		messages.add(message);
		message.setClient(this);
		clientDao.update(this);
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
		clientDao.update(this);
	}
	
	public Set<Journey> filterOnJourney() {
		Set<Journey> filteredJourneys = new HashSet<>();
		for(Journey j : journeySet) {
			if (!j.isOnJourney()) {
				filteredJourneys.add(j);
			}
		}

		return filteredJourneys;
	}

	public Journey getJourneyById(int id) {
		for (Journey j : journeySet) {
			if (j.getId() == id) {
				return j;
			}
		}
		return null;
	}

	public Set<Journey> getNewJourneys() {
		Set<Journey> newJourneys = new HashSet<Journey>();
		for (Journey j : journeySet) {
			if (!j.isOnJourney()) {
				newJourneys.add(j);
			}
		}
		return newJourneys;
	}

	public Set<Journey> getCurrentJourneys() {
		Set<Journey> currentJourneys = new HashSet<Journey>();
		for (Journey j : journeySet) {
			if (!j.isCompleted()) {
				currentJourneys.add(j);
			}
		}
		return currentJourneys;
	}

}
