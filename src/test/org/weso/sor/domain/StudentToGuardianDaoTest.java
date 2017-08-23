package org.weso.sor.domain;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.weso.sor.model.Grade;
import org.weso.sor.model.Guardian;
import org.weso.sor.model.Student;
import org.weso.sor.model.StudentToGuardian;
import org.weso.sor.model.Teacher;

@TestExecutionListeners( { TransactionalTestExecutionListener.class })
@Transactional
@ContextConfiguration(locations = { "file:///C:/Development/webProjects/weso/WebContent/WEB-INF/ApplicationContextDao.xml" })
public class StudentToGuardianDaoTest extends AbstractJUnit38SpringContextTests {

	@Rollback(true)
	public void testAddStudentToGuardian() {
		final ApplicationContext apC = applicationContext;
		final GradesDao gradesDao = (GradesDao) apC.getBean("gradesDao");
		final StudentDao studentDao = (StudentDao) apC.getBean("studentDao");
		final TeacherDao teacherDao = (TeacherDao) apC.getBean("teacherDao");
		final List<Grade> grades = gradesDao.loadGrades();
		final Teacher teacher = teacherDao.find("Taylor");

		final Student aStudent = studentDao.addStudent(
				teacher, grades.get(0), "Forester23", "Celeste23", "777-234-2345", "Child/Small", 2);
		final GuardianDao gd = (GuardianDao) apC.getBean("guardianDao");
		final Guardian guardian = gd.addGuardian(
				"bdf", "Forester", "Brian", "ysgarran@yahoo.com", "734-555-1212", true, "Adult XXXL");
		final StudentToGuardianDao stgDao = 
			(StudentToGuardianDao) apC.getBean("studentToGuardianDao");
		stgDao.addStudentToGuardian(guardian, aStudent);

		final SessionFactory sf = (SessionFactory) apC.getBean("sessionFactory");
		final Session session = SessionFactoryUtils.getSession(sf, false);
		session.evict(aStudent);
		final Student bS = studentDao.findStudent("Forester23", "Celeste23");
		assertNotNull(bS);

		final Set<StudentToGuardian> stdntToGrdn = bS.getStudentToGuardians();
		assertNotNull(stdntToGrdn);
		assertEquals(1, stdntToGrdn.size());

		StudentToGuardian stg = stdntToGrdn.iterator().next();
		assertNotNull(stg.getStudent());
		assertNotNull(stg.getGuardian());
		assertEquals("Celeste23", stg.getStudent().getFirstName());
		assertEquals("bdf", stg.getGuardian().getUserName());
	}
}
