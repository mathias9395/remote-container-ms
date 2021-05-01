package dk.dtu.management.model;
import java.util.*;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import dk.dtu.management.dao.LogisticCompanyDao;

@Entity
@Table(name = "company")
public class LogisticCompany extends User {
	@Transient
	private static LogisticCompanyDao companyDao = new LogisticCompanyDao();
	@Transient
	private static LogisticCompany instance;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id", unique = true)
	private int id;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "password", nullable = false)
	private String password;

	
	@OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private Set<Client> clients = new HashSet<Client>();
	
	@OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private Set<Container> containers = new HashSet<Container>(); //NOT STORED IN DB

	public LogisticCompany() {
	}
	
	public LogisticCompany(String email, String password) {
		this.email = email;
		this.password = password;
		companyDao.save(this);
	}
	
	public void addContainer(Container container) {
		container.setCompany(this);
		containers.add(container);
		companyDao.update(this);
	}
	
	

	public Set<Container> getContainers() {
		return containers;
	}

	public void setContainers(Set<Container> containers) {
		this.containers = containers;
		companyDao.update(this);
	}
	
	// Not used
	public String getEmail() {
		return email;
	}
	
	// Not used
	public String getPassword() {
		return password;
	}

	public Set<Client> getClients() {
		return clients;
	}
	
	public Boolean addClient(Client client) {
		
		if (clientWithEmail(client,client.getEmail())) {
			return false;
		}
		client.setCompany(this);
		clients.add(client);
		companyDao.update(this);
		return true;
	}
	
	public Boolean removeClient(Client client) {
		if (clients.contains(client)) {
			client.delete();
			clients.remove(client);
			companyDao.update(this);
			return true;
		}
		return false;
	}
	
	
	
	
	

	public Set<Client> filterClientsName(String name) {
		Set<Client> filteredClients = new HashSet<>();
		for(Client c: clients) {
			if (c.getName().toLowerCase().contains(name.toLowerCase())) {
				filteredClients.add(c);
			}
		}

		return filteredClients;
		
	}
	
	public Set<Client> filterClientsEmail(String email) {
		Set<Client> filteredClients = new HashSet<>();
		for(Client c : clients) {
			if (c.getEmail().toLowerCase().contains(email.toLowerCase())) {
				filteredClients.add(c);
			}
		}

		return filteredClients;
	}

	public boolean clientWithEmail(Client client, String email) {
		for(Client c: clients) {
			if (!c.equals(client) && c.getEmail().toLowerCase().equals(email.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	public static LogisticCompany getInstance() {
		if (companyDao.getById(1) == null) {
			instance = new LogisticCompany("admin","admin");
			
		} else {
			instance = companyDao.getById(1);
		}
		return instance;
	}

	public Client getClientById(int id) {
		for (Client c : clients) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
		
	}

	public Container getContainerById(int id) {
		for (Container c : containers) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}

	

}
