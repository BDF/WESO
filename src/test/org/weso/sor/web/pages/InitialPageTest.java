package org.weso.sor.web.pages;

import org.springframework.test.context.ContextConfiguration;
import org.weso.sor.domain.AbstractSorJUnit38SpringContextTests;
import org.weso.sor.utils.SpringPageTester;

@ContextConfiguration(locations = {
		"file:///C:/Development/webProjects/weso/WebContent/WEB-INF/ApplicationContextDao.xml",
		"file:///C:/Development/webProjects/weso/WebContent/WEB-INF/ApplicationContext.xml" })
public class InitialPageTest extends AbstractSorJUnit38SpringContextTests {
	public void testCreateLoginPage() throws Exception {
		try {
			String appPackage = "org.weso.sor.web";
			String appName = "app";
			SpringPageTester tester = new SpringPageTester(appPackage, appName,
					"../weso/WebContent/", applicationContext);
			// PageTester tester = new PageTester(appPackage, appName,
			// "WebContent");
			Object doc = tester.renderPage("ContactInfoPage");
			System.out.println(doc.getClass().toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		// assertEquals(doc.getElementById("id1").getChildText(), "hello");
	}
	
	public void testCreateLoginPage2() throws Exception {
		try {
			String appPackage = "org.weso.sor.web";
			String appName = "app";
			SpringPageTester tester = new SpringPageTester(appPackage, appName,
					"../weso/WebContent/", applicationContext);
			// PageTester tester = new PageTester(appPackage, appName,
			// "WebContent");
			Object doc = tester.renderPage("ContactInfoPage");
			System.out.println(doc.getClass().toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		// assertEquals(doc.getElementById("id1").getChildText(), "hello");
	}
}
