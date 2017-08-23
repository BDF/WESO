package org.weso.sor.service;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.weso.sor.domain.AbstractSorJUnit38SpringContextTests;


@ContextConfiguration(locations = { 
		"file:///C:/Development/webProjects/weso/WebContent/WEB-INF/ApplicationContextDao.xml",
		"file:///C:/Development/webProjects/weso/WebContent/WEB-INF/ApplicationContext.xml"})
public class StudentManagerTest extends AbstractSorJUnit38SpringContextTests {

	@Rollback
	public void testGetTeachers() {
		StudentManager stdntMgr = (StudentManager) applicationContext.getBean("studentManager");
		assertNotNull(stdntMgr);
	}

}
