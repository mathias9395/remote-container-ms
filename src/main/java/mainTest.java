import java.util.HashMap;

public class mainTest {

	public static void main(String[] args) {
		Client c1 = new Client("Mathias", "mathias@deployit.dk", "Nima", "password", "123 street");
		Client c2 = new Client("Nima", "Nima@gmail.com", "Mathias", "password", "123 street");
		Client c3 = new Client("Nima", "Nima@gmail.com", "Mathias", "password", "123 street");
		Client c4 = new Client("Nima", "Nima@gmail.com", "Mathias", "password", "123 street");
		System.out.println(c1.getID());
		System.out.println(c2.getID());
		System.out.println(c3.getID());
		System.out.println(c4.getID());
		
		
		HashMap<String, Client> clients = new HashMap<String, Client>();
		clients.put("Mathias", c1);
		clients.put("Nima", c2);
		
		Client test = clients.get("Mathias");
		System.out.println(test.getName());
		System.out.println(clients.containsKey("Nima"));
		
		//System.out.println(clients.containsValue(c3));
	}
	
	
	
}
