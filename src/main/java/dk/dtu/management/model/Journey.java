package dk.dtu.management.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import dk.dtu.management.dao.JourneyDao;


@Entity
@Table(name = "journey")
public class Journey {
	@Transient
	private JourneyDao journeyDao = new JourneyDao();
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "journey_id", unique = true)
	private int id;
	@Column(name = "origin", nullable = true)
	private String origin;
	@Column(name = "destination", nullable = true)
	private String destination;
	@Column(name = "content_type", nullable = true)
	private String contentType;
	@Column(name = "company", nullable = true)
	private String company;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_fk", referencedColumnName = "client_id")
	private Client client;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "container_fk", referencedColumnName = "container_id")
	private Container container;//NOT STORED IN DB
	
	@Column(name = "on_journey", nullable = true)
	private boolean onJourney;
	
	
	public Journey () {
		
	}
	public Journey(int id) {
		this.id = id;
	}
	
	public Journey(String origin, String destination, String contentType, String company) {
		this.origin = origin;
		this.destination = destination;
		this.contentType =  contentType;
		this.company = company;
		this.onJourney = false;
		this.container = null;
		journeyDao.save(this);
	}
	
	
	
	public boolean isOnJourney() {
		return onJourney;
	}
	public void setOnJourney(boolean onJourney) {
		this.onJourney = onJourney;
		journeyDao.update(this);
	}
	public void setContainer(Container container) {
		this.container = container;
		onJourney = true;
		container.setAvailable(false);
		container.setJourney(this);
		journeyDao.update(this);
	}
	
	public Container getContainer() {
		return container;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
		journeyDao.update(this);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
		journeyDao.update(this);
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
		journeyDao.update(this);
	}
	public void setCompany(String company) {
		this.company = company;
		journeyDao.update(this);
	}
	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin =origin;
		journeyDao.update(this);
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
		journeyDao.update(this);
		
		
	}
	
	public String getContentType() {
		return contentType;
	}

	public String getCompany() {
		return company;
	}
		

	

	
	public String toString() {
		return "Origin: "+ origin + ". Destination:" + destination;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Journey) {
			Journey compare = (Journey) obj;
			return id == compare.id;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17,37).append(id).toHashCode();
	}


	public void update(String origin, String destination, String contentType, String company) {
		this.origin = origin;
		this.destination = destination;
		this.contentType = contentType;
		this.company = company;
		
		journeyDao.update(this);
	}
	public void delete() {
		journeyDao.delete(id);
		
	}
	
	
	
	

}
