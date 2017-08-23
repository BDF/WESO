package org.weso.sor.domain;

import java.util.List;

import org.springframework.test.annotation.Rollback;
import org.weso.sor.model.EventToGrade;
import org.weso.sor.model.Events;


public class EventsToGradeDaoTest extends AbstractSorJUnit38SpringContextTests {

	@Rollback(true)
	public void testAddEventToGrade() {
		final EventToGradeDao etgDao = (EventToGradeDao) applicationContext.getBean("eventToGradeDao");
		final EventToGrade etg = etgDao.addEventToGrade("Barge Building", 5);
		assertNotNull(etg);
	}
	
	public void testFindSomeEventToGradeChoices() {
		for (int grade =2; grade < 6; grade++) {
			List<Events> events = findEventsForGrade(grade);
			assertTrue("Failed to find events for grade " + grade, events.size() > 0);
		}
		List<Events> events = findEventsForGrade(5);
		for (Events events2 : events) {
			System.out.println(events2.getEventName());
		}
		
	}
	
	@Rollback(false)
	public void xxxtestAddDataToEventToGrade() {
		final EventToGradeDao etgDao = (EventToGradeDao) applicationContext.getBean("eventToGradeDao");
		etgDao.addEventToGrade("A is for Anatomy", 2);
		etgDao.addEventToGrade("A is for Anatomy", 3);
		etgDao.addEventToGrade("A is for Anatomy", 4);
		etgDao.addEventToGrade("A is for Anatomy", 5);
		
		etgDao.addEventToGrade("Barge Building", 2);
		
		etgDao.addEventToGrade("Circuit Wizardry", 4);
		etgDao.addEventToGrade("Circuit Wizardry", 5);
		
		etgDao.addEventToGrade("Chopper Challenge", 4);
		etgDao.addEventToGrade("Chopper Challenge", 5);
		
		etgDao.addEventToGrade("Estimania", 2);
		etgDao.addEventToGrade("Estimania", 3);
		etgDao.addEventToGrade("Estimania", 4);
		etgDao.addEventToGrade("Estimania", 5);
		
		etgDao.addEventToGrade("Map Reading", 2);
		etgDao.addEventToGrade("Map Reading", 3);
		etgDao.addEventToGrade("Map Reading", 4);
		etgDao.addEventToGrade("Map Reading", 5);
		
		etgDao.addEventToGrade("Monster Match", 2);
		
		etgDao.addEventToGrade("Mystery Architecture", 2);
		etgDao.addEventToGrade("Mystery Architecture", 3);
		etgDao.addEventToGrade("Mystery Architecture", 4);
		etgDao.addEventToGrade("Mystery Architecture", 5);
		
		etgDao.addEventToGrade("Pentathlon", 2);
		etgDao.addEventToGrade("Pentathlon", 3);
		etgDao.addEventToGrade("Pentathlon", 4);
		etgDao.addEventToGrade("Pentathlon", 5);
		
		etgDao.addEventToGrade("Puff Mobiles", 2);
		etgDao.addEventToGrade("Puff Mobiles", 3);
		
		etgDao.addEventToGrade("Rock Hound", 2);
		etgDao.addEventToGrade("Rock Hound", 3);
		etgDao.addEventToGrade("Rock Hound", 4);
		etgDao.addEventToGrade("Rock Hound", 5);
		
		etgDao.addEventToGrade("Science Jeopardy", 4);
		etgDao.addEventToGrade("Science Jeopardy", 5);
		
		etgDao.addEventToGrade("Sink or Float", 2);
		
		etgDao.addEventToGrade("Straw Tower", 3);
		etgDao.addEventToGrade("Straw Tower", 4);
		etgDao.addEventToGrade("Straw Tower", 5);
		
		etgDao.addEventToGrade("Water Rockets", 3);
		etgDao.addEventToGrade("Water Rockets", 4);
		etgDao.addEventToGrade("Water Rockets", 5);
		
		etgDao.addEventToGrade("What Went By", 2);
		etgDao.addEventToGrade("What Went By", 3);
		
		etgDao.addEventToGrade("Write It, Build It", 3);
		etgDao.addEventToGrade("Write It, Build It", 4);
		etgDao.addEventToGrade("Write It, Build It", 5);
		
		etgDao.addEventToGrade("Potions", 4);
		etgDao.addEventToGrade("Potions", 5);
	}

}
