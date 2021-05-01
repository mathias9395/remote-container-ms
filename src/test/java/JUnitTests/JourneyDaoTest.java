package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dk.dtu.management.dao.JourneyDao;
import dk.dtu.management.model.Journey;

public class JourneyDaoTest {

	private JourneyDao journeyDao;

	
	@Before
	public void setUp() throws Exception {
		journeyDao = new JourneyDao();
	}
	
	
	@Test
	public void testSave() {
		Journey journey = new Journey("copenhagen","hamburg","apples","amazon");
		journeyDao.save(journey);
		
		Journey journey2 = journeyDao.getById(journey.getId());
		assertEquals("copenhagen", journey2.getOrigin());
		assertEquals("hamburg", journey2.getDestination());
		assertEquals("apples", journey2.getContentType());
		assertEquals("amazon", journey2.getCompany());
	}
	
	@Test
	public void testUpdate() {
		Journey journey = new Journey("copenhagen","hamburg","apples","amazon");
		journey.setOnJourney(false);
		journeyDao.save(journey);
		
		
		journey.setOnJourney(true);
		
		journeyDao.update(journey);
		
		Journey journey2 = journeyDao.getById(journey.getId());
		assertEquals(true,journey2.isOnJourney());
	}
	
	@Test
	public void testDelete() {
		Journey journey = new Journey("copenhagen","hamburg","apples","amazon");
		journeyDao.save(journey);
		
		journeyDao.delete(journey.getId());
		
		assertNull(journeyDao.getById(journey.getId()));
	}

}
