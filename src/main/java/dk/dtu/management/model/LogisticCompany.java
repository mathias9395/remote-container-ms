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

	public LogisticCompany() {
	}
	
	public LogisticCompany(String email, String password) {
		this.email = email;
		this.password = password;
		companyDao.save(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		companyDao.update(this);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		companyDao.update(this);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		companyDao.update(this);
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
		companyDao.update(this);
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
	
	
	
	
	
	
	//SHARED DATA METHODS
	public void shareData(Client client) {
		for (Client temp : client.getShareClient()) {
	        if(clients.contains(temp)) {
	        	temp.setSharedData(client.toString());
	        }
		}
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

	

}
