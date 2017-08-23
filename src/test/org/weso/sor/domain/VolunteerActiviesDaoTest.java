package org.weso.sor.domain;

import java.util.List;

import org.weso.sor.domain.hibernate3.VolunteerActivitiesDaoImpl;
import org.weso.sor.model.VolunteerActivities;



public class VolunteerActiviesDaoTest extends
		AbstractSorJUnit38SpringContextTests {

	
	public void testLoadActivites() {
		
		VolunteerActivitiesDaoImpl vad = (VolunteerActivitiesDaoImpl) applicationContext.getBean("volunteerActivitiesDao");
		List<VolunteerActivities> vas = vad.loadVolunteerActivities();
		assertTrue(vas.size() > 0);
		
	}
}
