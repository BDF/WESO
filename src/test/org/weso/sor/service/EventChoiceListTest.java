package org.weso.sor.service;

import java.util.List;

import org.springframework.test.context.ContextConfiguration;
import org.weso.sor.domain.AbstractSorJUnit38SpringContextTests;
import org.weso.sor.model.Events;

@ContextConfiguration(locations = { 
		"file:///C:/Development/webProjects/weso/WebContent/WEB-INF/ApplicationContextDao.xml",
		"file:///C:/Development/webProjects/weso/WebContent/WEB-INF/ApplicationContext.xml"})
public class EventChoiceListTest extends AbstractSorJUnit38SpringContextTests {

	public void testLoadEventsByGrade() {
		EventChoiceList ecl = (EventChoiceList) applicationContext.getBean("eventChoiceList");
		
		List<Events> events = ecl.loadEventsByGrade(2);
		assertTrue(events.size() > 0);
		
		events = ecl.loadEventsByGrade(3);
		assertTrue(events.size() > 0);
		
		events = ecl.loadEventsByGrade(4);
		assertTrue(events.size() > 0);
		
		events = ecl.loadEventsByGrade(5);
		assertTrue(events.size() > 0);
	}

}
