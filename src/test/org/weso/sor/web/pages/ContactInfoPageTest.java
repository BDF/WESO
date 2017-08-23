package org.weso.sor.web.pages;

import org.weso.sor.model.Guardian;

import junit.framework.TestCase;

public class ContactInfoPageTest extends TestCase {

	public void testThatGuardianTwoCopiesPhotoPermissionCorrectly() {
		final Guardian gOne = new Guardian();
		gOne.setPhotoPermisson(true);
		
		ContactInfoPage cip = new ContactInfoPage();
		Guardian gTwo = cip.buildGuardianTwo(gOne);
		assertTrue(gTwo.isPhotoPermisson());
	}

}
