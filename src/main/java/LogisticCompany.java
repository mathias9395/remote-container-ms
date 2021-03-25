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

	public ResponseObject addClient(Client client) {
		ResponseObject response;
		if (clients.containsKey(client.getName())) {
			response = new ResponseObject("Client already exists");
		} else {
			clients.put(client.getName(), client);
			response = new ResponseObject("Client successfuly created");
		}
		return response;
		
	}
	
	public Client findClient(String name) {
		return clients.get(name);
		
	}

}
