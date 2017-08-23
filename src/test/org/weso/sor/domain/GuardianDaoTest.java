package org.weso.sor.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.weso.sor.model.Guardian;
import org.weso.sor.model.GuardianVolunteerChoices;
import org.weso.sor.model.StudentToGuardian;
import org.weso.sor.model.VolunteerActivities;

@TestExecutionListeners( { TransactionalTestExecutionListener.class })
@Transactional
@ContextConfiguration(locations = { "file:///C:/Development/webProjects/weso/WebContent/WEB-INF/ApplicationContextDao.xml" })
public class GuardianDaoTest extends AbstractJUnit38SpringContextTests {

	@Rollback
	public void testExceptionsThrownWhenMissingData() {
		final GuardianDao gd = (GuardianDao) applicationContext
				.getBean("guardianDao");
		gd.addGuardian("userName", "lastName", "firstName", "emailAddress",
				"primaryPhone", true, "Adult XXXL");

		try {
			gd.addGuardian("userName", "lastName", "firstName", "",
					"primaryPhone", true, "Adult XXXL");
			fail("Email address is required.");
		} catch (IllegalArgumentException iae) {
		}
		try {
			gd.addGuardian("userName", "lastName", "", "emailAddress",
					"primaryPhone", true, "Adult XXXL");
			fail("first name is required.");
		} catch (IllegalArgumentException iae) {
		}
		try {
			gd.addGuardian("userName", "", "firstName", "emailAddress",
					"primaryPhone", true, "Adult XXXL");
			fail("last name is required.");
		} catch (IllegalArgumentException iae) {
		}
		try {
			gd.addGuardian("", "lastName", "firstName", "emailAddress",
					"primaryPhone", true, "Adult XXXL");
			fail("user name is required.");
		} catch (IllegalArgumentException iae) {
		}
		try {
			gd.addGuardian("userName", "lastName", "firstName", "emailAddress",
					"", true, "Adult XXXL");
			fail("primaryPhone is required.");
		} catch (IllegalArgumentException iae) {
		}

	}

	@Rollback
	public void testAddGuardian() {
		final GuardianDao gd = (GuardianDao) applicationContext
				.getBean("guardianDao");
		final Guardian guard = gd
				.addGuardian("userName", "lastName", "firstName",
						"emailAddress", "734-555-1212", true, "Adult XXXL");
		assertNotNull(guard);
		assertEquals("userName", guard.getUserName());
		assertEquals("lastName", guard.getLastName());
		assertEquals("firstName", guard.getFirstName());
		assertEquals("emailAddress", guard.getPrimaryEmailAddress());
		assertEquals("734-555-1212", guard.getPrimaryPhoneNumber());
	}

	@Rollback
	public void testAddDuplicateUserFails() {
		final GuardianDao gd = (GuardianDao) applicationContext
				.getBean("guardianDao");
		final Guardian guard = gd
				.addGuardian("userName", "lastName", "firstName",
						"emailAddress", "734-555-1212", true, "Adult XXXL");
		assertNotNull(guard);
		final Guardian guard2 = gd
				.addGuardian("userName", "lastName", "firstName",
						"emailAddress", "734-555-1212", true, "Adult XXXL");
		assertNull(guard2);

	}

	@Rollback
	public void testDoesUserExistFalse() {
		final GuardianDao gd = (GuardianDao) applicationContext
				.getBean("guardianDao");
		final boolean doesUserExist = gd.doesUserExist("userTest");
		assertFalse(doesUserExist);
	}

	@Rollback
	public void testDoesUserExistTrue() {
		final GuardianDao gd = (GuardianDao) applicationContext
				.getBean("guardianDao");
		final boolean doesUserExistFalse = gd.doesUserExist("userTest");
		assertFalse(doesUserExistFalse);

		final Guardian guard = gd
				.addGuardian("userTest", "lastName", "firstName",
						"emailAddress", "734-555-1212", true, "Adult XXXL");
		assertNotNull(guard);

		final boolean doesUserExistTrue = gd.doesUserExist("userTest");
		assertTrue(doesUserExistTrue);
	}

	@Rollback
	public void testListGuardians() {
		final GuardianDao gd = (GuardianDao) applicationContext
				.getBean("guardianDao");
		final List<Guardian> guardians = gd.listGuardians();
		final StringBuilder builder = new StringBuilder();

		builder.append("Parent, ");
		builder.append("PayForTShirts, ");
		builder.append("Primary eMail, ");
		builder.append("SecondaryEmail, ");
		builder.append("SecondaryEmail, ");
		builder.append("PrimaryPhone, ");
		builder.append("SecondaryPhone, ");
		builder.append("StudentOne, ");
		builder.append("StudentTwo");
		System.out.println(builder.toString());
		for (Guardian guardian : guardians) {
			builder.setLength(0);

			builder.append("\"");
			builder.append(
					guardian.getFirstName() + " " + guardian.getLastName())
					.append("\"").append(", ");

			builder.append(guardian.getPayForTShirts()).append(", ");
			builder.append(guardian.getPrimaryEmailAddress()).append(", ");
			builder.append(guardian.getSecondaryEmailAddress()).append(", ");
			builder.append(guardian.getPrimaryPhoneNumber()).append(", ");
			builder.append(guardian.getSecondaryPhoneNumber()).append(", ");
			builder.append(guardian.getTShirtSize()).append(", ");
			Set<StudentToGuardian> stgs = guardian.getStudentToGuardians();
			for (StudentToGuardian stg : stgs) {
				builder.append("\"");
				builder.append(stg.getStudent().getFirstName()).append(" ");
				builder.append(stg.getStudent().getLastName()).append(" ");
				builder.append("\"");
				builder.append(", ");
			}
			builder.setLength(builder.length() - 2);
			System.out.println(builder.toString());
		}

	}

	/**
	 * Lists Parent volunteer activities.
	 */
	public void testListVolunteer() {
		final GuardianDao gd = (GuardianDao) applicationContext.getBean("guardianDao");
		final VolunteerActivitiesDao vda = (VolunteerActivitiesDao) applicationContext.getBean("volunteerActivitiesDao");
		final List<Guardian> guardians = gd.listGuardians();
		final Set<String> sortedNames = new TreeSet<String>();
		final StringBuilder builder = new StringBuilder();
		builder.append("Name").append(", ");
		builder.append("Photo Permission").append(", ");
		for (VolunteerActivities va : vda.loadVolunteerActivities()) {
			sortedNames.add(va.getName());
		}
		
		for (String name : sortedNames) {
			builder.append(name).append(", ");
		}
		builder.setLength(builder.length() - 2);
		builder.append("\n");
		
		for (Guardian guardian : guardians) {
			final Map<String, String> nameToYesOk = new HashMap<String, String>(); 
			final Set<String> gChoices = new HashSet<String>(); 
			builder.append(guardian.getFirstName() + " ").append(guardian.getLastName()).append(", ");
			builder.append(guardian.isPhotoPermisson()).append(", ");
			final Set<GuardianVolunteerChoices> gvcs = guardian.getGuardianVolunteerChoiceses();
			for (GuardianVolunteerChoices gvc : gvcs) {
				VolunteerActivities vas = gvc.getVolunteerActivities();
				final String vName = vas.getName();
				gChoices.add(vName);
				switch (gvc.getRanking()) {
				case 0:
					nameToYesOk.put(vName, "Yes");
					break;
				case 1:
					nameToYesOk.put(vName, "Ok");
					break;
				default:
						nameToYesOk.put(vName, "WTF");
				}
			}
			for (String name: sortedNames) {
				final String found;
				if (gChoices.contains(name)) {
					final String yesOk = nameToYesOk.get(name);
					found = yesOk;
				} else {
					found = "No";
				}
				builder.append(found).append(", ");					
			}
			builder.setLength(builder.length() - 2);
			builder.append("\n");
		}

		System.out.println(builder.toString());
	}
}
