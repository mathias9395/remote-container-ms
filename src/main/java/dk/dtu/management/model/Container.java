package dk.dtu.management.model;
import java.sql.Time;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import dk.dtu.management.dao.ContainerDao;

@Entity
@Table(name = "container")
public class Container {
	@Transient
	private ContainerDao containerDao = new ContainerDao();
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "container_id", unique = true)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_fk", referencedColumnName = "client_id")
	private Client client;
	@Column(name = "location", nullable = false)
	private String location;
	
	@OneToMany(mappedBy = "container", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
	private Set<ContainerStatus> statusSet = new HashSet<ContainerStatus>();
	
	@Column(name = "available", nullable = true)
	private boolean available;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "journey_fk", referencedColumnName = "journey_id")
	private Journey journey;
	
	
	public Container() {}
	public Container(String location) {
		this.location = location;
		this.available = true;
		containerDao.save(this);
	}
	
	
	
	public Journey getJourney() {
		return journey;
	}
	public void setJourney(Journey journey) {
		this.journey = journey;
		containerDao.update(this);
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
		containerDao.update(this);
	}
	public int getId() {
		return id;
	}

	public Set<ContainerStatus> getStatusSet() {
		return statusSet;
	}
	public void setStatusSet(Set<ContainerStatus> statusSet) {
		this.statusSet = statusSet;
		containerDao.update(this);
	}
	public void setId(int id) {
		this.id = id;
		containerDao.update(this);
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
		containerDao.update(this);
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
		containerDao.update(this);
	}
	
	public void addStatus(ContainerStatus status) {
		status.setContainer(this);
		statusSet.add(status);
		containerDao.update(this);
	}
	
	public void reset() {
		client = null;
		statusSet = new HashSet<ContainerStatus>();
		available = true;
		containerDao.update(this);
		journey = null;
	}
}
