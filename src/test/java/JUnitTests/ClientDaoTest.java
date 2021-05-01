package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dk.dtu.management.dao.ClientDao;
import dk.dtu.management.model.Client;

public class ClientDaoTest {

	private ClientDao clientDao;

	
	@Before
	public void setUp() throws Exception {
		clientDao = new ClientDao();
	}
	
	
	@Test
	public void testSave() {
		Client client = new Client("Mathias","mathias@gmail.com","Nick","password","123 street");
		clientDao.save(client);
		
		Client client2 = clientDao.getById(client.getId());
		assertEquals("Mathias", client2.getName());
		assertEquals("mathias@gmail.com", client2.getEmail());
		assertEquals("Nick", client2.getReferencePerson());
		assertEquals("password", client2.getPassword());
		assertEquals("123 street", client2.getAddress());
	}
	
	@Test
	public void testUpdate() {
		Client client = new Client("Mathias","mathias@gmail.com","Nick","password","123 street");
		clientDao.save(client);
		
		String newName = "Nima";
		String newEmail = "Nima@gmail.com";
		
		client.setName(newName);
		client.setEmail(newEmail);
		
		clientDao.update(client);
		
		Client client2 = clientDao.getById(client.getId());
		assertEquals(newName, client2.getName());
		assertEquals(newEmail, client2.getEmail());
	}
	
	@Test
	public void testDelete() {
		Client client = new Client("Mathias","mathias@gmail.com","Nick","password","123 street");
		clientDao.save(client);
		
		clientDao.delete(client.getId());
		
		assertNull(clientDao.getById(client.getId()));
	}

}
