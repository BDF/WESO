package org.weso.sor.domain;

import java.util.List;

import org.springframework.test.annotation.Rollback;
import org.weso.sor.model.Events;

public class EventsDaoTest extends AbstractSorJUnit38SpringContextTests {

	@Rollback
	public void testFindEvents() {
		final int gradeNumber = 3;
		final List<Events> eventList = findEventsForGrade(gradeNumber);
		for (Events events : eventList) {
			System.out.println(events.getEventName());
		}
	}

	protected List<Events> findEventsForGrade(int gradeNumber) {
		final EventsDao eDao = (EventsDao) applicationContext.getBean("eventsDao");
		assertNotNull(eDao);
		final List<Events> eventList = eDao.findEvents(gradeNumber);
		return eventList;
	}
	
	public void testFindEventByName() {
		final EventsDao eDao = (EventsDao) applicationContext.getBean("eventsDao");
		assertNotNull(eDao);
		Events  event = eDao.findEventByName("Chopper Challenge");
		assertNotNull(event);
		assertEquals("Chopper Challenge", event.getEventName());
		
	}

}
