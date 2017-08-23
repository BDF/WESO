package org.weso.sor.service;

import java.util.List;

import org.springframework.test.context.ContextConfiguration;
import org.weso.sor.domain.AbstractSorJUnit38SpringContextTests;
import org.weso.sor.model.VolunteerActivities;



@ContextConfiguration(locations = { 
		"file:///C:/Development/webProjects/weso/WebContent/WEB-INF/ApplicationContextDao.xml",
		"file:///C:/Development/webProjects/weso/WebContent/WEB-INF/ApplicationContext.xml"})
public class VolunteerManagerTest extends AbstractSorJUnit38SpringContextTests {

	public void testLoadVolunteerChoices() {
		final VolunteerManager vm = (VolunteerManager) applicationContext.getBean("volunteerManager");
		List<VolunteerActivities> vas = vm.loadVolunteerChoices();
		assertNotNull(vas);
		assertTrue(vas.size() >0 );
		
		
	}

}
