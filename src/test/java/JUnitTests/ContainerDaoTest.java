package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dk.dtu.management.dao.ContainerDao;
import dk.dtu.management.model.Container;

public class ContainerDaoTest {

private ContainerDao containerDao;

	
	@Before
	public void setUp() throws Exception {
		containerDao = new ContainerDao();
	}
	
	
	@Test
	public void testSave() {
		Container container = new Container("copenhagen");
		containerDao.save(container);
		
		Container container2 = containerDao.getById(container.getId());
		assertEquals("copenhagen", container2.getLocation());
	}
	
	@Test
	public void testUpdate() {
		Container container = new Container("copenhagen");
		containerDao.save(container);
		
		String newLocation = "hamburg";
		container.setLocation(newLocation);
		
		containerDao.update(container);
		
		Container container2 = containerDao.getById(container.getId());
		assertEquals(newLocation, container2.getLocation());
	}
	
	@Test
	public void testDelete() {
		Container container = new Container("copenhagen");
		containerDao.save(container);
		
		containerDao.delete(container.getId());
		
		assertNull(containerDao.getById(container.getId()));
	}

}
