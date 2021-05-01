package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dk.dtu.management.dao.ClientDao;
import dk.dtu.management.dao.MessageDao;
import dk.dtu.management.model.Client;
import dk.dtu.management.model.Message;

public class MessageDaoTest {

	private MessageDao messageDao;
	private ClientDao clientDao;
	private Client client;

	
	@Before
	public void setUp() throws Exception {
		messageDao = new MessageDao();
		clientDao = new ClientDao();
		client = new Client();
		clientDao.save(client);
	}
	
	
	@Test
	public void testSave() {
		
		Message message = new Message(client, true, "Test message");
		messageDao.save(message);
		
		Message message2 = messageDao.getById(message.getId());
		assertEquals(true, message.getSender());
		assertEquals("Test message", message2.getContent());
	}
	
	@Test
	public void testUpdate() {
		Message message = new Message(client, true, "Test message");
		messageDao.save(message);
		
		String newMessage = "New message";
		
		message.setContent(newMessage);
		
		messageDao.update(message);
		
		Message message2 = messageDao.getById(message.getId());
		assertEquals(newMessage, message2.getContent());
	}
	
	@Test
	public void testDelete() {
		Message message = new Message(client, true, "Test message");
		messageDao.save(message);
		
		messageDao.delete(message.getId());
		
		assertNull(messageDao.getById(message.getId()));
	}

}
