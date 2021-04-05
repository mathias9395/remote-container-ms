import java.util.*;
import java.util.stream.Collectors;

public class LogisticCompany {
	
	private Map<String, Client> clients;
	
	public Map<String, Client> getClients() {
		return clients;
	}

	public void setClients(HashMap<String, Client> clients) {
		this.clients = clients;
	}

	public LogisticCompany() {
		clients = new HashMap<String, Client>();;
	}

	public void addClient(Client client) {
		if (clients.containsKey(client.getName())) {
			return;
		} else {
			clients.put(client.getName(), client);
		}
	}
	
	public Client findClient(String name) {
		return clients.get(name);
		
	}

	public void removeClient(String name) {
		clients.remove(name);
		
	}

	public Map<String,Client> filterClientsName(String name) {
		Map<String, Client> filteredClients = new HashMap<>();
		for(Map.Entry<String, Client> entry: clients.entrySet()) {
			if (entry.getKey().toLowerCase().contains(name.toLowerCase())) {
				filteredClients.put(entry.getKey(), entry.getValue());
			}
		}

		return filteredClients;
		
	}

	public Map<String, Client> filterClientsEmail(String email) {
		Map<String, Client> filteredClients = new HashMap<>();
		for(Map.Entry<String, Client> entry: clients.entrySet()) {
			if (entry.getValue().getEmail().toLowerCase().contains(email.toLowerCase())) {
				filteredClients.put(entry.getKey(), entry.getValue());
			}
		}

		return filteredClients;
	}
	
	public void shareData(Client client) {
		for (String temp : client.getShareClient()) {
	        if(clients.containsKey(temp)) {
	        	findClient(temp).setSharedData(client.toString());
	        }
		}
	}


}
