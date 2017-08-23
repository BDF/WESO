package org.weso.sor.domain;

import java.util.List;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.weso.sor.model.Grade;
import org.weso.sor.model.Teacher;

@TestExecutionListeners( { TransactionalTestExecutionListener.class })
@Transactional
@ContextConfiguration(locations = { "file:///C:/Development/webProjects/weso/WebContent/WEB-INF/ApplicationContextDao.xml" })
public class TeacherDaoTest extends AbstractJUnit38SpringContextTests {

	@Rollback
	public void testLoadAllTeachers() {
		TeacherDao teacherDao = (TeacherDao) applicationContext.getBean("teacherDao");
		teacherDao.getTeachers();
		final Grade grade = new Grade(2);
		final List<Teacher> secondGradeTeachers = teacherDao.getTeachers(grade);
		assertNotNull(secondGradeTeachers );
		assertEquals(2, secondGradeTeachers.size());
		
		assertEquals("Copes", secondGradeTeachers.get(0).getTeacherName());
		assertEquals("Taylor", secondGradeTeachers.get(1).getTeacherName());
	}
	
	public void testFindTeacherByGradeId() {
		final GradesDao gradesDao = (GradesDao) applicationContext.getBean("gradesDao");
		final Grade grade =  gradesDao.loadGrade(Integer.valueOf(2));
		final TeacherDao teacherDao = (TeacherDao) applicationContext.getBean("teacherDao");
		teacherDao.getTeachers();
		final List<Teacher> secondGradeTeachers = teacherDao.getTeachers(grade.getGradeId());
		assertNotNull(secondGradeTeachers );
		assertEquals(2, secondGradeTeachers.size());
		
		assertEquals("Copes", secondGradeTeachers.get(0).getTeacherName());
		assertEquals("Taylor", secondGradeTeachers.get(1).getTeacherName());
	}
	
	public void testFindTeacherByTeacherId() {
		final TeacherDao teacherDao = (TeacherDao) applicationContext.getBean("teacherDao");
		List<Teacher>  teachers = teacherDao.getTeachers();
		Teacher teacher = teacherDao.loadTeacher(teachers.get(0).getTeacherId());
		assertNotNull(teacher);
	}
	
}
