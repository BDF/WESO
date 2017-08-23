package org.weso.sor.web.pages;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllWebPageTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.weso.sor.web.pages");
		//$JUnit-BEGIN$
		suite.addTestSuite(InitialPageTest.class);
		suite.addTestSuite(ContactInfoPageTest.class);
		//$JUnit-END$
		return suite;
	}

}
