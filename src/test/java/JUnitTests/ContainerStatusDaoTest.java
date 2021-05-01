package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dk.dtu.management.dao.ContainerStatusDao;
import dk.dtu.management.model.ContainerStatus;

public class ContainerStatusDaoTest {

	private ContainerStatusDao statusDao;

	
	@Before
	public void setUp() throws Exception {
		statusDao = new ContainerStatusDao();
	}
	
	
	@Test
	public void testSave() {
		ContainerStatus status = new ContainerStatus(10.0,11.0,12.0);
		statusDao.save(status);
		
		ContainerStatus status2 = statusDao.getById(status.getId());
		assertTrue(10.0 == status2.getTemperature());
		assertTrue(11.0 == status2.getHumidity());
		assertTrue(12.0 == status2.getPressure());
	}
	
	@Test
	public void testUpdate() {
		ContainerStatus status = new ContainerStatus(10.0,11.0,12.0);
		statusDao.save(status);
		
		double newTemp = 15.0;
		double newHum = 21.0;
		double newPress = 8.0;
		
		status.setTemperature(newTemp);
		status.setHumidity(newHum);
		status.setPressure(newPress);
		
		statusDao.update(status);
		
		ContainerStatus status2 = statusDao.getById(status.getId());
		
		assertTrue(newTemp == status.getTemperature());
		assertTrue(newHum == status.getHumidity());
		assertTrue(newPress == status.getPressure());
	}
	
	@Test
	public void testDelete() {
		ContainerStatus status = new ContainerStatus(10.0,11.0,12.0);
		statusDao.save(status);
		
		statusDao.delete(status.getId());
		
		assertNull(statusDao.getById(status.getId()));
	}

}
