package org.weso.sor.service;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.weso.sor.domain.AbstractSorJUnit38SpringContextTests;
import org.weso.sor.model.Guardian;

@ContextConfiguration(locations = { 
		"file:///C:/Development/webProjects/weso/WebContent/WEB-INF/ApplicationContextDao.xml",
		"file:///C:/Development/webProjects/weso/WebContent/WEB-INF/ApplicationContext.xml"})
public class GuardianManagerTest extends AbstractSorJUnit38SpringContextTests {

	@Rollback
	public void testAddGuardian() {
		GuardianManager gMngr = (GuardianManager) applicationContext.getBean("guardianManager");
		Guardian guardian = new Guardian();
		guardian.setFirstName("Jack");
		guardian.setLastName("Frost");
		guardian.setPrimaryEmailAddress("test@test.com");
		guardian.setPrimaryPhoneNumber("734-555-1212");
		guardian.setUserName("BDF");
		gMngr.addGuardian(guardian, null);
	}

	public void xtestDoesUserExist() {
		GuardianManager gMngr = (GuardianManager) applicationContext.getBean("guardianManager");
		assertNotNull(gMngr);
	}

	public void xtestAttachGuardian() {
		GuardianManager gMngr = (GuardianManager) applicationContext.getBean("guardianManager");
		assertNotNull(gMngr);
	}

}
