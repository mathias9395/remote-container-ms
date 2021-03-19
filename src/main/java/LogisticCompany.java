import java.util.ArrayList;

public class LogisticCompany {
	
	private ArrayList<Client> clients;
	
	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	public LogisticCompany () {
		clients = new ArrayList<Client>();
	}

	public ResponseObject addClient(Client client) {
		ResponseObject response;
		if (checkClients(client)) {
			response = new ResponseObject("Client already exists");
		} else {
			clients.add(client);
			response = new ResponseObject("Client successfuly created");
		}
		return response;
		
	}
	public boolean checkClients(Client client) {
		for (Client c : clients) {
			if (c.getName().equals(client.getName()) && c.getEmail().equals(client.getEmail())) {
				return true;
			}
		}
		return false;
	}

	public Client findClient(String name, String email) {
		for (Client c : clients) {
			if (c.getName().equals(name) && c.getEmail().equals(email)) {
				return c;
			}
		}
		return null;
		
	}

}
