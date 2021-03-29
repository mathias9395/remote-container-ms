import java.util.HashMap;

public class LogisticCompany {
	
	private HashMap<String, Client> clients;
	
	public HashMap<String, Client> getClients() {
		return clients;
	}

	public void setClients(HashMap<String, Client> clients) {
		this.clients = clients;
	}

	public LogisticCompany () {
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
	
	public Client deleteClient(Client client) {
		
		//clients.remove(client);
		return clients.remove(client);
		
	}


}
