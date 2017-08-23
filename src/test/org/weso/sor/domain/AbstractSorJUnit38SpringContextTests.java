package org.weso.sor.domain;


import java.util.List;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.weso.sor.model.Events;
import org.weso.sor.model.Grade;
import org.weso.sor.model.Student;
import org.weso.sor.model.Teacher;

@TestExecutionListeners( { TransactionalTestExecutionListener.class })
@Transactional
@ContextConfiguration(locations = { "file:///C:/Development/webProjects/weso/WebContent/WEB-INF/ApplicationContextDao.xml" })
public abstract class AbstractSorJUnit38SpringContextTests extends AbstractJUnit4SpringContextTests {

	protected Student addTestStudent() {
		TeacherDao teacherDao = (TeacherDao) applicationContext.getBean("teacherDao");
		Teacher teacher = teacherDao.find("Taylor");
		
		GradesDao gradesDao = (GradesDao) applicationContext.getBean("gradesDao");
		List<Grade> grades = gradesDao.loadGrades();
		Grade grade = grades.get(0);
		
		final StudentDao studentDao = (StudentDao) applicationContext.getBean("studentDao");
		Student aStudent = studentDao.addStudent(teacher, grade, "Forester23", "Celeste23", "777-234-2345", "Child/Small", 2);
		return aStudent;
	}
	
	protected List<Grade> getGrades() {
		final GradesDao gradesDao = (GradesDao) applicationContext.getBean("gradesDao");
		final List<Grade> grades = gradesDao.loadGrades();
		return grades;
	}

	protected List<Events> findEventsForGrade(int gradeNumber) {
		final EventsDao eDao = (EventsDao) applicationContext.getBean("eventsDao");
		assertNotNull(eDao);
		final List<Events> eventList = eDao.findEvents(gradeNumber);
		return eventList;
	}
}
