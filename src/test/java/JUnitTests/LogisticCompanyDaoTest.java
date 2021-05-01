package JUnitTests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dk.dtu.management.dao.LogisticCompanyDao;
import dk.dtu.management.model.LogisticCompany;

public class LogisticCompanyDaoTest {

	private LogisticCompanyDao companyDao;

	
	@Before
	public void setUp() throws Exception {
		companyDao = new LogisticCompanyDao();
	}
	
	
	@Test
	public void testSave() {
		LogisticCompany company = new LogisticCompany("mathias@gmail.com","password");
		companyDao.save(company);
		
		LogisticCompany company2 = companyDao.getById(company.getId());
		assertEquals("mathias@gmail.com", company2.getEmail());
		assertEquals("password", company2.getPassword());
	}
	
	@Test
	public void testUpdate() {
		LogisticCompany company = new LogisticCompany("mathias@gmail.com","password");
		companyDao.save(company);
		
		String newEmail = "nima@gmail.com";
		String newPassword = "newPassword";
		
		company.setEmail(newEmail);
		company.setPassword(newPassword);
		
		companyDao.update(company);
		
		LogisticCompany company2 = companyDao.getById(company.getId());
		assertEquals(newEmail, company2.getEmail());
		assertEquals(newPassword, company2.getPassword());
	}
	
	@Test
	public void testDelete() {
		LogisticCompany company = new LogisticCompany("mathias@gmail.com","password");
		companyDao.save(company);
		
		companyDao.delete(company.getId());
		
		assertNull(companyDao.getById(company.getId()));
	}

}














