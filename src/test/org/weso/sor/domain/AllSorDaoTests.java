package org.weso.sor.domain;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllSorDaoTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.weso.sor.domain");
		//$JUnit-BEGIN$
		suite.addTestSuite(EventsDaoTest.class);
		suite.addTestSuite(EventsToGradeDaoTest.class);
		suite.addTestSuite(GradesDaoTest.class);
		suite.addTestSuite(GuardianDaoTest.class);
		suite.addTestSuite(StudentDaoTest.class);
		suite.addTestSuite(StudentEventChoicesDaoTest.class);
		suite.addTestSuite(StudentToGuardianDaoTest.class);
		suite.addTestSuite(TeacherDaoTest.class);
		//$JUnit-END$
		return suite;
	}

}
