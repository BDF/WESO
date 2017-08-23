package org.weso.sor.domain;

import java.util.List;

import org.springframework.test.annotation.Rollback;
import org.weso.sor.model.Events;
import org.weso.sor.model.Student;

public class StudentEventChoicesDaoTest extends AbstractSorJUnit38SpringContextTests {

	@Rollback(false)
	public void xtestAddStudentEventChoice() {
		fail("Not yet implemented");
	}

	public void testAddStudentEventChoice2() {
		final Student student = addTestStudent();
		final List<Events> events = findEventsForGrade(5);
		final StudentEventChoicesDao sec = (StudentEventChoicesDao) applicationContext.getBean("studentEventChoicesDao");
		sec.addStudentEventChoice(student, events.get(0), 2);
		
		
	}

}
