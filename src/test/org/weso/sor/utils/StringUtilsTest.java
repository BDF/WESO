package org.weso.sor.utils;

import junit.framework.TestCase;

/**
 * @author bforester
 */
public class StringUtilsTest extends TestCase {

	public void testHasLength() {
		final StringUtils strUtils = new StringUtils();
		assertFalse(strUtils.hasLength(""));
		assertFalse(strUtils.hasLength(null));
		assertTrue(strUtils.hasLength("a"));
	}
	
	public void testRequiresLength() {
		final StringUtils strUtils = new StringUtils();
		strUtils.requiresLength("yesIDo", "testField");
		
		try {
			final String iHaveNoLength = "";
			strUtils.requiresLength(iHaveNoLength, "testField");
			fail("Should have thrown an Illegal Argument Exception");
		} catch (IllegalArgumentException iae) {
			assertEquals("testField is a required field", iae.getMessage());
		}
		
		try {
			final String iAmNull = null;
			strUtils.requiresLength(iAmNull, "testField");
			fail("Should have thrown an Illegal Argument Exception");
		} catch (IllegalArgumentException iae) {
			assertEquals("testField is a required field", iae.getMessage());	
		}
	}
}
