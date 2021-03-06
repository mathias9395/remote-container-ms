package dk.dtu.management.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
	
	@Column(name = "completed", nullable = true)
	private Boolean completed;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "container_fk", referencedColumnName = "container_id", nullable=true)
	private Container container;//NOT STORED IN DB
	
	@Column(name = "on_journey", nullable = true)
	private boolean onJourney;
	
	@OneToMany(mappedBy = "journey", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
	private List<ContainerStatus> journeyData;
	
	
	public Journey () {
		
	}
	
	public Journey(String origin, String destination, String contentType, String company) {
		this.origin = origin;
		this.destination = destination;
		this.contentType =  contentType;
		this.company = company;
		this.onJourney = false;
		this.completed = false;
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
	
	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}
	
	public String getContentType() {
		return contentType;
	}

	public String getCompany() {
		return company;
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
	
	public void delete() {
		if (container != null) {
			container.reset();
		}
		client = null;
		container = null;
		
		journeyDao.update(this);
		
	}
	
	public void complete() {
		this.completed = true;
		this.onJourney = false;
		journeyData = container.getStatusSet();
		container.reset();
		this.container = null;
		journeyDao.update(this);
	}
	
	public boolean isCompleted() {
		return completed;
	}
	public List<ContainerStatus> getJourneyData() {
		return journeyData;
	}

	public Container getContainer() {
		return container;
	}
	
	public void setCompleted(boolean completed) {
		this.completed = completed;
		journeyDao.update(this);
	}
	
}
